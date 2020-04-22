package com.artisapp.curso.notificacao;

import org.springframework.stereotype.Component;

import com.artisapp.curso.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

	private boolean caixaAlta;
	
	public NotificadorEmail() {
		System.out.println("NotificadorEmail");
	}
	
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
