# 🛒 E-commerce Website Test Automation with Selenium (Using Java, TestNG, and POM)

## 🚀 Project Overview

This project is a complete end-to-end automation test suite for the [Magento Demo E-commerce Website](https://magento.softwaretestingboard.com/).  
It is developed using **Java**, **Selenium WebDriver**, **TestNG**, and follows the **Page Object Model (POM)** design pattern to ensure reusability, readability, and maintainability of the test code.

---

## 📌 Objective

- Automate the core features of the Magento e-commerce platform
- Ensure functionalities like user signup, login, product search, cart, checkout, payment, and logout are properly tested
- Report all functional and UI bugs through a consolidated testing report

---

## 🔧 Project Type

**Type:** Automated Functional & UI Testing  
**Scope:** Frontend Functional Flows  
**Automation Type:** UI Automation Testing  
**Design Pattern:** Page Object Model (POM)

---

## 🌐 Tested Website

URL: [Magento Demo Store](https://magento.softwaretestingboard.com/)

---

## 🚀 Key Features Tested

- ✅ User Signup with valid and invalid inputs
- ✅ User Login with positive and negative flows
- ✅ Product Search (empty and valid terms)
- ✅ Add to Cart and update quantity
- ✅ Checkout process and address handling
- ✅ Payment method visibility
- ✅ Responsive layout testing
- ✅ Logout functionality
- ✅ Header structure and element validation
- ✅ Country & currency switcher validation

---

## 📁 Folder Structure

MagentoStoreTestingWithSelenium/
├── pages/ # Page Object Model classes
├── tests/ # TestNG test cases
├── test-output/ # TestNG report output
├── screenshots/ # (Optional) Screenshots folder
├── README.md # Project documentation
└── pom.xml # Maven dependencies (if used)

---

## 📝 Documentation

- **🧪 Test Plan**: Describes the scope, objectives, approach, and deliverables of testing
- **🧾 Test Scenarios & Cases**: Detailed step-by-step cases for all major features
- **🐞 Bug Report**: Logs all bugs found with severity, description, and reproduction steps
- **📊 Summary Report**: Final stats of total executed, passed, failed test cases

---

## 📄 Test Reports

- **Manual Test Report**: [https://drive.google.com/file/d/1zPKm3bJv8f-b9GKEyPEw7CfEytfhTY3E/view?usp=sharing]
- **Project Video Walkthrough**: [https://drive.google.com/file/d/1NSy_76Nkg1hp10JRaPxjL2-qtFXBaiTj/view?usp=sharing]

---

## 💻 How to Run the Project

```bash
# 1. Clone the repository
git clone https://github.com/rajeevsingh456/MagentoStoreTestingWithSelenium.git

# 2. Open the project in Eclipse or IntelliJ

# 3. Run the main test class
Right-click on `AllTests.java` in the tests folder → Run as → TestNG Test
Usage
Run tests from the TestNG suite or directly from individual test classes

View results in the console and /test-output/ directory

Reports include screenshots and assertion logs (if configured)

🐞 Bug Highlights
Bug ID	Title	Severity	Found By	Module
BUG-001	No validation on empty search	Medium	Manual + Automation	Search
BUG-002	Missing COD payment method	High	Manual + Automation	Payment Page
BUG-003	Phone login not available	Medium	Manual + Automation	Login
BUG-004	Layout issues on mobile view	Medium	Manual Only	Responsive UI
BUG-005	Currency switcher missing	High	Manual + Automation	Header

📊 Test Execution Summary
Category	Total	Passed	Failed	Bugs Found
Manual Test Cases	15	11	4	5
Automated Scripts	7	7	0	4

📌 API Used
No API testing included. Tests were performed on the live static UI.

📈 Expected Outcome
Stable and reusable test automation framework

Full test coverage of core Magento e-commerce flows

Documentation and bug reporting to help stakeholders improve site reliability

👤 Author
Rajeev Singh
SDET Trainee at Masai School
GitHub: rajeevsingh456


📬 Suggestions or Contributions
Feel free to raise issues or submit pull requests if you'd like to enhance the framework or report bugs.

⭐ Final Verdict
✅ Automation Passed: All test scripts executed successfully
❌ Critical Bugs Detected: Search, payment, login issues, and layout problems on small screens
🔁 Recommendation: Fix bugs before going to production for a smoother user experience.
```
