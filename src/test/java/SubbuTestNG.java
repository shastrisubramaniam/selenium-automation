import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class SubbuTestNG {

            @DataProvider
        public Object[][] data() {
            return new String[][] {new String[] {"data"}};
        }

        @Test(dataProvider = "data")
        public void test(String d) {
            Assert.assertEquals("First Line", "First Line");
        }
    }

