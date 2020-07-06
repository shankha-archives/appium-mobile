$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Login.feature");
formatter.feature({
  "name": "Login scenarios",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "name": "First time user experience or fresh app install",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@splashscreen"
    },
    {
      "name": "@MOB-3204"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "The substitute user launches the app",
  "keyword": "When "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_launches_the_app()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The substitute user lands on the splash screen",
  "keyword": "And "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_lands_on_the_splash_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The substitute user taps the Get Started Button",
  "keyword": "When "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_taps_the_get_started_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The substitute user arrives on the PIN entry screen",
  "keyword": "Then "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_arrives_on_the_pin_entry_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "First time user experience / fresh app install",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@pinunclok"
    },
    {
      "name": "@pinunclok_1"
    },
    {
      "name": "@MOB-3205"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the substitute user launches the app",
  "keyword": "When "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.theSubstituteUserLaunchesTheApp()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Can\u0027t locate an element by this strategy: By.chained({By.xpath: //android.widget.TextView[@text\u003d\u0027Work Without Limits\u0027]})\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:126)\r\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\r\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.isDisplayed(\u003cgenerated\u003e)\r\n\tat mobile.frontline.pages.LoginPage.verify_splashScreenLoaded(LoginPage.java:87)\r\n\tat mobile.frontline.stepdef.LoginStepDef.theSubstituteUserLaunchesTheApp(LoginStepDef.java:56)\r\n\tat ✽.the substitute user launches the app(file:///C:/Users/Rupa.kumari/Documents/Frontline/src/test/resources/Login.feature:13)\r\nCaused by: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction@1e8823d2 (tried for 1 second(s) with 500 milliseconds interval)\r\n\tat org.openqa.selenium.support.ui.FluentWait.timeoutException(FluentWait.java:304)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.waitFor(AppiumElementLocator.java:99)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:119)\r\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\r\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.isDisplayed(\u003cgenerated\u003e)\r\n\tat mobile.frontline.pages.LoginPage.verify_splashScreenLoaded(LoginPage.java:87)\r\n\tat mobile.frontline.stepdef.LoginStepDef.theSubstituteUserLaunchesTheApp(LoginStepDef.java:56)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat io.cucumber.java.Invoker.invoke(Invoker.java:27)\r\n\tat io.cucumber.java.JavaStepDefinition.execute(JavaStepDefinition.java:27)\r\n\tat io.cucumber.core.runner.PickleStepDefinitionMatch.runStep(PickleStepDefinitionMatch.java:63)\r\n\tat io.cucumber.core.runner.TestStep.executeStep(TestStep.java:64)\r\n\tat io.cucumber.core.runner.TestStep.run(TestStep.java:49)\r\n\tat io.cucumber.core.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\r\n\tat io.cucumber.core.runner.TestCase.run(TestCase.java:51)\r\n\tat io.cucumber.core.runner.Runner.runPickle(Runner.java:67)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:149)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:83)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:24)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:185)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:83)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:219)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)\r\n\tat com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)\r\n\tat com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.chained({By.xpath: //android.widget.TextView[@text\u003d\u0027Work Without Limits\u0027]})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DEL1-LHP-N01494\u0027, ip: \u0027192.168.1.8\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: driver.version: AndroidDriver\r\n\tat io.appium.java_client.pagefactory.bys.builder.ByChained.findElement(ByChained.java:74)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat io.appium.java_client.pagefactory.bys.ContentMappedBy.findElement(ContentMappedBy.java:50)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.lambda$0(AppiumElementLocator.java:120)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:172)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:1)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\t... 45 more\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the substitute user passes the splash screen",
  "keyword": "Then "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_passes_the_splash_screen()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the substitute user arrives on the PIN entry screen",
  "keyword": "Then "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.theSubstituteUserArrivesOnThePINEntryScreen()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the substitute user enters the PIN code 7354",
  "keyword": "When "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_enters_the_pin_code_7354()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the substitute user is taken to the Login Page",
  "keyword": "Then "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_is_taken_to_the_login_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", "First time user experience / fresh app install");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Failed Attempts",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@pinunclok"
    },
    {
      "name": "@pinunclok_2"
    },
    {
      "name": "@MOB-3205"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the substitute user launches the app",
  "keyword": "When "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.theSubstituteUserLaunchesTheApp()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Can\u0027t locate an element by this strategy: By.chained({By.xpath: //android.widget.TextView[@text\u003d\u0027Work Without Limits\u0027]})\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:126)\r\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\r\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.isDisplayed(\u003cgenerated\u003e)\r\n\tat mobile.frontline.pages.LoginPage.verify_splashScreenLoaded(LoginPage.java:87)\r\n\tat mobile.frontline.stepdef.LoginStepDef.theSubstituteUserLaunchesTheApp(LoginStepDef.java:56)\r\n\tat ✽.the substitute user launches the app(file:///C:/Users/Rupa.kumari/Documents/Frontline/src/test/resources/Login.feature:21)\r\nCaused by: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction@125c082e (tried for 1 second(s) with 500 milliseconds interval)\r\n\tat org.openqa.selenium.support.ui.FluentWait.timeoutException(FluentWait.java:304)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.waitFor(AppiumElementLocator.java:99)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:119)\r\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:59)\r\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.isDisplayed(\u003cgenerated\u003e)\r\n\tat mobile.frontline.pages.LoginPage.verify_splashScreenLoaded(LoginPage.java:87)\r\n\tat mobile.frontline.stepdef.LoginStepDef.theSubstituteUserLaunchesTheApp(LoginStepDef.java:56)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat io.cucumber.java.Invoker.invoke(Invoker.java:27)\r\n\tat io.cucumber.java.JavaStepDefinition.execute(JavaStepDefinition.java:27)\r\n\tat io.cucumber.core.runner.PickleStepDefinitionMatch.runStep(PickleStepDefinitionMatch.java:63)\r\n\tat io.cucumber.core.runner.TestStep.executeStep(TestStep.java:64)\r\n\tat io.cucumber.core.runner.TestStep.run(TestStep.java:49)\r\n\tat io.cucumber.core.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\r\n\tat io.cucumber.core.runner.TestCase.run(TestCase.java:51)\r\n\tat io.cucumber.core.runner.Runner.runPickle(Runner.java:67)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:149)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:83)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:24)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:185)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:83)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:219)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)\r\n\tat com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)\r\n\tat com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.chained({By.xpath: //android.widget.TextView[@text\u003d\u0027Work Without Limits\u0027]})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DEL1-LHP-N01494\u0027, ip: \u0027192.168.1.8\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: driver.version: AndroidDriver\r\n\tat io.appium.java_client.pagefactory.bys.builder.ByChained.findElement(ByChained.java:74)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat io.appium.java_client.pagefactory.bys.ContentMappedBy.findElement(ContentMappedBy.java:50)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.lambda$0(AppiumElementLocator.java:120)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:172)\r\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:1)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\t... 45 more\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the substitute user passes the splash screen",
  "keyword": "Then "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_passes_the_splash_screen()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the substitute user enters a incorrect PIN code \u00273333\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_enters_a_incorrect_pin_code_3333()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the substitute user enter a incorrect PIN code \u00277777\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_enter_a_incorrect_pin_code_7777()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the substitute user enters a incorrect PIN code \u00275555\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.the_substitute_user_enters_a_incorrect_pin_code_5555()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the substitute user is prompted with a “You may not have access yet” dialog",
  "keyword": "Then "
});
formatter.match({
  "location": "mobile.frontline.stepdef.LoginStepDef.theSubstituteUserIsPromptedWithAYouMayNotHaveAccessYetDialog()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png", "Failed Attempts");
formatter.after({
  "status": "passed"
});
});