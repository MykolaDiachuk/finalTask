# Final Task - SauceDemo Login Testing Automation

## Project Overview
This project automates the login functionality tests for [SauceDemo](https://www.saucedemo.com/) using Selenium WebDriver and TestNG in a Behavior-Driven Development (BDD) approach. The tests are implemented in Java, and the framework uses various tools to achieve multi-browser support, parallel execution, parameterization, and logging.

## Technologies Used
- **Programming Language**: Java
- **Build Tool**: Maven
- **Automation Framework**: Selenium WebDriver
- **Testing Framework**: TestNG with Data Provider for parameterization
- **Logging Framework**: SLF4J with Logback
- **Browser Support**: Chrome, Firefox
- **BDD Tool**: Cucumber
- **Assertions**: AssertJ

## Features and Test Cases
The following test cases verify the behavior of the SauceDemo login form, implemented in the [login.feature file](https://github.com/MykolaDiachuk/finalTask/blob/main/src/test/resources/features/login.feature):

### Test Case UC-1: Empty Credentials
1. Navigate to the login page.
2. Enter any credentials in the "Username" and "Password" fields.
3. Clear both fields.
4. Click the "Login" button.
5. Verify the error message: "Username is required".

### Test Case UC-2: Only Username Provided
1. Navigate to the login page.
2. Enter any credentials in the "Username" field.
3. Leave the "Password" field blank.
4. Click the "Login" button.
5. Verify the error message: "Password is required".

### Test Case UC-3: Valid Credentials
1. Navigate to the login page.
2. Enter the correct username ("standard_user") and password ("secret_sauce").
3. Click the "Login" button.
4. Verify the page title contains "Swag Labs".

### Additional Requirements
- **Parallel Execution**: Implemented via TestNG’s DataProvider and XML suite configuration.
- **Parameterized Browser Testing**: Both Chrome and Firefox are supported.
- **Logging**: SLF4J and Logback used to log each action and result.

### Execute Tests
To execute tests run multi-browser-suite.xml

