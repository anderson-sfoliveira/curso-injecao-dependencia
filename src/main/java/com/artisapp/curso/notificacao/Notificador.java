package com.artisapp.curso.notificacao;

import com.artisapp.curso.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);
	
}
