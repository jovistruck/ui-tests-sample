package cucumber;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java8.En;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class LambdaStepdefs implements En {
    private static LambdaStepdefs lastInstance;

    public LambdaStepdefs() {
        Before((Scenario scenario) -> {
            assertNotSame(this, lastInstance);
            lastInstance = this;
        });

        Given("^this data table:$", (DataTable peopleTable) -> {
            List<Person> people = peopleTable.asList(Person.class);
            assertEquals("Hellesøy", people.get(0).last);
        });

        And("^something that isn't defined$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Given("^I have (\\d+) cukes in my belly$", (Integer arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }

    public static class Person {
        String first;
        String last;
    }
}
