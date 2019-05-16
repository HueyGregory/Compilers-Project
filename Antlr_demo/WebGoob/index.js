console.log("Begin");
const antlr4 = require('antlr4');
const GoobLexer = require('./lib/GoobScraperLexer').GoobScraperLexer;
const GoobParser = require('./lib/GoobScraperParser').GoobScraperParser;
const GooberScraperVisitor = require('./GoobVisitor').GoobVisitor;

    const input = '/get url "https://www.google.com";';

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

const io = require('console-read-write');

async function main() {
    // Simple readline scenario
    io.write('I will echo whatever you write!');
    io.write(await io.read());

    // Simple question scenario
    io.write(`hello ${await io.ask('Who are you?')}!`);

    // Since you are not blocking the IO, you can go wild with while loops!
    let saidHi = false;
    while (!saidHi) {
        io.write('Say hi or I will repeat...');
        saidHi = await io.read() === 'hi';
    }

    io.write('Thanks! Now you may leave.');
}

main();



console.log("End");