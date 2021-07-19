package com.ashok.example.Exception;

public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException() {
		super("Error thrown from custom camel exception");
	}
}
