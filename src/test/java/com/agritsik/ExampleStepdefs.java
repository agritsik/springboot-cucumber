package com.agritsik;

import cucumber.api.java8.En;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = MyApplication.class)
public class ExampleStepdefs implements En {


    @Autowired
    RestTemplate restTemplate;

    private Integer price;

    public ExampleStepdefs() {

        Given("^Jeff has bought a microwave for (\\d+)$", (Integer arg0) -> {
            this.price = arg0;

            // check that bean has been autowired
            Assert.assertNotNull(restTemplate);
        });
        And("^he has a receipt$", () -> {
            // do nothing ...
        });
        When("^he returns the microwave$", () -> {
            // do nothing ...
        });
        Then("^Jeff should be refunded (\\d+)$", (Integer arg0) -> {
            Assert.assertEquals(price, arg0);
        });
    }
}
