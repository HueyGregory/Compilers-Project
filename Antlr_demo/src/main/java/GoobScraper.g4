grammar GoobScraper;

program: statment + EOF;

statment: keyword ('url')? (word)+ #GetStatment
        |
;

keyword : '/' ('get' | 'extract' | 'update');
word : (ID | NUMBER)+ ;

ID     : [a-z]+ ;
NUMBER : [0-9]+ ;
WS     : [ \n\t\r]+ -> skip;