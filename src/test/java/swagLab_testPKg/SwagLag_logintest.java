package swagLab_testPKg;

import org.testng.annotations.Test;

import swagLab_basePKG.SwagLab_base;

public class SwagLag_logintest extends SwagLab_base {
	
	@Test(priority = 1)
	public void loginTestMtd()
	{
		test=extent.createTest("Login Verification");
		loginobj.loginMtd("standard_user", "secret_sauce");
	}
	

}
