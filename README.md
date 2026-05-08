Saucedemo Automation Framework 🚀
This is a professional Selenium Automation Framework designed to test the SauceDemo e-commerce website. The framework is built with a focus on scalability, maintainability, and clear reporting using modern industry standards.

🛠️ Tech Stack
Language: Java (JDK 22)

Testing Framework: TestNG

Automation Tool: Selenium WebDriver

Build Tool: Maven

Reporting: Allure Reports

Logging: Log4j2

Design Pattern: Page Object Model (POM)

✨ Key Features
Data-Driven Testing: Using TestNG @DataProvider to run tests with multiple user credentials from external properties files.

Fluent Wait Mechanism: Custom wait utilities to handle element synchronization efficiently.

Dynamic Reporting: Integrated with Allure for detailed test execution steps and environment info.

Automatic Screenshots: A custom TestListener captures screenshots automatically on test failure.

Thread-Safe Driver: Implemented ThreadLocal for the WebDriver to support parallel execution in the future.

Centralized Configuration: All environment variables (URL, Browser, Credentials) are managed via config.properties.

📁 Project Structure
Plaintext
src
 ├── main
 │    ├── java
 │    │    ├── driverManager (Driver initialization & Factory)
 │    │    ├── pages         (Page Object Classes)
 │    │    └── Utils         (Listeners, Actions, Waits, ConfigReaders)
 │    └── resources          (Config files & Allure properties)
 └── test
      ├── java
      │    └── tests         (Test Classes: Login, E2E flows)
      └── resources          (Log4j configuration & Test data)
🚀 How to Run
Clone the repository:

Bash
git clone https://github.com/Merna-Fadl/Saucedemo_Automation_Framework.git
Install dependencies:

Bash
mvn clean install
Run Tests:

Bash
mvn test
Generate Allure Report:

Bash
allure serve allure-results
📊 Sample Reports
The framework generates visual reports including:

Test status (Pass/Fail/Skip)

Step-by-step execution logs

Embedded screenshots for failed cases
