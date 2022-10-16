package com.flexpag.paymentscheduler.exception;

public class BadRequestException extends AbstractException{

	public BadRequestException(String descricao) {
        super("BadRequest", descricao);
    }
}
