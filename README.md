<img width="784" height="497" alt="passed - successLogintest_1778264743509" src="https://github.com/user-attachments/assets/a694f621-c36f-45a0-9bab-5f974a624f99" />
<img width="784" height="497" alt="passed - successfulLogoutTest_1778264756178" src="https://github.com/user-attachments/assets/ba0255d4-c1f0-461a-89f7-7b71415092d1" />
<img width="784" height="497" alt="passed - invalidLoginTest_1778264780689" src="https://github.com/user-attachments/assets/4df23cf7-ab7d-495f-9e36-dc14cf78e201" />
<img width="784" height="497" alt="passed - invalidLoginTest_1778264775979" src="https://github.com/user-attachments/assets/6ad40a03-8942-4442-9225-05a88e166327" />
<img width="784" height="497" alt="passed - invalidLoginTest_1778264771449" src="https://github.com/user-attachments/assets/9252bab9-6aad-45c6-9b48-5dc4c1a886c0" />
<img width="784" height="497" alt="passed - invalidLoginTest_1778264766685" src="https://github.com/user-attachments/assets/9b2d8f69-ac1d-4d2d-a031-432544afb98c" />
<img width="784" height="497" alt="passed - invalidLoginTest_1778264761576" src="https://github.com/user-attachments/assets/81224834-ffec-452a-919c-6b37e1896079" />
<img width="784" height="497" alt="passed - invalidCheckoutTest_1778264804311" src="https://github.com/user-attachments/assets/58d8c0f4-ecd0-48ed-b428-b8c849adb477" />
<img width="784" height="497" alt="passed - invalidCheckoutTest_1778264795775" src="https://github.com/user-attachments/assets/ed4cc151-86a0-4e18-ae08-0047315a0223" />
<img width="784" height="497" alt="passed - invalidCheckoutTest_1778264788329" src="https://github.com/user-attachments/assets/e01f142f-5aa9-40a8-a89d-a416bb6c7ea7" />
<img width="784" height="497" alt="passed - completeCheckOutFlow_1778264749166" src="https://github.com/user-attachments/assets/02929c3e-afec-4cc1-bd37-bb4e1ecb73f6" />
<img width="784" height="497" alt="passed - addMultipleProductsFlow_1778264746537" src="https://github.com/user-attachments/assets/1c73c1aa-899a-490f-9e42-5ed00eedf91b" />
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
