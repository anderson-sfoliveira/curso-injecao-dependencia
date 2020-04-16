package com.artisapp.curso.service;

import com.artisapp.curso.modelo.Cliente;
import com.artisapp.curso.notificacao.NotificadorEmail;

public class AtivacaoClienteService {

	private NotificadorEmail notificador = new NotificadorEmail();
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
	
}
