package SeleniumTest;

import com.subbu.framework.utilities.JsonUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormFieldsTest extends BaseTest {
        //String[] expectedvalues = {"Input Test","Option 1",
        //        "White","Decimal","subbu@gmail.com","Message #1"};
        @Test(dataProvider="JsonDataProvider",dataProviderClass= JsonUtil.class)
    public void Verifyformfieldssubmit(String[] expectedvalues) {
            //for (String expectedvalue : expectedvalues) System.out.println(expectedvalue);

        //String[] expectedvalues = (String[]) jsonobj.values().toArray();
        List<WebElement> formfields = openhomepage().acceptcookie().GotoFormfields().submitform(expectedvalues);
        String[] actualvalues = getActualvalues(formfields);
        //home.acceptcookie();
        //home.GotoFormfields();
        //FormFields  page = new FormFields();


        //List<WebElement> formfields = page.submitform(expectedvalues);

        //page.checkformfields();

        for (int j=0;j < expectedvalues.length;j++) Assert.assertEquals(actualvalues[j],expectedvalues[j]);
    }
    private String[] getActualvalues( List<WebElement> resultwebelements) {
        int splitpos;
        int i=0;
        String[] actualvalues = new String[resultwebelements.size()];
        for (WebElement field :resultwebelements) {
            splitpos = field.getText().indexOf(":");
            actualvalues[i] = field.getText().substring(splitpos+1).trim();
            i++;
            //System.out.println(parser.indexOf(field.getText(),":");
        }
        return actualvalues;
    }
}
