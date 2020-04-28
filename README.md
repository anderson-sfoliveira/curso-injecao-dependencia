# curso-injecao-dependencia
 Curso de Spring e Injeção de Dependências

Injeção de Dependência nada mais é do que criar construtor que tenha como parâmetro outro objeto, ou seja, depende deste outro objeto para ser instanciada.

No Spring, os objetos que formam a espinha dorsal da sua aplicação e que sejam gerenciados pelo Spring são chamados de beans. Um bean é um objeto que é instanciado, montado e gerenciado pelo Spring IoC container.

Quando uma classe é anotada com @Component significa que ela deve ser gerenciada pelo Spring, ou seja, é um bean e será instanciada na inicialização da aplicação e colocada no Spring IoC container.

A classe @Controller também anota a classe como um @Component do Spring pois a anotação (classe) @Controller é anotada com @Component.

-------------

Quando o bean a ser instanciado possui um construtor mais complexo, como por exemplo precisa de um objeto que o Spring não gerencia, não podemos anotar essa classe com @Component pois o Spring não saberá como instacia-la.

Neste caso podemos criar uma classe anotada com @Configuration e metódos anotados com @Bean, quando a aplicação é iniciada esses metédos são executados e neles instanciamos os beans como for necessário.

Por exemplo, no nosso projeto criamos a classe NotificacaoConfig para criar o bean de notificação, pois no construtor da classe NotificadorEmail é necessário passar o valor do atributo caixaAlta.

-------------

Pontos de injeção é onde a gnt pode injetar os objetos dentro do nossos beans.

Por exemplo, a classe AtivacaoClienteService possui a dependência/atributo de Notificacao, então no construtor estamos passando o objeto Notificacao. O construtor é um ponto de injeção.

No nosso exemplo a classe AtivacaoClienteService possui somente um construtor então o Spring sabe o que executar. Caso a classe tivesse outro construtor o Spring não saberia qual construtor executar com isso daria erro.

Para resolver esse problema anotamos o método/construtor que queremos que seja executado com a anotação @Autowired.

Os 3 pontos de injeção mais comuns são : pelo construtor, pelo método setter e pelo declaração do atributo/dependência.

O ideal é usar como ponto de injeção, o construtor, pois nele fica claro quais são as dependências do bean.

Mas provavelmente o mais usado é na declaração do atributo/dependência. Todos os atributos que são dependência para o bean são anotadas com @Autowired.

---------------

Dependência opcional com @Autowired

As vezes uma dependência não é obrigatória então anotamos com @Autowired(required = false).

Por exemplo, na classe AtivacaoClienteService colocamos o atributo notificador como opcional e no método de ativar o cliente somente iremos chamar o método notificar caso o atributo notificador tenha uma instância.

----------------

Desambiguação de beans:

Caso um bean tenha 2 implementações , como por exemplo da notificação tivesse uma notificaçãoEmail e uma notificaçãoSMS, qual o Spring deveria usar ao instanciar o bean AtivacaoClienteService ? o Spring não saberia e daria erro.

Como resolver:

1ª opção: no bean AtivacaoClienteService criariamos uma lista de notificação para receber todos os beans de notificação.

2ª opção: anotar com @Primary a classe do bean de notificação que deverá ser priorizada e usada em AtivacaoClienteService.

3ª opção: anotar com @Qualifier("uma_descrição") as classes de bean notificação , e na dependência da classe AtivacaoClienteService também anotar com @Qualifier e usar a descrição da classe bean desejada.

------------------

Mudando o comportamento da aplicação com Spring Profiles:

É como se fosse o @Qualifier porém com a anotação @Profile.

No arquivo de configuração "application.properties" usamos a seguinte configuração:

spring.profiles.active=[nome dos profiles, podendo ser 'n']

É muito usado para controlar os beans que serão gerenciados em modo de produção ou desenvolvido. Ou qual banco de dados será usado.

-------------------

Criando métodos de callback do ciclo de vida dos beans:

Às vezes é necessário executar algum método após a criação ou destruição do bean, por exemplo.

Uma das formas de fazer isso é usar anotar os métodos com as seguintes anotações:

	@PostConstruct - o método é executado após a criação do bean.
	@PreDestroy - o método é executação antes da destruição do bean.

É recomendado usar o mesmo nome de métodos em todas as classes de bean.

--------------------

Coesão e Acoplamento - publicando e consumindo eventos customizados:

Coesão está, na verdade, ligado ao princípio da responsabilidade única, que diz que uma classe deve ter apenas uma única responsabilidade e realizá-la de maneira satisfatória, ou seja, uma classe não deve assumir responsabilidades que não são suas. Uma vez sendo ignorado este princípio, passamos a ter problemas, como dificuldades de manutenção e de reuso.

Nosso exemplo a classe "AtivacaoClienteService" tem responsabilidade de notificar o cliente, que não é sua responsabilidade. Então, dizemos que esta classe não está coesa, ou seja, ela tem responsabilidades demais, e o que é pior, responsabilidades que não são suas.

O que temos que ter em mente é que uma classe deve ser responsável por exercer uma única responsabilidade e fazer outras classes cooperarem quando necessário. Já o acoplamento significa o quanto uma classe depende da outra para funcionar. E quanto maior for esta dependência entre ambas, dizemos que estas classes elas estão fortemente acopladas.

Para resolver o problema de coesão e acoplamento do nosso exemplo , precisamos remover a responsabilidade de notificar o cliente da classe "AtivacaoClienteService".

Neste caso publicamos um evento e consumimos ele.

Para criar publir um evento basta criar um objeto abaixo e no momento oportuno chamar o método "publishEvent" passando como parâmetro o objeto do evento.

	private ApplicationEventPublisher eventPublisher;

	eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));

Para consumir o evento criamos um novo @Component com um método anotado com @EventListener e recebendo como parâmetro o objeto do evento.

	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("Emitindo nota fiscal para cliente " + event.getCliente().getNome());
	}

Precisamos também criar a classe do evento ( neste caso "ClienteAtivadoEvent" ), classe simples, sem anotação do Spring.

-----------------

Criando e acessando propriedades customizadas com @Value:

No arquivo "application.properties" podemos criar variáveis com valores. Exemplo:

notificacao.email.porta-servidor=8811

Para acessar esse valor em alguma classe , a declaração do atributo deve usar a anotação abaixo:

@Value("${notificacao.email.porta-servidor}")
private Integer porta;

-----------------