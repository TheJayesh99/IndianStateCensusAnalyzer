package com.bridgelabz.indianstatecodetest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bridgelabz.indianstatecodes.IndianStateCodeService;
import com.bridgelabz.indianstatecodes.StateCode;

public class IndianStateCodeTest
{
	@Test
	public void givenReadDataFromIndianCensus_ShouldReturnCountDataPresentInFile() 
	{
		String fileName = "/StateCode.csv";
		IndianStateCodeService codeService = new IndianStateCodeService();
		List<StateCode> stateCencesList = codeService.readIndiaStatCode(fileName);
		assertEquals(37, stateCencesList.size());
	}
}
