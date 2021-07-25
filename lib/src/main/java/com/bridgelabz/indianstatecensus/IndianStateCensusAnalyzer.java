package com.bridgelabz.indianstatecensus;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

import com.bridgelabz.indianstatecensus.CustomExceptionService.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IndianStateCensusAnalyzer
{
	private static final String FILE_PATH = "e://JavaWorkspace//IndianStateCensusAnalyzer//lib//src//main//resources";

	public List<StateCences> readInIndiaStateCensusData(String FileName) 
	{
		try 
		{
			Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH+FileName));   //reader to read contacts
			CsvToBean<StateCences> csvToBean = new CsvToBeanBuilder<StateCences>(reader)
					.withType(StateCences.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			return csvToBean.parse();   //Converting them to list
		}
		catch (NoSuchFileException e)
		{
			throw new CustomExceptionService(ExceptionType.FILE_NOT_FOUND,"File Not Found");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
