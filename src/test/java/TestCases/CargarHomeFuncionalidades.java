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

public class CargarHomeFuncionalidades {

    private final WebDriver driver;

    public CargarHomeFuncionalidades() {
        driver = Driver.getDriver();
    }

    @Step("Given que el usuario quiere ingresar a transcribir <>")
    public void navegar(String URL){
        driver.get(URL);
        WebElement btnLogin = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("start-ready")));
    }

    @Step("When el valida el texto correcto de la funcionalidad 1 <> <>")
    public void val_fun1(String text_bold, String text_simple) throws Exception {
        if(validarTextos(text_bold,text_simple)){
            System.out.println("Se encuentra el texto correcto de la funcionalidad 1");
        }else{
            System.out.println("Se encuentra incorrecto el texto de la funcionalidad 1");
            throw new Exception("");
        }
    }

    @Step("And el valida el texto correcto de la funcionalidad 2 <> <>")
    public void val_fun2(String text_bold, String text_simple) throws Exception {
        if(validarTextos(text_bold,text_simple)){
            System.out.println("Se encuentra el texto correcto de la funcionalidad 2");
        }else{
            System.out.println("Se encuentra incorrecto el texto de la funcionalidad 2");
            throw new Exception("");
        }
    }

    @Step("Then el valida el texto de funcionalidad no existente <> <>")
    public void val_fun3(String text_bold, String text_simple) throws Exception {
        if(!validarTextos(text_bold,text_simple)){
            System.out.println("No se encuentra el texto de la funcionalidad 3");
        }else{
            System.out.println("Se encuentra el texto de la funcionalidad 3");
            throw new Exception("");
        }
    }


    public boolean validarTextos(String textBold, String textSimple) throws Exception {
        boolean tb = false;
        boolean ts = false;
        boolean tf = false;
        List<WebElement> teb = driver.findElements(By.xpath("//strong[text()='"+textBold+"']"));
        if(teb.isEmpty()){
            System.out.println("No se encontre el texto bold");
            tb = false;
        }else{
            System.out.println("Se encuentra el texto bold");
            tb = true;
        }

        List<WebElement> tes = driver.findElements(By.xpath("//li[text()='"+textSimple+"']"));
        if(teb.isEmpty()){
            System.out.println("No se encontre el texto simple");
            ts = false;
        }else{
            System.out.println("Se encuentra el texto simple");
            ts = true;
        }

        if(ts && tb){
            tf = true;
        }
        return tf;
    }

}
