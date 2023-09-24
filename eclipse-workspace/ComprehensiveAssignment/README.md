
Run Main.java for problem1 and problem2
Run suite-->testng.xml for both TESTNG and CUCUMBER problems (index.html in test-output folder)
below Git commands used 
git remote add origin remoteurl
git checkout -b newbranchname
git status
git commit -m 'message'
git push origin newbranchname






# BDD.Cucumber.Selenium.Maven
Maven project generted with com.a9ski:quick-start archetype


# Development guide
1. Install pre-commit (https://pre-commit.com/)
2. Install the pre-commit hook by executing `pre-commit install` inside project directory
3. Run against all files in the project: `pre-commit run --all-files`

# Building
```
mvn clean install
```
produces a jar file with MANIFEST containing main class and classpath.
All dependencies are copied to target/libs directory.

# Runing
```
mvn exec:java
```

or

```
cd target
java -jar xxxx.jar
```
