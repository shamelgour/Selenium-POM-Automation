This is test framework for Confluence.

Its built using Java TestNG and webdriver.

It is built as a maven project.

All tests are under src/test/java/com.qa.confluence.test

Base class and page classes are other utility classes are under src/main/java

config.properties has username password and browser details.

Extent report library is used for generating reports.

Web driver evnet listner is used for log generation.

To run the project:
------------------
Clone the repository.

git clone https://shamelgour@bitbucket.org/shamelgour/confluenceautomationrepo-interview.git

Use your IDE to import ConfluenceTest as Maven project (I am using eclipse).

Build the project.

Test suite can be run from resources/testng.xml 

This includes New page tests and Existing Page Tests.

Besides testNG run report, this has extent report by name "Confluence-test-Report.html" under test-output.

Detailed logs are available in console.

In case of any failures, screenshot would be taken at the step when failure occurred and stored under screenshots
folder for analysis.

------------------------------------------------------------------------------------------------------------------
