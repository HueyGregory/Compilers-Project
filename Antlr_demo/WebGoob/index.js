console.log("Begin");
const antlr4 = require('antlr4');
const GoobLexer = require('./lib/GoobScraperLexer').GoobScraperLexer;
const GoobParser = require('./lib/GoobScraperParser').GoobScraperParser;
const GooberScraperVisitor = require('./GoobVisitor').GoobVisitor;
const io = require('console-read-write');


async function main() {
    while (true) {
        // Simple readline scenario
        const input = await io.read();

        const chars = new antlr4.InputStream(input);
        const lexer = new GoobLexer(chars);
        const tokens = new antlr4.CommonTokenStream(lexer);
        const parser = new GoobParser(tokens);
        parser.buildParseTrees = true;
        // create parse tree of input
        const tree = parser.program();
        //create and run visitor
        const goober = new GooberScraperVisitor();
        goober.visit(tree);
    }
}

main();


console.log("End");