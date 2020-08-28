package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static com.petstore.util.Constants.BASE_URL;
import static com.petstore.util.Constants.PET_ENDPOINT;
import static io.restassured.RestAssured.given;

public class StepdefsAPIOperations {
    PetAPIClient petAPIClient;
    String getStatusResponse;
    List<String> availablePets;

    @Given("The petstore api accessed for getstatus of pets")
    public void the_petstore_api_accessed_for_getstatus_of_pets() {
        petAPIClient = new PetAPIClient();
    }


    @When("I perform get operation for FindByStatus")
    public void i_perform_get_operation_for_FindByStatus(){
        getStatusResponse= petAPIClient.getPetsByStatus("/findByStatus","available");

    }


    @Then("validate how many {string} are in {string} status")

    public void validate_how_many_are_in_status(String name, String status) {
        availablePets= petAPIClient.validatePetsByStatus(getStatusResponse,name,status);
        Assert.assertTrue(availablePets.size() +"  doggies are in available status"  ,availablePets.size() >0);
        System.out.println(availablePets.size() +" doggies are in available status" );

    }


}
