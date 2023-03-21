package com.guru99.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class LoginTests extends BaseTests {
	@Parameters({"username", "userPassword"})
	@Test
	public void userLoginWithCorrectCredentials(String username, String password) {
		reportUtils.createTestCase("Verify User Login With Correct Credentials");
		reportUtils.addTesteLog(Status.INFO, "Performing Login");
		loginPage.loginToAplication(username, password);
		String expectedTitle = "Guru99 Bank Manager Home Page";
		String actualTitle = cmnDriver.getTitleOfThePage();
		reportUtils.addTesteLog(Status.INFO, "Comparing expected and actual title");
		Assert.assertEquals(expectedTitle, actualTitle);
	}
}
