package com.flexpag.paymentscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexpag.paymentscheduler.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository <Agendamento, Long>{
	

}
