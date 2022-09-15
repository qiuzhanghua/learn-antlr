grammar BeijingCode;

@header {
package antlr.taiji;
}

init : 'BJID' chan=seq[4] type=seq[4] ps1=ps ps2=ps extra=seq[3] EOF;

ps : CHAR seq[$CHAR.text.charAt(0)];    // Pascal String

seq[int n]
locals [int i = 1]
      : ( {$i<=$n}? CHAR {$i++;} ) *
      ;
CHAR: .;
