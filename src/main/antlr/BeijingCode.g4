grammar BeijingCode;

@header {
package antlr.taiji;
}

init : 'BJID'                   // 固定
        chan=seq[4]             // 发码方
        type=seq[4]             // 码属性
        attr=seq[2]             // 类型
        id=ps                   // 长度+身份标识
        name=ps                 // 扩展域样例，长度+姓名，对于加密，应该是这两个字段合一后加密
//        sec=ps                  // (id + name)加密后的Pascal类型的字符串
//        skey=ps                 // 长度+秘钥编号
        ts=seq[4]               // 时间戳
        exp=seq[4]              // 过期时长
        manner=CHAR             // 验签方式
        signature=ps            // 签名信息
        digit=seq[72]           // 数字签名
        ver=seq[4]              // 版本
        EOF;

ps : CHAR seq[$CHAR.text.charAt(0)];    // Pascal String

seq[int n]
locals [int i = 1]
      : ( {$i<=$n}? CHAR {$i++;} ) *
      ;
CHAR: .;