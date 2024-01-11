const glob = require("glob");
const Mocha = require("mocha");

const mocha = new Mocha({
  parallel: false,
  timeout: 23000,
  reporter: "allure-mocha",
  reporterOptions: {
    resultsDir: "allure-results",
  },
});

glob.sync("Tests/**/*.js").forEach((file) => mocha.addFile(file));
mocha.run((failures) => process.exit(failures === 0 ? 0 : 1));