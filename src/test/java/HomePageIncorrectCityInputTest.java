
import config.WebDriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

 import pages.HomePage;

 public class HomePageIncorrectCityInputTest {

     @Test
     public void enterIncorrectCity() throws InterruptedException {
         WebDriver driver = WebDriverFactory.FIREFOX.create();
         driver.get("https://booking.com/");
         HomePage homePage = new HomePage(driver);
         homePage.acceptCookies();
         homePage.enterCity("%^&(");
         homePage.clickSearchButtonWithoutRedirect();
         String cityErrorMessage = homePage.getCityErrorMessage();

         Assert.assertEquals (cityErrorMessage, "Error:\nSorry, we don't recognize that name.");

     }
 }
