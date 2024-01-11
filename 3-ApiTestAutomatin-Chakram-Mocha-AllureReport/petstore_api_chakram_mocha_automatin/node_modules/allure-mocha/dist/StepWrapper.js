"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.StepWrapper = void 0;
class StepWrapper {
    constructor(reporter, step) {
        this.reporter = reporter;
        this.step = step;
    }
    startStep(name) {
        const step = this.step.startStep(name);
        this.reporter.pushStep(step);
        return new StepWrapper(this.reporter, step);
    }
    endStep() {
        this.reporter.popStep();
        this.step.endStep();
    }
    run(body) {
        return this.step.wrap(body)();
    }
}
exports.StepWrapper = StepWrapper;
//# sourceMappingURL=StepWrapper.js.map