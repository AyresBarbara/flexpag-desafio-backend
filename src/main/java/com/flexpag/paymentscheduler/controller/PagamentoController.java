package com.flexpag.paymentscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.model.Pagamento;
import com.flexpag.paymentscheduler.repository.PagamentoRepository;

@RestController
@RequestMapping ("/pagamento")
@CrossOrigin ("*")
public class PagamentoController {
	
	@Autowired 
	private PagamentoRepository pagamentoRepository;
	
	@GetMapping 
	public ResponseEntity <List<Pagamento>> getAll(){
		return ResponseEntity.ok(pagamentoRepository.findAll());
	}
	@GetMapping ("/{id}") 
	public ResponseEntity<Pagamento> getById(@PathVariable Long id) {
		return pagamentoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	
    }
}

