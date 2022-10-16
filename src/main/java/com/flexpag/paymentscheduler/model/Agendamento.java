package com.flexpag.paymentscheduler.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flexpag.paymentscheduler.utils.Status;

@Entity
@Table (name = "tb_agendamento")
public class Agendamento {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String usuario;
	
	@Enumerated(EnumType.STRING)
	private Status pagamento;
	
	private Double valor;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;
	
	@JsonFormat(pattern="HH:mm")
	private Date hora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Status getPagamento() {
		return pagamento;
	}

	public void setPagamento(Status pagamento) {
		this.pagamento = pagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	
	
}
