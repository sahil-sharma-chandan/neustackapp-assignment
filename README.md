# Project Setup and Running Instructions

## Overview
This project is an automated testing framework for a web application using Java, Cucumber, and Extent Reports. It follows the Page Object Model (POM) design pattern for organizing test code, and includes comprehensive logging and reporting to help in understanding and analyzing test results.
## Prerequisites

Before running the project, ensure you have the following installed:

1. **Java Development Kit (JDK)**
    - Ensure you have JDK 17 or higher installed.
    - You can download it from [Oracle's JDK Downloads](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/).

2. **Apache Maven**
    - This project uses Maven for dependency management, make sure Maven is installed.
    - You can download it from [Apache Maven](https://maven.apache.org/download.cgi).

3. **Cucumber**
    - Ensure Cucumber is installed if your project uses it for Behavior-Driven Development (BDD). To install the Cucumber Plugin in IntelliJ IDEA:
    - Go to the File menu (or IntelliJ IDEA menu on macOS) at the top-left corner of the window.
    - Select Settings (or Preferences on macOS).
    - In the Settings/Preferences window, find and click on Plugins in the left-hand menu.
    - In the Plugins section, you'll see a search bar at the top of the window. Type Cucumber into the search bar and click on the Install button next to the Cucumber plugin.

4. **Install IntelliJ IDEA**
    - For Windows/macOS/Linux: [Go to the IntelliJ IDEA download page](https://www.jetbrains.com/idea/download/?section=windows).



## Setup

1. **Clone the Repository**

   Open your terminal or command prompt and run:

   ```sh
   git clone https://github.com/sahil-sharma-chandan/neustackapp-assignment.git
   ```

2. **Open IntelliJ IDEA**
   - Locate the pom.xml file in the project directory (neustackapp-assignment).
   - Right-click on pom.xml and select "Open As Project".
   - Now wait for Build Your Project. It will Autometically build project.

3. **Update Configuration**
   - Navigate to the file located at neustackapp-assignment\src\main\resources\config.properties.
   - chromeDriverPath: Set this to the path of the ChromeDriver binary you downloaded.
   - Navigate to the file located at neustackapp-assignment\src\main\resources\features\Open_project.feature
   - Update in Examples Table according to your data.
4. Running the Application
   - Open IntelliJ IDEA and navigate to neustackapp-assignment\src\main\resources\features\Open_project.feature.
   - Right-click on Open_project.feature and select "Run".

Application should now be running successfully. If you encounter any issues, make sure all prerequisites are correctly installed and configured.



