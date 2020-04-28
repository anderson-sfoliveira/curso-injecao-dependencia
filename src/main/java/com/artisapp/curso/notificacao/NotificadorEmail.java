package com.artisapp.curso.notificacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.artisapp.curso.modelo.Cliente;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

	@Value("${notificacao.email.porta-host}")
	private String host;
	
	@Value("${notificacao.email.porta-servidor}")
	private Integer porta;

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
		
		System.out.println("Host : " + host);
		System.out.println("Porta : " + porta);
		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
