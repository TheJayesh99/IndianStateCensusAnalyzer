package com.bridgelabz.indianstatecensustest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bridgelabz.indianstatecensus.IndianStateCensusAnalyzer;
import com.bridgelabz.indianstatecensus.StateCences;

public class IndianStateCensusTest 
{
	@Test
	public void givenReadDataFromIndianCensus_ShouldReturnCountDataPresentInFile() 
	{
		IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
		List<StateCences> stateCencesList = censusService.readInIndiaStateCensusData();
		assertEquals(29, stateCencesList.size());
	}
}
