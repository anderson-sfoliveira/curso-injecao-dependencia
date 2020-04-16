package com.artisapp.curso;

import com.artisapp.curso.modelo.Cliente;
import com.artisapp.curso.service.AtivacaoClienteService;

public class Main {

	public static void main(String[] args) {
		Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888");
		Cliente maria = new Cliente("Maria", "maria@xyz.com", "1177772222");
		
		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService();
		ativacaoCliente.ativar(joao);
		ativacaoCliente.ativar(maria);
	}
	
}
