"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const cdktf_1 = require("cdktf");
class MyStack extends cdktf_1.TerraformStack {
    constructor(scope, id) {
        super(scope, id);
        const myVar = new cdktf_1.TerraformVariable(this, "my_var", {
            description: "Hey there",
        });
        console.log(myVar);
    }
}
console.log(cdktf_1.TerraformStack);
const app = new cdktf_1.App({
    outdir: "./dist/cdktf"
});
const stack = new MyStack(app, "ctd-infra");
app.synth();
