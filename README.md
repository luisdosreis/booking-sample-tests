## Booking Tests Sample
### Framework/Stack
For the sake of simplicity the following libraries where used:
* Selenium Java - Takes care of the UI interaction.
* WebdriverManager - Takes care of browser drivers.
* TestNG - Our test execution assertion framework.
* Slf4j - Takes care of logging.
### Implementation/Decisions
* Packages, classes and methods try to be self-explanatory.
Their names and package are tied to their functionality.
* The website pages are represented using Page Object Model.
* Page functionality lives within their mapping objects.
* Page objects implement available actions functionality at macro level (Keywords).
* Page Objects relate to their components (ie. Main Search Bar is a component of the Main Page)
* CSS Selectors where used for speed.
* Static enumerators and helpers are used for convenience.
* The framework follows a Page > Component > Action approach.
* Driver management uses Factory pattern.
* A simple configuration manager was implemented to override run values, in this case window size can be changed.
  
  See: java/resources/run.properties

### Dependencies
* Google Chrome https://www.google.com/chrome/
* OpenJDK >= v19.0.2
On Mac OSX you can use [brew](https://brew.sh/).
```
brew install openjdk
```
For other platforms follow https://jdk.java.net/19/
* Apache Maven >= v3.9.0
```
brew install maven
```
For other platforms follow https://maven.apache.org/index.html

### Compile and Run
1. Open a terminal
2. Execute `mvn clean test` It will download dependencies and run the test file.
3. The output will show the "Property number" and the "Property names list".