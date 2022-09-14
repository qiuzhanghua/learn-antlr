package cn.com.taiji.learn;

public class ShortToUnicodeString extends antlr.taiji.ArrayInitBaseListener {
    private final StringBuffer sb = new StringBuffer();

    public void enterValue(antlr.taiji.ArrayInitParser.ValueContext ctx) {
        int value = Integer.parseInt(ctx.INT().getText());
        sb.append((char)(value));
//        sb.append(String.format("\\u%04x", value));
    }

    public String  getResult() {
        return sb.toString();
    }
}
