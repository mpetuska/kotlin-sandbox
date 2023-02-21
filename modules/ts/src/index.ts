import {App, TerraformStack, TerraformVariable} from "cdktf"
import {Construct} from "constructs"


class MyStack extends TerraformStack {
    constructor(scope: Construct, id: string) {
        super(scope, id)
        const myVar = new TerraformVariable(this, "my_var", {
            description: "Hey there",
        })
        console.log(myVar)
    }
}

console.log(TerraformStack)

const app = new App({
  outdir: "./dist/cdktf"
})
const stack = new MyStack(app, "ctd-infra")
app.synth()