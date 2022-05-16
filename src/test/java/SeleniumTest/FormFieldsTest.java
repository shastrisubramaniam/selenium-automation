package SeleniumTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormFieldsTest extends BaseTest {
        int splitpos;
        int i=0;
        String[] expectedvalues = {"Input Test","Option 1",
                "White","Decimal","subbu@gmail.com","Message #1"};
    @Test
    public void Verifyformfieldssubmit() {
        List<WebElement> formfields = openhomepage().acceptcookie().GotoFormfields().submitform(expectedvalues);

        //home.acceptcookie();
        //home.GotoFormfields();
        //FormFields  page = new FormFields();


        //List<WebElement> formfields = page.submitform(expectedvalues);
        String[] actualvalues = new String[formfields.size()];
        //page.checkformfields();
        for (WebElement field :formfields) {
            splitpos = field.getText().indexOf(":");
            actualvalues[i] = field.getText().substring(splitpos+1).trim();
            i++;
            //System.out.println(parser.indexOf(field.getText(),":");
        }
        for (int j=0;j < expectedvalues.length;j++) Assert.assertEquals(actualvalues[j],expectedvalues[j]);
    }
}
