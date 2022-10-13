package com.flexpag.paymentscheduler.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.model.Agendamento;
import com.flexpag.paymentscheduler.repository.AgendamentoRepository;
import com.flexpag.paymentscheduler.repository.PagamentoRepository;

@RestController
@RequestMapping ("/agendamento")
@CrossOrigin ("*")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@GetMapping
	public ResponseEntity<List<Agendamento>> GetAll(){
		return ResponseEntity.ok(agendamentoRepository.findAll());
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Agendamento> GetById(@PathVariable Long id){
	 return agendamentoRepository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Agendamento> post (@RequestBody Agendamento agendamento){
		if(pagamentoRepository.existsById(agendamento.getPagamento().getId()))
			return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoRepository.save(agendamento));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	@PutMapping
	public ResponseEntity <Agendamento> put (@Valid @RequestBody Agendamento agendamento){ 
		if(agendamentoRepository.existsById(agendamento.getId())) {
			
			if (pagamentoRepository.existsById(agendamento.getPagamento().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(agendamentoRepository.save(agendamento));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
		
	@DeleteMapping("/{id}")
		private void delete (@PathVariable Long id) {
			agendamentoRepository.deleteById(id);
		}
	}

