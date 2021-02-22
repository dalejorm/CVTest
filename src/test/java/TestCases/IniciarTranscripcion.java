package TestCases;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Driver;
import java.util.List;

//Created by dramirez on 22/02/2021

public class IniciarTranscripcion {

    private final WebDriver driver;

    public IniciarTranscripcion() {
        driver = Driver.getDriver();
    }

    @Step("Given que el usuario quiere ingresar a <>")
    public void navegar(String URL){
        driver.get(URL);
        WebElement btnstart = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("start-ready")));
    }

    @Step("When el carga video para transcripcion <>")
    public void cargarVideo(String URL_video){
        driver.findElement(By.className("start-ready")).click();
        WebElement btnvideo= new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("alt-input-button")));
        btnvideo.click();
        driver.findElement(By.xpath("//div[@class='ext-input-field']//input[@type='text']")).sendKeys(URL_video);
        driver.findElement(By.xpath("//div[@class='ext-input-field']//input[@type='text']")).sendKeys(Keys.ENTER);
    }

    @Step("Then el valida carga del video")
    public void validarCargaVideo(){
        WebElement video = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='video-player']")));

    }
}
