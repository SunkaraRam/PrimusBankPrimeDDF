$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FBlogin.feature");
formatter.feature({
  "line": 1,
  "name": "Fblogin Functionality test",
  "description": "",
  "id": "fblogin-functionality-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "I am validating FbLogin functionality",
  "description": "\r\nGiven: I launch fb url on Chrombrowser\r\n\r\nWhen: I enter username\r\n\r\nWhen: I enter password\r\n\r\nAnd: I click On login button\r\n\r\nThen: I Validating the Loginfunctionality",
  "id": "fblogin-functionality-test;i-am-validating-fblogin-functionality",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login Scenarios",
  "description": "",
  "id": "login-scenarios",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login functionality validation",
  "description": "",
  "id": "login-scenarios;login-functionality-validation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I loggin into primusbank url on Chrome",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I select branch dropdown",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I enter uid in usernameField",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter pwd in passwordField",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click on loginButton",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I wait for LogoutButton",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I validate the title of the Home page",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "I close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.i_loggin_into_primusbank_url_on_Chrome()"
});
formatter.result({
  "duration": 12361935444,
  "error_message": "org.openqa.selenium.WebDriverException: chrome not reachable\n  (Session info: chrome\u003d76.0.3809.100)\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027RAMSUNKARA\u0027, ip: \u0027192.168.173.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 76.0.3809.100, chrome: {chromedriverVersion: 75.0.3770.8 (681f24ea911fe7..., userDataDir: C:\\Users\\SUNKAR~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:64349}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 36a7811f9ced0a13210ea850ec004376\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:276)\r\n\tat stepDefinitions.stepDefinitions.i_loggin_into_primusbank_url_on_Chrome(stepDefinitions.java:21)\r\n\tat ✽.When I loggin into primusbank url on Chrome(Login.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "stepDefinitions.i_select_branch_dropdown()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinitions.i_enter_uid_in_usernameField()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinitions.i_enter_pwd_in_passwordField()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinitions.i_click_on_loginButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinitions.i_wait_for_LogoutButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinitions.i_validate_the_title_of_the_Home_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinitions.i_close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
});