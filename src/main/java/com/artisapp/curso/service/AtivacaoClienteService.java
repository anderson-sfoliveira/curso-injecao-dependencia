package com.artisapp.curso.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.artisapp.curso.event.ClienteAtivadoEvent;
import com.artisapp.curso.modelo.Cliente;

@Component
public class AtivacaoClienteService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

//	Uma das formas de indicar um ponto de injeção
//	@Autowired(required = false)	
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//		
//		System.out.println("AtivacaoClienteService: " + notificador);
//	}

	@PostConstruct
	public void init() {
		System.out.println("INIT.");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}

//	Uma das formas de indicar um ponto de injeção
//	@Autowired(required = false)
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
}
