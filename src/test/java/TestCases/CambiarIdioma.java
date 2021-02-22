package TestCases;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Driver;
import java.util.List;

//Created by dramirez on 22/02/2021

public class CambiarIdioma {

    private final WebDriver driver;

    public CambiarIdioma() {
        driver = Driver.getDriver();
    }

    @Step("Given que el usuario quiere cambiar el idioma de <>")
    public void navegar(String URL){
        driver.get(URL);
        WebElement btnLogin = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("start-ready")));
    }

    @Step("When el valida el idioma del texto <>")
    public void idioma_inicial(String idiomaInicial) throws Exception {
        List<WebElement> element = driver.findElements(By.className("lead"));
        if(element.size() >0){
            if(element.get(0).getText().equals(idiomaInicial)){
                System.out.println("Se encuentra correctamente el texto en el idioma inicial");
            }else{
                System.out.println("Se encuentra inccorrectamente el texto en el idioma inicial");
                throw new Exception("");
            }
        }else{
            System.out.println("No se encuentra texto a buscar");
            throw new Exception("");
        }
    }

    @Step("And el selecciona un nuevo idioma <>")
    public void cambiaridioma(String idiomaNuevo){
        driver.findElement(By.xpath("//div[@class='language-title']")).click();
        driver.findElement(By.xpath("//div[text()='"+idiomaNuevo+"']")).click();
    }

    @Step("Then el valida el idioma del texto <>")
    public void val_idiomaNuevo(String textoNuevo){
        WebElement btnLogin = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='"+textoNuevo+"']")));
    }

}
