package automationcraft.testcreation.farmacia.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends SeleniumBase {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    String cmrIvalido = "234756";
    By mensajeNecesitaReceta = By.xpath("//div[@class=\"message message-warning warning\"]");
    By cmrInput = By.id("cmr_coupon_code");
    By btnAplicar = By.xpath("//button[@id='send-cmr-coupon']");
    By mensajeDeError = By.xpath("//div[@class =\"toast-message\"]");



   public void introducirCmrincorrecto(){
       exwait(cmrInput);
       click(cmrInput);
       type(cmrIvalido,cmrInput);
   }
   public void clickEnAplicar(){
       click(btnAplicar);

   }
   public String validarmensajeDeError(){
       exwait(mensajeDeError);
       if (isDisplayed(mensajeDeError)) {
           return getText(mensajeDeError);
       }
       return "mensaje no valido";

   }

    public String validarLaAparicionDelMensajePidiendoLaReceta(){
    if (isDisplayed(mensajeNecesitaReceta)) {
        return getText(mensajeNecesitaReceta);
    }
    return "mensaje no valido";
}
}
