grammar Data;

@header {
package antlr.taiji;
import java.util.Set;
import java.util.HashSet;
}

file  : group+;
group : CHAR sequence[$CHAR.text.charAt(0)];

sequence[int n]
locals [int i = 0]
      : ( {$i<$n}? CHAR {$i++;} ) *
      ;

CHAR: .;

//WS: [ \t\r\n]+ -> skip;
