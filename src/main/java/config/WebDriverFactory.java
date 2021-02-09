package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum WebDriverFactory { //enum-typ wyliczeniowy, statyczny - inicjalizuje się tylko raz podczas uruchomienia programu



    CHROME {
        @Override
        public WebDriver create() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    FIREFOX {
        @Override
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },

    INTERNET_EXPLORER {
        @Override
        public WebDriver create() {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        }
    };


    public abstract WebDriver create(); //funkcja abstrakcyjna - nie posiada własnej implementacji,
//    dlatego implementujemy ją w metodach powyżej dla poszczególnych przeglądarek
}
