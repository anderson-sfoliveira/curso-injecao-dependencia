package com.artisapp.curso.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.artisapp.curso.event.ClienteAtivadoEvent;
import com.artisapp.curso.notificacao.NivelUrgencia;
import com.artisapp.curso.notificacao.Notificador;
import com.artisapp.curso.notificacao.TipoDoNotificador;

@Component
public class NotificacaoService {

	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
	}
	
}