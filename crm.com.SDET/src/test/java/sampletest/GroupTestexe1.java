package sampletest;

import org.testng.annotations.Test;

public class GroupTestexe1 {
	@Test(groups={"PerformenceTesting","SmokeTesting"})
	public void PerformenceTesting() {
		System.out.println("PerformenceTesting is done");
	}
	
	@Test(groups={"IntigressionTesting","UsabilityTesting"})
	public void IntigressionTesting() {
		System.out.println("IntigressionTesting is done");
	}
	

}
