package com.artisapp.curso.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artisapp.curso.modelo.Cliente;
import com.artisapp.curso.notificacao.NivelUrgencia;
import com.artisapp.curso.notificacao.Notificador;
import com.artisapp.curso.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {

	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired(required = false)
	private Notificador notificador;

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
		
		if (this.notificador != null) {
			this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		} else {
			System.out.println("Não existe notificador, mas cadastro do cliente foi ativado.");
		}
		
	}

//	Uma das formas de indicar um ponto de injeção
//	@Autowired(required = false)
	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}
}
