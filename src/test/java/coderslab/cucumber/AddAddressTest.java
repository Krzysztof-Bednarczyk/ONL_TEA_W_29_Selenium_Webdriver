package coderslab.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/add-address.feature", plugin = {"pretty","html:out/addAddress.html"})
public class AddAddressTest {
}
