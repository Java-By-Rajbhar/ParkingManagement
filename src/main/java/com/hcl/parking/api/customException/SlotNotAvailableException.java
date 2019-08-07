package com.hcl.parking.api.customException;

public class SlotNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SlotNotAvailableException(String message)
	{
		super(message);
	}

}
