package com.bridgelabz.indianstatecodetest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bridgelabz.customexception.CustomExceptionService;
import com.bridgelabz.customexception.CustomExceptionService.ExceptionType;
import com.bridgelabz.indianstatecensus.IndianStateCensusAnalyzer;
import com.bridgelabz.indianstatecensus.StateCences;
import com.bridgelabz.indianstatecodes.IndianStateCodeService;
import com.bridgelabz.indianstatecodes.StateCode;

public class IndianStateCodeTest
{
	@Test
	public void givenReadDataFromIndianCensus_ShouldReturnCountDataPresentInFile() 
	{
		String fileName = "/StateCode.csv";
		IndianStateCodeService codeService = new IndianStateCodeService();
		List<StateCode> StateCodeList = codeService.readIndiaStatCode(fileName);
		assertEquals(37, StateCodeList.size());
	}
	@Test
	public void givenWrongFile_ShouldReturnFileNotFound()
	{
		String fileName = "/StateCodeing.csv";
		IndianStateCodeService codeService = new IndianStateCodeService();
		try 
		{	
			List<StateCode> StateCodeList = codeService.readIndiaStatCode(fileName);
			assertEquals(37, StateCodeList.size());	
		}
		catch (CustomExceptionService e) 
		{
			assertEquals(ExceptionType.FILE_NOT_FOUND, e.type);
		}
	}

	@Test
	public void givenWrongFileExtention_ShouldReturnWrongFileType()
	{
		String fileName = "/StateCodeData.txt";
		IndianStateCodeService codeService = new IndianStateCodeService();
		try 
		{	
			List<StateCode> StateCodeList = codeService.readIndiaStatCode(fileName);
			assertEquals(37, StateCodeList.size());	
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
		IndianStateCodeService codeService = new IndianStateCodeService ();
		try 
		{	
			List<StateCode> stateCodeList = codeService.readIndiaStatCode(fileName);
			assertEquals(37, stateCodeList.size());	
		}
		catch (CustomExceptionService e) 
		{
			assertEquals(ExceptionType.WRONG_HEADER, e.type);
		}		
	}
}
