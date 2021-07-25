package com.bridgelabz.indianstatecensus;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IndianStateCensusAnalyzer
{
	private static final String FILE_PATH = "e://JavaWorkspace//IndianStateCensusAnalyzer//lib//src//main//resources";
	private static final String INDIAN_STATE_CENCUS = "/IndiaStateCensusData.csv";

	public List<StateCences> readInIndiaStateCensusData() 
	{
		try 
		{
			Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH+INDIAN_STATE_CENCUS));   //reader to read contacts
			CsvToBean<StateCences> csvToBean = new CsvToBeanBuilder<StateCences>(reader)
					.withType(StateCences.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			return csvToBean.parse();   //Converting them to list
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
