grammar HelloWorld;         // 定义一个名为HelloWorld的语法
@header {
 package cn.javayong.antlr.hellworld.autogen;
 }
r  : 'hello' ID ;           // 定义一个语法规则，匹配一个关键字hello和一个紧随其后的标识符
ID : [a-z]+ ;               // 匹配小写字母组成的标识符
WS : [ \t\r\n]+ -> skip ;   // 忽略空格、Tab、换行以及\r

