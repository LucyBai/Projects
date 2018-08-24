package com.me.myweb.exception;

public class FollowerException extends Exception{

	 public FollowerException(String message)
	    {
	        super("FollowerException-"+message);
	    }
	    
	    public FollowerException(String message, Throwable cause)
	    {
	        super("FollowerException-"+message,cause);
	    }
}
