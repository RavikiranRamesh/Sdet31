package sampletest;

import org.testng.annotations.Test;

public class DependsOnMethords {

	@Test
	public void CreateAccount() throws Exception{
		System.out.println("Login");
		System.out.println("Create");
		System.out.println("Logout");
		throw new Exception();
		
	}
	@Test(dependsOnMethods="CreateAccount")
	public void ModifyAccount() {
		System.out.println("Login");
		System.out.println("Modify");
		System.out.println("Logout");
	}
	@Test(dependsOnMethods="ModifyAccount")
	public void DeleteAccount() {
		System.out.println("Login");
		System.out.println("Delete");
		System.out.println("Logout");
	}
}
