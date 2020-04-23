package com.artisapp.curso.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.artisapp.curso.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador {

	private boolean caixaAlta;
	
	public NotificadorEmailMock() {
		System.out.println("NotificadorEmailMock");
	}
	
	public NotificadorEmailMock(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
		System.out.println("NotificadorEmailMock");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if (this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		
		System.out.printf("MOCK: Cliente seria notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
