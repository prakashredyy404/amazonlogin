package steps;

import drivers.actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static drivers.actions.openUrl;

public class MyStepdefs extends actions {
    @Given("user opens url")
    public void userOpensUrl()  throws RuntimeException {
        openUrl();
    }

    @When("user searches for item")
    public void userSearchesForItem() {
        item();
    }

    @And("user add item into cart")
    public void userAddItemIntoCart() {
        itemincart();

    }

    @Then("remove added item from cart")
    public void removeAddedItemFromCart() {
        removeitem();
    }
}
