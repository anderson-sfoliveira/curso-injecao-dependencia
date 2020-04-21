package com.artisapp.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artisapp.curso.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		System.out.println("NotificacaoConfig");
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		notificador.setCaixaAlta(true);
		
		return notificador;
	}
}
