package BusinessLogicTests;

/**
 *
 * @author mpanagrosso
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.JUnit4TestAdapter;
// This section declares all of the test classes in the program.

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginControllerTest.class}) // Add test classes here.
public class TestSuiteLoginController {
// Execution begins at main(). In this test class, we will execute
// a text test runner that will tell you if any of your tests fail.

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
// The suite() method is helpful when using JUnit 3 Test Runners or Ant.

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TestSuiteLoginController.class);
    }
}
