package cn.com.taiji.learn;

import antlr.taiji.ExprBaseVisitor;

import java.util.LinkedHashMap;
import java.util.Map;

public class EvalVisitor extends ExprBaseVisitor<Integer> {
    Map<String, Integer> memory = new LinkedHashMap<>();

    public Integer visitPrintExpr(antlr.taiji.ExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return 0;
    }


    public Integer visitAssign(antlr.taiji.ExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    public Integer visitDiv(antlr.taiji.ExprParser.DivContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);
        return left / right;
    }


    public Integer visitAdd(antlr.taiji.ExprParser.AddContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);
        return left + right;
    }


    public Integer visitParentheses(antlr.taiji.ExprParser.ParenthesesContext ctx) {
        return visit(ctx.expr());
    }


    public Integer visitMult(antlr.taiji.ExprParser.MultContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);
        return left * right;
    }

    public Integer visitId(antlr.taiji.ExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) return memory.get(id);
        return 0;
    }


    public Integer visitInt(antlr.taiji.ExprParser.IntContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

    public Integer visitMinus(antlr.taiji.ExprParser.MinusContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);
        return left - right;
    }
}
