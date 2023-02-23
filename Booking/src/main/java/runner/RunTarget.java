package runner;

public enum RunTarget {
    LOCAL("local"),
    SELENIUM_GRID("selenium-grid");

    private final String environment;

    RunTarget(String environment) {
        this.environment = environment;
    }
}
