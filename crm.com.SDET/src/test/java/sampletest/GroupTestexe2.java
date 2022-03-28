package sampletest;

import org.testng.annotations.Test;

public class GroupTestexe2 {
	@Test(groups={"UsabilityTesting","IntigressionTesting"})
	public void UsabilityTesting() {
		System.out.println("UsabilityTesting is done");
	}
	
	@Test(groups={"SmokeTesting","PerformenceTesting"})
	public void SmokeTesting() {
		System.out.println("SmokeTesting is done");
	}

}
