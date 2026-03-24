🧪 SauceDemo Automation Testing Framework
📌 Overview

This project is an automated testing framework developed to validate the functionality of the SauceDemo web application using Selenium WebDriver and TestNG with Maven as the build management tool.

The framework is designed to cover:

Functional testing
Negative testing
Data-driven testing
Group-based test execution
Parallel test execution

Application under test: https://www.saucedemo.com/

🎯 Objectives
Validate user authentication (valid and invalid scenarios)
Verify product selection and cart functionality
Test checkout workflow and form validations
Ensure correctness of payment calculations
Detect UI and functional defects
Provide scalable and maintainable test structure
🛠️ Technologies Used
Java
Selenium WebDriver
TestNG
WebDriverManager
Maven
ChromeDriver
GitHub (Version Control)
📂 Project Structure
src/
 └── test/
     └── java/
         ├── InvalidTestCase/
         │   ├── CheckOutForm.java
         │   └── logginPageInvalid.java
         │
         ├── validTestCase/
         │   ├── HomePageValid.java
         │   ├── logginPage.java
         │   └── PymentsValidScenarios.java
🧪 Test Coverage
✅ Login Tests
Valid login with multiple user types
Invalid login scenarios
Validation of error messages
🏠 Home Page Tests
Add all products to cart
Validate cart badge count
Burger menu functionality
Logout functionality
Social media link navigation
🛒 Checkout Tests
Checkout form validation with invalid inputs
Successful checkout flow
Error handling for missing or incorrect data
💰 Payment Tests
Validate total price calculation
Verify tax and final total consistency
Confirm successful order completion
📊 Test Design Approach
Data-driven testing using @DataProvider
Separation of valid and invalid test scenarios
Use of explicit and implicit waits
Assertion-based validation using TestNG
Modular test classes organized by functionality
⚙️ TestNG Suites

The project includes multiple TestNG XML suites to control execution:

1. All Test Cases Suite
Executes all test classes
Supports parallel execution of methods
2. Invalid Test Suite
Executes negative test scenarios
Covers login and checkout validation cases
3. Home Page Suite

Executes tests grouped under:

groups = "Home Page"
Focuses on UI and functional validation of the home page
4. Payments Suite

Executes tests grouped under:

groups = "pyments"
Focuses on checkout and payment validation
⚡ Parallel Execution
Configured using TestNG:
parallel="methods"
thread-count defined per suite
Improves execution performance by running tests concurrently
🚀 How to Run the Project
Prerequisites
Java 23
Maven installed
Chrome browser installed
Steps
Clone the repository:
git clone https://github.com/ahmedshaban744/Testing.git
Navigate to the project directory:
cd Testing
Run tests using Maven:
mvn clean test
Alternatively, run specific TestNG XML suites from your IDE:
All Test Cases
Invalid.xml
Home Page.xml
Payments.xml
⚙️ Maven Configuration

Dependencies are managed using pom.xml, including:

Selenium Java
TestNG
WebDriverManager

This ensures automatic dependency resolution and consistent project builds.

📈 Future Improvements
Implement Page Object Model (POM) design pattern
Add reporting tools (Allure / Extent Reports)
Integrate logging framework (Log4j)
Enable cross-browser testing
Add CI/CD integration (GitHub Actions / Jenkins)
Improve test data management
👤 Author

Ahmed Shaban
