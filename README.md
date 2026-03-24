🧪 SauceDemo Automation Testing Framework
📌 Overview

This is a Test Automation Framework built using Selenium WebDriver, TestNG, and Maven to validate the functionality of the SauceDemo web application.

The framework is designed to support:

Functional testing
Data-driven testing
Parallel test execution
Group-based test execution
Scalable test suite organization

🔗 Application Under Test: https://www.saucedemo.com/

🎯 Key Features
Automated UI testing using Selenium WebDriver
TestNG-based test management
Data-driven testing using @DataProvider
Grouping of test cases (Smoke, Home Page, Payments, etc.)
Parallel execution using TestNG suites
Modular test structure (Valid / Invalid scenarios)
Maven-based dependency management
🛠️ Technologies Used
Java
Selenium WebDriver
TestNG
WebDriverManager
Maven
ChromeDriver
GitHub        
🧪 Test Design Approach
✅ Valid Test Cases
Successful login scenarios
Add to cart functionality
Checkout process
Payment validation
Social media navigation
❌ Invalid Test Cases
Invalid login credentials
Empty or incorrect checkout inputs
Form validation error messages
⚙️ TestNG Suites

The project uses multiple TestNG XML suites to control execution:

1️⃣ All Test Cases Suite
Runs all test classes
Uses parallel execution (methods, thread-count=6)
2️⃣ Invalid Test Suite
Executes only negative test scenarios
Focus on:
Login validation
Checkout form validation
3️⃣ Home Page Suite
Uses groups filtering
Runs tests tagged with:
        groups = "Home Page"
4️⃣ Payments Suite

Runs payment-related tests using group:

         groups = "pyments"
Validates:
Checkout flow
Total price calculation
🚀 How to Run the Project
🔹 Prerequisites
Java 23 (as configured in POM)
Maven installed
Chrome browser installed
🔹 Clone Repository
git clone https://github.com/ahmedshaban744/Testing.git
cd Testing
🔹 Run Using Maven
mvn clean test
🔹 Run Using TestNG Suite

You can run any of the XML suites:

All Test Cases.xml
Invalid.xml
Home Page.xml
Payments.xml

Run from IDE or via TestNG configuration.

📦 Maven Configuration

The project uses the following dependencies:

Selenium Java
TestNG
WebDriverManager

Managed via Maven pom.xml, which ensures:

Automatic dependency resolution
Consistent environment setup
Easy project build
⚡ Parallel Execution

Configured using TestNG:

parallel="methods"
thread-count="X"
Improves execution time by running tests concurrently
📊 Test Organization
Tests grouped by functionality:
Home Page
payments
Smoke
Supports selective execution using groups in TestNG suites
📈 Future Improvements
Implement Page Object Model (POM) design pattern
Add reporting (Allure / Extent Reports)
Add logging framework (Log4j / SLF4J)
Integrate CI/CD pipeline (GitHub Actions / Jenkins)
Add cross-browser testing
Improve driver configuration handling
👤 Author

Ahmed Shaban Mohamed

✅ Summary

This framework demonstrates:

Real-world automation structure
Scalable test design
Grouping + parallel execution
Data-driven testing
Maven-based project management
