grammar GoobScraper;

program: statment+;

statment: '/get' get ';'                   #GetStatment
        | '/extract' extract ';'    #ExtractStatment
        | '/update' update word? time ';'  #UpdateStatment
        | '/alert' alert time ';'          #AlertStatment
        ;

get : (word)                       #RegularGet
    | 'url' (word)                 #GetURL
    | ('tables' | 'table') (word)? #GetTable
    ;

extract : 'append' (word)? (word)   #ExtractAppend
        |  'new'  (word)? (word)    #ExtractNew
        ;

update : 'append'   #UpdateAppend
       | 'new' #UpdateNew
       ;

alert : word    #AlertWord
      |         #AlertEmpty
      ;

time : NUMBER ('sec' | 'min' | 'hrs' | 'day' | 'mon');

word : ID    #WordID
    | NUMBER #WordNumber
    | STRING #WordString
    ;

STRING : '"' (~[\r\n"])* '"';
ID     : [A-Za-z]+ ;
NUMBER : [0-9]+ ;
WS     : [ \n\t\r]+ -> skip;
