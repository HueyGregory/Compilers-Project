console.log("Begin");
const antrl4 = require('antlr4');
const GoobLexer = require('./lib/GoobScraperLexer').GoobScraperLexer;
const GoobParser = require('./lib/GoobScraperParser').GoobScraperParser;

const input = "";
const chars = new antlr4.InputStream();
const lexer = new GoobLexer(chars);
const token = new antlr4.CommonTokenStream(lexer);
const parser = new GoobParser(tokens);
parser.buildParseTrees = true;
// create parse tree of input
const tree = parser.program();

class Goober {
    constructor() {
        console.log("Testing");
    }
}

//create and run visitor
const goober = new Goober();
goober.visit(tree);


console.log("End");