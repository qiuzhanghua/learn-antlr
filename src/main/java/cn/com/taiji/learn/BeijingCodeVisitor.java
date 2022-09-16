package cn.com.taiji.learn;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class BeijingCodeVisitor extends antlr.taiji.BeijingCodeBaseVisitor<String> {

    public String visitSeq(antlr.taiji.BeijingCodeParser.SeqContext ctx) {
        StringBuffer sb = new StringBuffer();
        ctx.CHAR().forEach(node -> sb.append(node.getText()));
        return sb.toString();
    }

    public String visit(ParseTree tree) {
        return null;
    }

    public String visitChildren(RuleNode node) {
        return null;
    }

    public String visitTerminal(TerminalNode node) {
        return null;
    }


    public String visitErrorNode(ErrorNode node) {
        return null;
    }
}
