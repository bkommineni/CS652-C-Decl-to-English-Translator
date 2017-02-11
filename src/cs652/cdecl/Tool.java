package cs652.cdecl;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tool {

	public static class CDeclFileLoader extends CDeclBaseListener{

	}

	public static void main(String[] args) {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = stdin.readLine();
			translate(input);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static String translate(String cdeclText) {

		ANTLRInputStream inputStream = new ANTLRInputStream(cdeclText);
		CDeclLexer lexer = new CDeclLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		CDeclParser parser = new CDeclParser(tokenStream);
		ParseTree tree = parser.declaration();

		EnglishGenerator visitor = new EnglishGenerator();
		String englishStmt = visitor.visit(tree);
		return englishStmt;
	}
}
