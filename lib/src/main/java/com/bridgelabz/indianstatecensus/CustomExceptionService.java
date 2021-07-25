package com.bridgelabz.indianstatecensus;

public class CustomExceptionService extends RuntimeException
{
	public enum ExceptionType
	{
		FILE_NOT_FOUND
	}
	
	public ExceptionType type;

	public CustomExceptionService(ExceptionType type,String message) 
	{
		super(message);
		this.type = type;
	}
	
}
