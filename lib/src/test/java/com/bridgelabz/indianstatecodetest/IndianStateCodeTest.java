package com.bridgelabz.indianstatecodetest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bridgelabz.customexception.CustomExceptionService;
import com.bridgelabz.customexception.CustomExceptionService.ExceptionType;
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
		IndianStateCodeService censusService = new IndianStateCodeService();
		try 
		{	
			List<StateCode> StateCodeList = censusService.readIndiaStatCode(fileName);
			assertEquals(37, StateCodeList.size());	
		}
		catch (CustomExceptionService e) 
		{
			assertEquals(ExceptionType.FILE_NOT_FOUND, e.type);
		}
	}


}
