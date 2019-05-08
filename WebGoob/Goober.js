const GoobScraperVisitor = require('./lib/GoobScraperVisitor');
class Goober extends GoobScraperVisitor {
    constructor() {
        super();
        console.log("Testing");
    }
}
module.exports = Goober;