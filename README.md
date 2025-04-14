# CSC4104-Achref_Aziz_Marwen
# Absence Management System

This project is a Java-based Absence Management System developed using **Eclipse IDE**, **JUnit**, and **Cucumber** for behavior-driven development (BDD). It allows students to submit and manage absence requests, track usage limits, and upload justifications.

## 🚀 Features

- Submit absence requests (with monthly and total limits)
- Special handling for female students (monthly authorized absence)
- Prevent absences on restricted days (CC/CF)
- Upload and validate justifications (valid/invalid files)
- Request cancellation (pending vs approved)
- Joker module refund system for absence credits
- Visual feedback (notifications, error and warning messages)

## 🧪 Testing

This project uses **Cucumber** for BDD-style tests and **JUnit** for assertions. Feature files are located in the `features/` directory and step definitions in `stepDefinitions/`.

To run tests:

1. Right-click the project in Eclipse
2. Choose **Run As** > **JUnit Test**

## 📦 Requirements

- Java 11+
- Eclipse IDE
- Cucumber Plugin for Eclipse
- JUnit 5

## 🌐 GitHub Setup

This repository is connected to GitHub. To push local changes:
```bash
git add .
git commit -m "Your message here"
git push origin main 
