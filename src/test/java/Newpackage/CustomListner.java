package Newpackage;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

public class CustomListner extends NewTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String methodname=result.getName().toString().trim();
		System.out.println("Method name is " + methodname);
		takescreenshotonfailure(methodname);
		attachlog("testlog","This file should conatin this text");
		saveImageAttach(methodname);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	public void takescreenshotonfailure(String methodname){
		try{
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desitation=new File((System.getProperty("user.dir")+"\\java\\main\\resources\\screenshots\\"+methodname+".png"));
		FileUtils.copyFile(screenshot, desitation);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	  @Attachment(value = "{0}", type = "image/png")
	  public static byte[] saveImageAttach(String methodname) {
		  byte[] res=null;
		  try {
	    	  BufferedImage image = ImageIO.read(new File((System.getProperty("user.dir")+"\\java\\main\\resources\\screenshots\\"+methodname+".png")));
	    	  ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
	    	  ImageIO.write(image, "png", baos); 
	    	  res=baos.toByteArray();
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	      return res;
	  }
	
/*	 @Attachment(value = "{0}", type = "image/png")
	  public static byte[] saveImageAttach(String methodname){
	      try {
	    	  URL defaultImage = new URL(System.getProperty("user.dir")+"\\java\\main\\resources\\screenshots\\"+methodname+".png");
	          File imageFile = new File(defaultImage.toURI());
	          return toByteArray(imageFile);
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	      return new byte[0];
	  }

	  private static byte[] toByteArray(File file) throws IOException {
		  return Files.readAllBytes(Paths.get(file.getPath()));
	  }*/
	  
	  @Attachment(value = "{0}", type = "text/plain")
	  public String attachlog(String filename,String message){
		  return message;
	  }


}
