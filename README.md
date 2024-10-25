# Final Task Automation Project

This project automates login functionality tests on SauceDemo using Selenium WebDriver.

## Task Description

Automates three user scenarios:
- **UC-1**: Empty credentials - verifies error message "Username is required".
- **UC-2**: Only username entered - verifies error message "Password is required".
- **UC-3**: Valid login - verifies successful login to the "Swag Labs" dashboard.

- ### Prerequisites
- **Java**: JDK 17.0.6 or later.
- **Maven**: Project build tool.
- **Browsers**: Chrome and Firefox (WebDriverManager handles binaries).

### Execute Tests

To run all tests:

```bash
mvn test
```
Alternatively, to run specific TestNG XML suites:

```bash
mvn -DsuiteXmlFile=src/test/resources/suites/full-test-suite.xml test
```

