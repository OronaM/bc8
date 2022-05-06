package automationcraft.testcreation.farmacia.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoDeComprasPage extends SeleniumBase {
    public CarritoDeComprasPage(WebDriver driver) {
        super(driver);
    }

    By btnAgregarAlCarrito = By.xpath("//button[@class=\"action tocart primary \"]");
    By mensajeOk = By.xpath("//div[@class='toast-message']");
    By contadorDeProductosEnCarrito = By.xpath("//span[@class=\"counter-number\"]");
    By btnCarrito = By.xpath("//i[@class=\"navbar-tool-icon icon-cart\"]");
    By btnVerCarrito = By.id("top-cart-btn-checkout");

    public void irAUrlDeFarmacia(String url){
        goToUrl(url);
    }

    public void clickBtnAgregarAlCarrito(){
        click(btnAgregarAlCarrito);
    }
    public String validarMensajeIngresoProductoEnCarrito() {
        exwait(mensajeOk);
        if (isDisplayed(mensajeOk)) {
            return getText(mensajeOk);
        }
        return "mensaje no valido";
    }
    public void irACarritoDeCompras(){
        click(btnCarrito);
        click(btnVerCarrito);
    }
}
