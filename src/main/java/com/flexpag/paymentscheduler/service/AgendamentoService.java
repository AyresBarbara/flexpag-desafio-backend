package com.flexpag.paymentscheduler.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.paymentscheduler.exception.BadRequestException;
import com.flexpag.paymentscheduler.exception.NotFoundException;
import com.flexpag.paymentscheduler.model.Agendamento;
import com.flexpag.paymentscheduler.repository.AgendamentoRepository;
import com.flexpag.paymentscheduler.utils.Status;
import com.flexpag.paymentscheduler.utils.Validar;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRep;
	
	public Agendamento agendarPag (Agendamento agendamento) {
		
		Validar.validarAgendamento(agendamento);
		
		agendamento.setPagamento(Status.PENDING);
		return this.agendamentoRep.save(agendamento);
	}
	public Agendamento consultarAgendamento (Long id) {
		
		Optional <Agendamento>agendamento = this.agendamentoRep.findById(id);
		return agendamento.orElseThrow(() -> new NotFoundException("Não foi possivel encontrar esse agendamento!"));
	}
	public Agendamento realizarPagamento(Long id) {
		
        Agendamento agendamento = this.consultarAgendamento(id);
        agendamento.setPagamento(Status.PAID);
        return this.agendamentoRep.save(agendamento);
    }
	public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoAtualizado) {
        
		Agendamento agendamento = this.consultarAgendamento(id);

        if (agendamento.getPagamento() == Status.PAID) throw new BadRequestException("Pagamento efeutado com sucesso, não pode ser atualizado");
        Validar.validarAgendamento(agendamentoAtualizado);

        agendamento.setUsuario(agendamentoAtualizado.getUsuario());
        agendamento.setHora(agendamentoAtualizado.getHora());
        agendamento.setData(agendamentoAtualizado.getData());
        agendamento.setValor(agendamentoAtualizado.getValor());

        return this.agendamentoRep.save(agendamento);
    }
	public void excluirAgendamento(Long id) {
		
        Agendamento agendamento = this.consultarAgendamento(id);

        if(agendamento.getPagamento() == Status.PAID) throw new BadRequestException("Pagamento executado com sucesso, não pode ser deletado!");

        this.agendamentoRep.deleteById(id);

    }
	public Status consultarPagamento(Long id) {
		
        Agendamento agendamento = this.consultarAgendamento(id);
        return agendamento.getPagamento();
    }
	
	
}
