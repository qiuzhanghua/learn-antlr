package cn.com.taiji.learn;

public class DataVisitor extends antlr.taiji.DataBaseVisitor<String> {
    @Override
    public String visitGroup(antlr.taiji.DataParser.GroupContext ctx) {
        return visit(ctx.sequence());
    }

    @Override
    public String visitSequence(antlr.taiji.DataParser.SequenceContext ctx) {
        StringBuffer sb = new StringBuffer();
        ctx.CHAR().forEach(node -> sb.append(node.getText()));
//        System.out.println(sb.toString());
        return sb.toString();
    }
}
