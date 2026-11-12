package swagLab_testPKg;

import org.testng.annotations.Test;

import swagLab_basePKG.SwagLab_base;

public class SwagLab_hometest extends SwagLab_base{
	
	@Test(priority = 1)
	public void producttestMtd()
	{
		test=extent.createTest("product Verification");
		homeobj.productMtd();
	}
	
	@Test(priority = 2)
	public void carttestMtd()
	{
		test=extent.createTest("cart Verification");
		homeobj.cartMtd();
	}

}
