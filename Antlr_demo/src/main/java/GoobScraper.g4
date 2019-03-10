grammar GoobScraper;

program: statment+;

statment: '/get' (word) ';' #GetStatment
        | '/get' 'url'? (word) ';' #GetURLStatment
        | '/extract' ('append' | 'merge')? (word) ';' #ExtractStatment
        | '/update' word? time ';'  #UpdateStatment
        ;

time: NUMBER TIMES;
word : (ID | NUMBER | STRING) ;

STRING : '"' (~[\r\n"] | '""')* '"';
ID     : [A-Za-z]+ ;
NUMBER : [0-9]+ ;
WS     : [ \n\t\r]+ -> skip;


TIMES  : SECONDS | MINUTES | HOURS | DAYS | MONTHS;
SECONDS: 's' | 'sec' | 'second' | 'seconds';
MINUTES: 'min' | 'minute' | 'minutes';
HOURS  : 'h' | 'hr' | 'hrs' | 'hour' | 'hours';
DAYS   : 'd' | 'day' | 'days';
MONTHS : 'mon' | 'month' | 'months';
