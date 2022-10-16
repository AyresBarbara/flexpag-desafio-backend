package com.flexpag.paymentscheduler.exception;

public class ErrorMessage {

	private int status;
	
    private String erro;
    
    private String descricao;

    public ErrorMessage(int status, String erro, String descricao) {
    	
        this.status = status;
        this.erro = erro;
        this.descricao = descricao;
    }

	public int getStatus() {
		return status;
	}

	public String getErro() {
		return erro;
	}

	public String getDescricao() {
		return descricao;
	}
    
}
