package com.flexpag.paymentscheduler.exception;

public class NotFoundException extends AbstractException{

	public NotFoundException(String descricao){
        super("NotFound", descricao);
    }
}
