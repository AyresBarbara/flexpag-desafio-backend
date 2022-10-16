package com.flexpag.paymentscheduler.utils;

import java.time.LocalDate;

import com.flexpag.paymentscheduler.exception.BadRequestException;
import com.flexpag.paymentscheduler.model.Agendamento;

public class Validar {
	public static void validarAgendamento(Agendamento agendamento){

        if(agendamento.getUsuario().length()==0)throw new BadRequestException("O campo deve ser preenchido");

        if(agendamento.getValor() == null || agendamento.getData() == null || agendamento.getUsuario() == null || agendamento.getHora() == null) throw new BadRequestException("Todos os campos devem estar preenchidos!");

        if(agendamento.getData().isBefore(LocalDate.now())) throw new BadRequestException("A nova data não pode ser menor que a data atual");

        if(agendamento.getValor() <= 0) throw new BadRequestException("O valor deve ser maior que R$ 0");
    }

}
