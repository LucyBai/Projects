package com.me.myweb.exception;

public class ArticalException extends Exception{

	
	 public ArticalException(String message)
	    {
	        super("PhotoException-"+message);
	    }
	    
	    public ArticalException(String message, Throwable cause)
	    {
	        super("PhotoException-"+message,cause);
	    }

}
