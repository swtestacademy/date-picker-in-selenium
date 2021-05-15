import java.util.Collections;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOps {
    public static ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        //        Map<String, Object> prefs = new HashMap<>();
        //        prefs.put("safebrowsing.enabled", "true");
        //        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //
        //        //To Turns off multiple download warning
        //        prefs.put("profile.default_content_settings.popups", 0);
        //
        //        prefs.put( "profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
        //
        //        //Turns off download prompt
        //        prefs.put("download.prompt_for_download", false);
        //        prefs.put("credentials_enable_service", false);
        //        //To Stop Save password propmts
        //        prefs.put("password_manager_enabled", false);
        //
        options.addArguments("chrome.switches", "--disable-extensions");
        //        //To Disable any browser notifications
        options.addArguments("--disable-notifications");
        //        //To disable yellow strip info bar which prompts info messages
        options.addArguments("disable-infobars");
        //
        //        options.setExperimentalOption("prefs", prefs);
        //        options.addArguments("--test-type");
        //
        //
        //
        //
        //        String num2 = RandomStringUtils.randomNumeric(1);
        //        String num3 = RandomStringUtils.randomNumeric(4);
        //        String num4 = RandomStringUtils.randomNumeric(2);
        //        String num5 = RandomStringUtils.randomNumeric(3);
        //        String randomAgentForChrome = String.format("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/%s.%s "
        //            + "(KHTML, like Gecko) Chrome/90.%s.%s.%s Safari/%s.%s", num5, num4, num4, num2, num3, num4, num5, num4);
        //        System.out.println(randomAgentForChrome);
        //        options.addArguments(randomAgentForChrome);
        System.out.println("--user-agent=" + RandomUserAgent.getRandomUserAgent());

        options.addArguments("--user-agent=" + RandomUserAgent.getRandomUserAgent());
        return options;
    }
}





