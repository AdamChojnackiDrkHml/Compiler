package comp;

import gen.languageBaseVisitor;
import gen.languageParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class LanguageVisitor extends languageBaseVisitor<Variable>
{
    DataHandler dataHandler = new DataHandler();
    CodeGenerator cg = new CodeGenerator();
    String lastPID = "";
    @Override public Variable visitDeclare_Start(languageParser.Declare_StartContext ctx)
    {
        this.visit(ctx.declarations());
        this.visit(ctx.commands());
        cg.writeEnd();
        System.out.println(cg.sb.toString());

        return null;
    }

    @Override public Variable visitNodeclare_Start(languageParser.Nodeclare_StartContext ctx)
    {
        this.visit(ctx.commands());
        cg.writeEnd();
        System.out.println(cg.sb.toString());
        return null;
    }

    @Override
    public Variable visitPut_Table1(languageParser.Put_Table1Context ctx)
    {
        dataHandler.setLocation(ctx.PIDENTIFIER().getSymbol().getLine(), ctx.PIDENTIFIER().getSymbol().getCharPositionInLine());
        dataHandler.addArray(ctx.PIDENTIFIER().getText(), Integer.parseInt(ctx.left.getText()), Integer.parseInt(ctx.right.getText()));
        this.visit(ctx.declarations());
        return null;
    }

    @Override
    public Variable visitPut_Symbol1(languageParser.Put_Symbol1Context ctx)
    {
        dataHandler.setLocation(ctx.PIDENTIFIER().getSymbol().getLine(), ctx.PIDENTIFIER().getSymbol().getCharPositionInLine());
        dataHandler.addSymbol(ctx.PIDENTIFIER().getText());
        this.visit(ctx.declarations());
        return null;
    }

    @Override
    public Variable visitPut_Table2(languageParser.Put_Table2Context ctx)
    {
        dataHandler.setLocation(ctx.PIDENTIFIER().getSymbol().getLine(), ctx.PIDENTIFIER().getSymbol().getCharPositionInLine());
        dataHandler.addArray(ctx.PIDENTIFIER().getText(), Integer.parseInt(ctx.left.getText()), Integer.parseInt(ctx.right.getText()));
        return null;
    }

    @Override public Variable visitPut_Symbol2(languageParser.Put_Symbol2Context ctx)
    {
        dataHandler.setLocation(ctx.PIDENTIFIER().getSymbol().getLine(), ctx.PIDENTIFIER().getSymbol().getCharPositionInLine());
        dataHandler.addSymbol(ctx.PIDENTIFIER().getText());
        return null;
    }

    @Override public Variable visitCommands(languageParser.CommandsContext ctx)
    {
        return visitChildren(ctx);
    }

    @Override public Variable visitAssign_Statement(languageParser.Assign_StatementContext ctx)
    {
        dataHandler.initVariable(lastPID);

        Variable ex = this.visit(ctx.identifier());
        this.visit(ctx.expression());
        cg.assign(ex);
        return ex;
    }

    @Override
    public Variable visitIf_Statement(languageParser.If_StatementContext ctx)
    {
        return visitChildren(ctx);
    }

    @Override
    public Variable visitWhile_Statement(languageParser.While_StatementContext ctx)
    {
        return visitChildren(ctx);
    }

    @Override
    public Variable visitRepeat_Statement(languageParser.Repeat_StatementContext ctx)
    {
        return visitChildren(ctx);
    }

    @Override
    public Variable visitFor_Statement(languageParser.For_StatementContext ctx)
    {
        dataHandler.addIterator(ctx.PIDENTIFIER().getText());

        return visitChildren(ctx);
    }

    @Override
    public Variable visitRead_Statement(languageParser.Read_StatementContext ctx)
    {
        cg.read(this.visit(ctx.identifier()));
        return null;
    }

    @Override
    public Variable visitWrite_Statement(languageParser.Write_StatementContext ctx)
    {
        cg.write(this.visit(ctx.value()));
        return null;
    }

    @Override
    public Variable visitElse_Statement(languageParser.Else_StatementContext ctx)
    {
        return visitChildren(ctx);
    }

    @Override
    public Variable visitIF_StatementEnd(languageParser.IF_StatementEndContext ctx)
    {
        return visitChildren(ctx);
    }

    @Override
    public Variable visitEval_Value(languageParser.Eval_ValueContext ctx)
    {
        cg.getConstant(this.visit(ctx.value()));
        return visitChildren(ctx.value());
    }

    @Override
    public Variable visitCalculate_Value(languageParser.Calculate_ValueContext ctx)
    {
        switch(ctx.operator.getText())
        {
            case "PLUS": cg.add(this.visit(ctx.left), this.visit(ctx.right)); break;
            case "MINUS": cg.sub(this.visit(ctx.left), this.visit(ctx.right)); break;
            case "MUL": cg.mul(this.visit(ctx.left), this.visit(ctx.right)); break;
            case "DIV": cg.div(this.visit(ctx.left), this.visit(ctx.right)); break;
            case "MOD": cg.mod(this.visit(ctx.left), this.visit(ctx.right)); break;
        }
        return visitChildren(ctx);
    }

    @Override
    public Variable visitCalculate_Bool(languageParser.Calculate_BoolContext ctx)
    {
        //TODO
        return visitChildren(ctx);
    }

    @Override
    public Variable visitGet_Number(languageParser.Get_NumberContext ctx)
    {
        return dataHandler.getValue(Integer.parseInt(ctx.NUM().getText()));
    }

    @Override
    public Variable visitGet_Identifier(languageParser.Get_IdentifierContext ctx)
    {
        this.visit(ctx.identifier());
        if(dataHandler.checkVariable(lastPID))
        {
            return this.visit(ctx.identifier());
        }

        return null;
    }

    @Override
    public Variable visitGet_PIDENTIFIER(languageParser.Get_PIDENTIFIERContext ctx)
    {
        dataHandler.setLocation(ctx.PIDENTIFIER().getSymbol().getLine(), ctx.PIDENTIFIER().getSymbol().getCharPositionInLine());
        lastPID = ctx.PIDENTIFIER().getText();
        return dataHandler.getVariable(ctx.PIDENTIFIER().getText());
    }

    @Override
    public Variable visitGet_ArrayMemberByPID(languageParser.Get_ArrayMemberByPIDContext ctx)
    {
        List<TerminalNode> pidList = ctx.PIDENTIFIER();
        dataHandler.setLocation(pidList.get(0).getSymbol().getLine(), pidList.get(0).getSymbol().getCharPositionInLine());
        lastPID = pidList.get(1).getText();
        return dataHandler.getArrValVar(pidList.get(0).getText(), pidList.get(1).getText());
    }

    @Override
    public Variable visitGet_ArrayMemberByVal(languageParser.Get_ArrayMemberByValContext ctx)
    {
        dataHandler.setLocation(ctx.PIDENTIFIER().getSymbol().getLine(), ctx.PIDENTIFIER().getSymbol().getCharPositionInLine());
        lastPID = ctx.PIDENTIFIER().getText();
        return dataHandler.getArrValVar(ctx.PIDENTIFIER().getText(), ctx.NUM().getText());
    }

}
