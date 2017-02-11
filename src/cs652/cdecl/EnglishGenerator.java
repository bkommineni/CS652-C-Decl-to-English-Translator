package cs652.cdecl;


public class EnglishGenerator extends CDeclBaseVisitor<String> {

    @Override
    public String visitDeclaration(CDeclParser.DeclarationContext ctx) {

        return visit(ctx.declarator()) + visit(ctx.typename());
    }

    @Override
    public String visitVoid(CDeclParser.VoidContext ctx) {
        return "nothing";
    }

    @Override
    public String visitFloat(CDeclParser.FloatContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitInt(CDeclParser.IntContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitKey(CDeclParser.KeyContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public String visitArray(CDeclParser.ArrayContext ctx) {

        return  visit(ctx.declarator()) + "array of ";
    }

    @Override
    public String visitFunc(CDeclParser.FuncContext ctx) {

        return  visit(ctx.declarator()) + "function returning ";
    }

    @Override
    public String visitVar(CDeclParser.VarContext ctx) {

        return ctx.ID().getText() + " is a ";
    }

    @Override
    public String visitPointer(CDeclParser.PointerContext ctx) {

        return  visit(ctx.declarator()) + "pointer to ";
    }

    @Override
    public String visitGrouping(CDeclParser.GroupingContext ctx) {
        return  visit(ctx.declarator());
    }
}
