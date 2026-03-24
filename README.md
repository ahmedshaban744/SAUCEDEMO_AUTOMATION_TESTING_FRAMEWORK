# 🧪 SAUCEDEMO AUTOMATION TESTING FRAMEWORK

## 📌 OVERVIEW

This project is an automated testing framework developed to validate the functionality of the SauceDemo web application using Selenium WebDriver and TestNG with Maven as the build management tool.

The framework is designed to cover:
- Functional testing  
- Negative testing  
- Data-driven testing  
- Group-based test execution  
- Parallel test execution  

Application under test: https://www.saucedemo.com/

---

## 🎯 OBJECTIVES

- Validate user authentication (valid and invalid scenarios)
- Verify product selection and cart functionality
- Test checkout workflow and form validations
- Ensure correctness of payment calculations
- Detect UI and functional defects
- Provide scalable and maintainable test structure

---

## 🛠️ TECHNOLOGIES USED

- Java  
- Selenium WebDriver  
- TestNG  
- WebDriverManager  
- Maven  
- ChromeDriver  
- GitHub (Version Control)

---

## 📂 PROJECT STRUCTURE
src/
└── test/
└── java/
├── InvalidTestCase/
│ ├── CheckOutForm.java
│ └── logginPageInvalid.java
│
├── validTestCase/
│ ├── HomePageValid.java
│ ├── logginPage.java
│ └── PymentsValidScenarios.java  


---

## 🧪 TEST COVERAGE

### ✅ LOGIN TESTS
- Valid login with multiple user types  
- Invalid login scenarios  
- Validation of error messages  

### 🏠 HOME PAGE TESTS
- Add all products to cart  
- Validate cart badge count  
- Burger menu functionality  
- Logout functionality  
- Social media link navigation  

### 🛒 CHECKOUT TESTS
- Checkout form validation with invalid inputs  
- Successful checkout flow  
- Error handling for missing or incorrect data  

### 💰 PAYMENT TESTS
- Validate total price calculation  
- Verify tax and final total consistency  
- Confirm successful order completion  

---

## 📊 TEST DESIGN APPROACH

- Data-driven testing using `@DataProvider`  
- Separation of valid and invalid test scenarios  
- Explicit and implicit waits for synchronization  
- Assertion-based validation using TestNG  
- Modular and organized test classes  

---

## ⚙️ TESTNG SUITES

The project includes multiple TestNG XML suites to control execution:

### 1. ALL TEST CASES SUITE
- Executes all test classes  
- Supports parallel execution of methods  

### 2. INVALID TEST SUITE
- Executes negative test scenarios  
- Covers login and checkout validation cases  

### 3. HOME PAGE SUITE
- Executes tests grouped under:
groups = "Home Page"
- Focuses on UI and functional validation of the home page  

### 4. PAYMENTS SUITE
- Executes tests grouped under:
groups = "pyments"
- Focuses on checkout and payment validation  

---

## ⚡ PARALLEL EXECUTION

- Configured using TestNG:
  - `parallel="methods"`
  - `thread-count` defined per suite  
- Improves execution performance by running tests concurrently  

---


---

## 🚀 HOW TO RUN THE PROJECT

### Prerequisites
- Java 23  
- Maven installed  
- Chrome browser installed  

### Steps

1. Clone the repository:

git clone https://github.com/ahmedshaban744/Testing.git
cd Testing
mvn clean test

✅ Now this version will:
- Render correctly on GitHub  
- Show proper headings on new lines  
- Be clean and professional  
- Look good in your portfolio  

---

If you want next level 🚀 I can:
- Add **badges (build, tests, Selenium, Java)**  
- Add **screenshots section + demo GIF**
- Or upgrade this into a **top-tier portfolio README that impresses recruiters**





