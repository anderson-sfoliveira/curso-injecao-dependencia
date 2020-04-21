package com.artisapp.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artisapp.curso.notificacao.Notificador;
import com.artisapp.curso.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {

	@Bean
	public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
		System.out.println("ServiceConfig");
		return new AtivacaoClienteService(notificador);
	}
	
}
