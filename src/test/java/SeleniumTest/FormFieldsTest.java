package SeleniumTest;

import com.subbu.test.Pages.FormFields;
import com.subbu.test.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormFieldsTest {
    @Test
    public void Verifyformfieldssubmit() {
        HomePage home = new HomePage();
        home.acceptcookie();
        home.GotoFormfields();
        FormFields  page = new FormFields();
        int splitpos;
        int i=0;
        String[] expectedvalues = {"Input Test","Option 1",
                "White","Decimal","subbu@gmail.com","Message #1"};
        List<WebElement> formfields = page.submitform(expectedvalues);
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
