package step;

import config.WebDriverFactory;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import lombok.Getter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class CommonStep implements En {

    @Getter
    private WebDriver driver;
    private Scenario scenario;
    @Getter
    private HomePage homePage;

    public CommonStep() {

        Before("@Common", scenario -> this.scenario = scenario);
        After("@Common", () -> {
            if (scenario.isFailed()) {
                scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                        "image.png", scenario.getName());

            }
//            driver.quit();
        });
        Given("I navigate to {string} using {string}", (String url, String browser) -> {
            driver = WebDriverFactory.valueOf(browser).create();
            driver.get(url);
            this.homePage = new HomePage(getDriver());
        });
    }
}
