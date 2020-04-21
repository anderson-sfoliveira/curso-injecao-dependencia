package com.artisapp.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artisapp.curso.modelo.Cliente;
import com.artisapp.curso.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

//	Uma das formas de indicar um ponto de injeção
//	@Autowired(required = false)
	private Notificador notificador;

//	@Autowired(required = false)	
	public AtivacaoClienteService(@Autowired(required = false) Notificador notificador) {
		this.notificador = notificador;
		
		System.out.println("AtivacaoClienteService: " + notificador);
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
