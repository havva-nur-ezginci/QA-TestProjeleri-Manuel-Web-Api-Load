"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.MochaAllure = void 0;
const allure_js_commons_1 = require("allure-js-commons");
const StepWrapper_1 = require("./StepWrapper");
class MochaAllure extends allure_js_commons_1.Allure {
    constructor(reporter, runtime) {
        super(runtime);
        this.reporter = reporter;
    }
    get currentExecutable() {
        const executable = this.reporter.currentStep || this.reporter.currentTest || this.reporter.currentExecutable;
        if (!executable) {
            throw new Error("No executable!");
        }
        return executable;
    }
    set currentExecutable(executable) {
        this.reporter.currentExecutable = executable;
    }
    step(name, body) {
        const wrappedStep = this.startStep(name);
        let result;
        try {
            result = wrappedStep.run(body);
        }
        catch (err) {
            wrappedStep.endStep();
            throw err;
        }
        if ((0, allure_js_commons_1.isPromise)(result)) {
            const promise = result;
            return promise
                .then((a) => {
                wrappedStep.endStep();
                return a;
            })
                .catch((e) => {
                wrappedStep.endStep();
                throw e;
            });
        }
        wrappedStep.endStep();
        return result;
    }
    logStep(name, status) {
        this.step(name, () => { });
    }
    attachment(name, content, options) {
        const file = this.reporter.writeAttachment(content, options);
        this.currentExecutable.addAttachment(name, options, file);
    }
    testAttachment(name, content, options) {
        const file = this.reporter.writeAttachment(content, options);
        this.currentTest.addAttachment(name, options, file);
    }
    get currentTest() {
        if (this.reporter.currentTest === null) {
            throw new Error("No test running!");
        }
        return this.reporter.currentTest;
    }
    startStep(name) {
        const allureStep = this.currentExecutable.startStep(name);
        this.reporter.pushStep(allureStep);
        return new StepWrapper_1.StepWrapper(this.reporter, allureStep);
    }
}
exports.MochaAllure = MochaAllure;
//# sourceMappingURL=MochaAllure.js.map