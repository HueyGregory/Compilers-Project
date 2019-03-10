grammar GoobScraper;

program: statment+;

statment: '/get' (word) ';' #GetStatment
        | '/get' 'url'? (word) ';' #GetURLStatment
        | '/extract' ('append' | 'merge')? (word) ';' #ExtractStatment
        | '/update' word? time ';'  #UpdateStatment
        ;

time: NUMBER ('sec' | 'min' | 'hrs' | 'day' | 'mon');
word : (ID | NUMBER | STRING) ;

STRING : '"' (~[\r\n"] | '""')* '"';
ID     : [A-Za-z]+ ;
NUMBER : [0-9]+ ;
WS     : [ \n\t\r]+ -> skip;
