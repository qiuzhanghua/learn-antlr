grammar Rows;

@header {
package antlr.taiji;
import java.util.Set;
import java.util.HashSet;
}

@parser::members {
    int col;
    Set<String> set = new HashSet<>();
    public RowsParser(TokenStream input, int col) {
        this(input);
        this.col = col;
    }

    public Set<String> getResult() {
        return set;
    }
}

file : (row NEWLINE)+ ;
row
locals [int i=0]
    : (  STUFF
         {
           $i++;
           if ($i == col) {
             set.add($STUFF.text);
             System.out.println($STUFF.text);
           }
         }
    )+
    ;

TAB  : '\t' -> skip;
NEWLINE: '\r'? '\n' ;
STUFF : ~[\t\r\n]+ ;

