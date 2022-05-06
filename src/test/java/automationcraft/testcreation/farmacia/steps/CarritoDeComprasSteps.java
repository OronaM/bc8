package automationcraft.testcreation.farmacia.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.farmacia.pages.CarritoDeComprasPage;
import automationcraft.testcreation.farmacia.pages.CheckOutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Locale;

public class CarritoDeComprasSteps {
    CarritoDeComprasPage carrito;
    CheckOutPage checkOutPage;
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



    @Then("en cada artículo que esté asociado a un producto con receta médica debe aparecer un mensaje de alerta {string}")
    public void enCadaArtículoQueEstéAsociadoAUnProductoConRecetaMédicaDebeAparecerUnMensajeDeAlerta(String arg0) {

        Assert.assertTrue(checkOutPage.validarLaAparicionDelMensajePidiendoLaReceta().toLowerCase(Locale.ROOT).contains(arg0));
        System.out.println(checkOutPage.validarLaAparicionDelMensajePidiendoLaReceta());
    }

    @Given("que el cliente está el en carrito de compras con al menos un producto")
    public void queElClienteEstáElEnCarritoDeComprasConAlMenosProducto() {
        checkOutPage = new CheckOutPage(DriverFactory.getDriver());
        carrito.irACarritoDeCompras();
    }

    @When("el cliente introduce un número de tarjeta CMR inválido")
    public void elClienteIntroduceUnNúmeroDeTarjetaCMRInválido() {
        checkOutPage.introducirCmrincorrecto();

    }

    @And("hace clic en {string}")
    public void haceClicEn(String arg0) {
        checkOutPage.clickEnAplicar();

    }

    @Then("se despliega un mensaje de error en el carrito que dice {string}")
    public void seDespliegaUnMensajeDeErrorEnElCarritoQueDice(String arg0) {
        Assert.assertTrue(checkOutPage.validarmensajeDeError().toLowerCase(Locale.ROOT).contains(arg0));
    }
}
