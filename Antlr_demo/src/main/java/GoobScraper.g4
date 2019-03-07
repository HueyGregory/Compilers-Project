grammar GoobScraper;

program: statment + EOF;

statment: '/get' 'url' (word)+ #
        | '/get'(word)+ #GetStatment
        ;

word : (ID | NUMBER)+ ;

ID     : [a-z]+ ;
NUMBER : [0-9]+ ;
WS     : [ \n\t\r]+ -> skip;