import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class test1 {

    @FindBy (className = "Zgadzam się")
    WebElement agreeButton;

    private static HttpURLConnection connection;


    @Test

    public void WebpageOpenTest() throws IOException {
        String driverPath = "C:\\diab\\IdeaProjects\\com.travels\\src\\main\\resources\\executables.drivers\\chromedriver 87.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        final WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String url = "https://www.google.com";
        /*try {
            URL myurl = new URL(url);
            connection = (HttpURLConnection) myurl.openConnection();
            connection.setRequestMethod("POST");
            connection.getOutputStream()
        }*/

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //tests.SeleniumHelper.takeScreenshot (driver);
        /*driver.getWindowHandles().size();
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Ilość okien przeglądarki " + windows.size());
        agreeButton.click();*/





    }


        /*Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(alertText);
        /*if (alertText.equals("Zanim przejdziesz dalej\n" +
                "Google wykorzystuje pliki cookie i inne dane do dostarczania, utrzymywania i ulepszania swoich usług oraz reklam. Jeśli się zgodzisz, będziemy personalizować wyświetlane treści i reklamy na podstawie Twojej aktywności w usługach Google, takich jak wyszukiwarka, Mapy i YouTube. Współpracujemy też z firmami, które mierzą, jak użytkownicy korzystają z naszych usług. Aby przejrzeć dostępne opcje, kliknij „Pokaż więcej” lub w dowolnej chwili wejdź na g.co/privacytools.")) {
            alert.accept();*/

        /*WebElement consentButton = driver.findElement(By.xpath("/html/body/div/c-wiz/div[2]/div/div/div/div/div[2]/form/div/span/span"));
        consentButton.click();*/

        }

