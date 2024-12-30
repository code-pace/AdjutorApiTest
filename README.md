Rest-Assured Test Automation For Adjutor API Service
=======================================

**Overview**
This project contains automated tests for the Lendsqr Adjutor API using Rest Assured, a Java-based library for testing RESTful services. These tests are designed to ensure the reliability, performance, and correctness of the API responses.

**Project Setup**
***Prerequisites***
- Java JDK 8 or higher
- Maven (for dependency management)
- An IDE like IntelliJ IDEA or Eclipse

***Installation***
1. Clone the Repository:
``
git clone https://github.com/code-pace/AdjutorApiTest.git
``
2. Navigate to the Project Directory:
``
cd adjutor
``
3. Build the Project:
``
mvn clean install
``
**Running Tests**
***Using Maven***
4. To run all tests:
``
mvn test
``
This command will download all necessary dependencies and compile the project.

**Test Coverage**
***Here's a brief overview of what's currently tested:***
- Validation: Initialize BVN Consent, Complete Consent and get BVN Details
- Credit Bureaus: Get Credit Report from CRC Credit Bureau, Get Credit Report from FirstCentral Credit Bureau
- Decisioning: Get Decision Models, Get Decision Model Details, Oraculi Borrower Scoring
- Embedded Loans and Payments: Get loan products, Initialize loan application
- Data for Lenders: Options, Users
- Operational Services: Get Adjutor Services Pricing, Get Wallet
- Direct Debit: Get all banks, Get details of a bank
- Kolo Transaction Data [Beta]
- Core Services [Beta]

**Configuration**
***Environment variables are configured on testng.xml file:***
- On the testng file, you will have to provide your api_token. This was removed for security 
  reasons.
- Test can be executed asynchronously by increasing the thread parameter.

