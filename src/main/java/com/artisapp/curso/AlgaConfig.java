package com.artisapp.curso;

import org.springframework.context.annotation.Bean;

import com.artisapp.curso.notificacao.NotificadorEmail;
import com.artisapp.curso.service.AtivacaoClienteService;

public class AlgaConfig {

	/*
	 * 
	 * Como a classe não está mais anotada com @Configuration o Spring não irá gerencia-la.
	 * Fora criada uma classe específica para cada bean. 
	 * 
	 */
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
