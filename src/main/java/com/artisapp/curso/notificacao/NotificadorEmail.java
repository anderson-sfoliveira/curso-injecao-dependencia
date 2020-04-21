package com.artisapp.curso.notificacao;

import com.artisapp.curso.modelo.Cliente;

public class NotificadorEmail implements Notificador {

	private boolean caixaAlta;
	
	public NotificadorEmail(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
		System.out.println("NotificadorEmail");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if (this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
