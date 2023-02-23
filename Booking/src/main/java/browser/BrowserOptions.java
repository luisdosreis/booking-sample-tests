package browser;

import config.ConfigurationManager;

public class BrowserOptions {

    public static Boolean RUN_HEADLESS = false;

    public static Boolean RUN_MAXIMIZED = false;

    public static final String START_MAXIMIZED = "--start-maximized";

    public static final String DISABLE_INFOBARS = "--disable-infobars";

    public static final String DISABLE_NOTIFICATIONS = "--disable-notifications";

    public static final String HEADLESS_NEW = "--headless=new";

    public static final String HEADLESS = "-headless";

    public static int WINDOW_SIZE_W;
    public static int WINDOW_SIZE_H;

    static {
        WINDOW_SIZE_W = ConfigurationManager.getProperty("WINDOW_SIZE_W") != null ? Integer.parseInt(ConfigurationManager.getProperty("WINDOW_SIZE_W")) : 1280;
        WINDOW_SIZE_H = ConfigurationManager.getProperty("WINDOW_SIZE_H") != null ? Integer.parseInt(ConfigurationManager.getProperty("WINDOW_SIZE_H")) : 800;
    }
}
