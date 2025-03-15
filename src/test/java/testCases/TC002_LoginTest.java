package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity", "Master"})
	public void verify_login() {

		logger.info("*****starting TC_002_LoginTest ******");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// MyAccount
			MyAccountPage ap = new MyAccountPage(driver);
			boolean targetPage = ap.isMyAccountPageExists();

			Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true, "Login failed")
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***** Finished TC_002_LoginTest *****");
	}

}
