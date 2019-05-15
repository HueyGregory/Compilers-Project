const antlr4 = require('antlr4');
const GoobScraperVisitor = require('./lib/GoobScraperVisitor').GoobScraperVisitor;
/**constructor*/
var GoobVisitor = function(){
    // inherit default visitor
    GoobScraperVisitor.call(this);
    return this;
};
// have prototype "extend" SimpleMathVisitor, and then "override" functions
GoobVisitor.prototype = Object.create(GoobScraperVisitor.prototype);
GoobVisitor.prototype.constructor = GoobVisitor;
//a map in JavaScript
//CalculatorVisitor.prototype.memory= new Map();
 /*Functions for each expression:*/
GoobVisitor.prototype.visitGetURL = function(ctx) {
    //var value = this.visit(ctx.visitGetURL());
    var url = ctx.word().getText().replace(/\"/g, "");
    //var value = this.visit(ctx.word().getText());
    console.log("Value is : " + url);
    return url;
};
exports.GoobVisitor = GoobVisitor;