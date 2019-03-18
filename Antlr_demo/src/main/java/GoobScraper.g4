grammar GoobScraper;

program: statment+;

statment: '/get' get ';'                   #GetStatment
        | '/extract' extract (word) ';'    #ExtractStatment
        | '/update' update word? time ';'  #UpdateStatment
        | '/alert' alert time ';'          #AlertStatment
        ;

get : (word)                       #RegularGet
    | 'url' (word)                 #GetURL
    | ('tables' | 'table') (word)? #GetTable
    ;

extract : 'append'   #ExtractAppend
        | 'merge'    #ExtractMerge
        | 'replace'  #ExtractReplace
        |            #ExtractEmpty
        ;

update : 'append'   #UpdateAppend
       | 'merge'   #UpdateMerge
       | 'replace' #UpdateReplace
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
