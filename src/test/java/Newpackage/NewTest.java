package Newpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;




public class NewTest {
  @Test
  @Features("New feature")
  @Severity(SeverityLevel.CRITICAL)
  @Description("This is the first test case")
  @Step("This is the first test step for the first test case")
  public void testcase1() {
	  Assert.assertTrue(true);
	  System.out.println("Test case is passed");
  }
  
  
  @Test
  @Features("Allure test report check")
  @Severity(SeverityLevel.NORMAL)
  @Description("This is the second test case")
  @Step("This is the second test step for the first test case")
  public void testcase2() {
	  Assert.assertTrue(false);
	  System.out.println("Test case is failed");
  }
  
  @Test
  @Features("Allure test report check")
  @Severity(SeverityLevel.TRIVIAL)
  @Description("This is the third test case")
  @Step("This is the third test step for the third test case")
  public void testcase3() {
	  Assert.assertTrue(true);
	  attachtext("testlogfile", "This message should be seen as log file text");
	  System.out.println("Test case is passed");
  }
  
  @Attachment(value="{0}",type="text/plain")
  public String attachtext(String filename, String message){
	  return message;
  }
}
