package com.flexpag.paymentscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.model.Agendamento;
import com.flexpag.paymentscheduler.service.AgendamentoService;
import com.flexpag.paymentscheduler.utils.Status;

@RestController
@RequestMapping ("/agendamento")
@CrossOrigin ("*")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@PostMapping("/agendamento")
    public ResponseEntity<Agendamento> agendarPag(@RequestBody Agendamento agendamento) {
		
        Agendamento novoAgendamento = this.agendamentoService.agendarPag(agendamento);
        return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
	}
	@PatchMapping("/pagamento/{id}")
    public ResponseEntity<Agendamento> realizarPagamento(@PathVariable Long id) {
		
        Agendamento boletoPago = this.agendamentoService.realizarPagamento(id);
        return new ResponseEntity<>(boletoPago, HttpStatus.OK);
    }
	@PutMapping("/agendamento/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
		
        Agendamento agendamentoAtualizado = this.agendamentoService.atualizarAgendamento(id, agendamento);
        return new ResponseEntity<>(agendamentoAtualizado, HttpStatus.OK);
    }
	@DeleteMapping("/agendamento/{id}")
    public ResponseEntity<Object> excluirAgendamento(@PathVariable Long id) {
		
        this.agendamentoService.excluirAgendamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	@GetMapping("/status/{id}")
    public ResponseEntity<Status> consultarPagamento(@PathVariable Long id) {
		
        Status statusAgendamento = this.agendamentoService.consultarPagamento(id);
        return new ResponseEntity<>(statusAgendamento, HttpStatus.OK);
    }
	
}