grammar GoobScraper;

program: statment+;

statment: '/get' (word) ';' #GetStatment
        | '/get' 'url' (word) ';' #GetURLStatment
        | '/get' ('tables' | 'table') (word)? ';' #GetTableStatment
        | '/extract' ('append' | 'merge' | 'replace')? (word) ';' #ExtractStatment
        | '/update' ('append' | 'merge' | 'replace') word? time ';'  #UpdateStatment
        | '/alert' word time ';' #AlertStatment
        ;

time: NUMBER ('sec' | 'min' | 'hrs' | 'day' | 'mon');
word : (ID | NUMBER | STRING) ;

STRING : '"' (~[\r\n"] | '""')* '"';
ID     : [A-Za-z]+ ;
NUMBER : [0-9]+ ;
WS     : [ \n\t\r]+ -> skip;
