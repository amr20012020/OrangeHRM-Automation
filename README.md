# OrangeHRM Selenium Automation Framework
Java 17 + Selenium WebDriver + TestNG + Maven + Page Object Model.

## Run
1. Install JDK 17+ and Maven, and Chrome (or Firefox).
2. Open this folder in IntelliJ IDEA as a Maven project.
3. Run `mvn test` from the project root.
4. Edit `src/test/resources/config.properties` to choose `browser=chrome` or `browser=firefox`.

Includes valid login and invalid-password login tests. Selenium Manager automatically resolves browser drivers when supported. Requires internet access to load the demo site. Selectors and demo credentials may change. No live browser execution was performed when this archive was created.
