package automationcraft.testcreation.farmacia.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.farmacia.pages.CarritoDeComprasPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CarritoDeComprasSteps {
    CarritoDeComprasPage carrito;
    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String url) {
        carrito = new CarritoDeComprasPage(DriverFactory.getDriver());
        carrito.irAUrlDeFarmacia(url);

    }

    @When("presiono el boton Agregar al carrito")
    public void presiono_el_boton_agregar_al_carrito() {
        carrito.clickBtnAgregarAlCarrito();
    }

    @Then("se debe agregar correctamente el producto al carrito")
    public void se_debe_agregar_correctamente_el_producto_al_carrito() {
        Assert.assertTrue(carrito.validarMensajeIngresoProductoEnCarrito().contains("Se agregó"));
    }

    @Then("ver el carrito de compra en pantalla")
    public void ver_el_carrito_de_compra_en_pantalla() {
        carrito.irACarritoDeCompras();
    }
}
