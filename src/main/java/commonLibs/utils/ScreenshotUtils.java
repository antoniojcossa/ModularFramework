package commonLibs.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	private TakesScreenshot camera;
	
	public ScreenshotUtils(WebDriver driver) {
		camera = (TakesScreenshot) driver;
	}
	
	public void CaptureAndSaveScreenShot(String fileName) throws Exception {
		fileName = fileName.trim();
		File imgFile, tempFile;
		imgFile = new File(fileName);
		if(imgFile.exists()) {
			throw new Exception("File Already Exist");
		}
		tempFile = camera.getScreenshotAs(OutputType.FILE);
		FileUtils.moveFile(tempFile, imgFile);
	}
}
