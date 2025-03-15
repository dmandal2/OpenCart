package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() {

		logger.info("***** strating TC001_AccountRegistrationTest ******");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount Link");

			hp.clickRegister();
			logger.info("clicked on Register Link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("providing customer details...");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();

			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("validating expected message...");
			String cnfmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}

		logger.info("**** Finished TC001_AccountRegistrationTest*****");

	}

}
