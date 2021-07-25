package com.bridgelabz.indianstatecensustest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bridgelabz.customexception.CustomExceptionService;
import com.bridgelabz.customexception.CustomExceptionService.ExceptionType;
import com.bridgelabz.indianstatecensus.IndianStateCensusAnalyzer;
import com.bridgelabz.indianstatecensus.StateCences;

public class IndianStateCensusTest 
{
	@Test
	public void givenReadDataFromIndianCensus_ShouldReturnCountDataPresentInFile() 
	{
		String fileName = "/IndiaStateCensusData.csv";
		IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
		List<StateCences> stateCencesList = censusService.readInIndiaStateCensusData(fileName);
		assertEquals(29, stateCencesList.size());
	}
	
	@Test
	public void givenWrongFile_ShouldReturnFileNotFound()
	{
		String fileName = "/IndiaStateCensus.csv";
		IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
		try 
		{	
			List<StateCences> stateCencesList = censusService.readInIndiaStateCensusData(fileName);
			assertEquals(29, stateCencesList.size());	
		}
		catch (CustomExceptionService e) 
		{
			assertEquals(ExceptionType.FILE_NOT_FOUND, e.type);
		}
	}

	@Test
	public void givenWrongFileExtention_ShouldReturnWrongFileType()
	{
		String fileName = "/IndiaStateCensusData.txt";
		IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
		try 
		{	
			List<StateCences> stateCencesList = censusService.readInIndiaStateCensusData(fileName);
			assertEquals(29, stateCencesList.size());	
		}
		catch (CustomExceptionService e) 
		{
			assertEquals(ExceptionType.WRONG_FILE_TYPE, e.type);
		}		
	}

	@Test
	public void givenWrongFileHeaders_ShouldReturnWrongHeader()
	{
		String fileName = "/IndiaStateCensusDataWrongHeaders.csv";
		IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
		try 
		{	
			List<StateCences> stateCencesList = censusService.readInIndiaStateCensusData(fileName);
			assertEquals(29, stateCencesList.size());	
		}
		catch (CustomExceptionService e) 
		{
			assertEquals(ExceptionType.WRONG_HEADER, e.type);
		}		
	}
}
