import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fachada2tests.DivisionTest;
import fachadatests.FachadaTests;



@RunWith(Suite.class)
@SuiteClasses({FachadaTests.class, DivisionTest.class})
public class AllTests {

}
