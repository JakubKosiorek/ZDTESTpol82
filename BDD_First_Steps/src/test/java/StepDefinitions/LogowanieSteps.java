package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogowanieSteps {

    WebDriver driver;                   // tworzymy pole driver jako zmienną web-ową

    // GIVEN -> preconditions -> warunki wstępne które muszą być spełnione

    @Given("Użytkownik jest na stronie logowania.")
    /*
    podłączenie źródła z pliku Logowanie.feature ,
    nazwa w cudzysłowie musi być TAKA SAMA jak w pliku Logowanie.feature
    */

    public void stronaLogowania(){                      // metoda stronaLogowania dla warunku Given
        /*
        do otwarcia okna wybranej przeglądarki niezbędne jest posiadanie sterowników danej przeglądarki, tak zwanych
        webdriver-ów, bardzo WAŻNE jest to aby posiadać wersję sterowników zgodną z wersją przeglądarki którą używamy
        do testowania aplikacji
        */
        System.setProperty("webdriver.chrome.driver", "c://chromedriver//chromedriver96.exe"); // otwarcie okna przeglądarki
            // setProperty("rodzaj webdriver-ów"  , "dokładna ścierzka do pliku <nazwa>.exe");

        driver = new ChromeDriver();    // konstruktor uruchamiający nowe okno przeglądarki
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        /*
        do otwarcia aplikacji w oknie przeglądarki wykorzystujemy webdrivera navigate().to()
        do którego wprowadzamy dokładny adres URL który ma zostać wyświetlony w oknie przeglądarki
         */
    }


    // WHEN -> steps to do -> kroki do wykonania w teście

    @When("Użytkownik wprowadza w pole LOGIN poprawny login,")
    /*
    podłączenie źródła z pliku Logowanie.feature,
    nazwa w cudzysłowie musi być TAKA SAMA jak w pliku Logowanie.feature
    */

    public void userLogin() {
        /*
        do zidentyfikowania pola w przeglądarce używamy metody findElement( ) w połączeniu z metodą By.X gdzie X oznacza
        sposób w jaki chcemy wyszukać np. po id < By.id() >, po nazwie pola < By.name() > lub po xPath-u < By.xpath() >
        */
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        /*
        pole LOGIN identyfikujemy po np. id pola znajdującym się w kodzie testowanej aplikacji
        < id="username" > następnie wysyłamy do tego pola poprawną wartość
        */
        }

    @When("Użytkownik wprowadza w pole PASSWORD poprawne hasło,")
    public void userPassword(){
        /*
        do zidentyfikowania pola w przeglądarce używamy metody findElement( ) w połączeniu z metodą By.X gdzie X oznacza
        sposób w jaki chcemy wyszukać np. po id < By.id() >, po nazwie pola < By.name() > lub po xPath-u < By.xpath() >
        */
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        /*
        pole PASSWORD identyfikujemy po np. nazwie pola  znajdującym się w kodzie testowanej aplikacji
        < name="password" > następnie wysyłamy do tego pola poprawną wartość
        */
    }

    @When("Użytkownik wybiera przycisk LOGIN i naciska.")
    public void loginPushbutton(){
    /*
    do zidentyfikowania pola w przeglądarce używamy metody findElement( ) w połączeniu z metodą By.X gdzie X oznacza
    sposób w jaki chcemy wyszukać np. po id < By.id() >, po nazwie pola < By.name() > lub po xPath-u < By.xpath() >
     */
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        /*
        przycisk logowania identyfikujemy po np. xPath-u  skopiowanym z fragmentu kodu testowanej aplikacji
        a następnie symulujemy naciśnięcie przez kursor metodą click()
        */
    }
   
}
