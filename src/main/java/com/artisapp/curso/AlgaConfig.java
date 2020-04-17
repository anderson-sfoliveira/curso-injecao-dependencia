package com.artisapp.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artisapp.curso.notificacao.NotificadorEmail;
import com.artisapp.curso.service.AtivacaoClienteService;

@Configuration
public class AlgaConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		System.out.println("AlgaConfig -> notificadorEmail");
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		notificador.setCaixaAlta(true);
		
		return notificador;
	}
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService(notificadorEmail());
	}
}
