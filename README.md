# curso-injecao-dependencia
 Curso de Spring e Injeção de Dependências

Injeção de Dependência nada mais é do que criar construtor que tenha como parâmetro outro objeto, ou seja, depende deste outro objeto para ser instanciada.

No Spring, os objetos que formam a espinha dorsal da sua aplicação e que sejam gerenciados pelo Spring são chamados de beans. Um bean é um objeto que é instanciado, montado e gerenciado pelo Spring IoC container.

Quando uma classe é anotada com @Component significa que ela deve ser gerenciada pelo Spring, ou seja, é um bean e será instanciada na inicialização da aplicação e colocada no Spring IoC container.

A classe @Controller também anota a classe como um @Component do Spring pois a anotação (classe) @Controller é anotada com @Component.

-------------

Quando o bean a ser instanciado possui um construtor mais complexo, como por exemplo precisa de um objeto que o Spring não gerencia, não podemos anotar essa classe com @Component pois o Spring não saberá como instacia-la.

Neste caso podemos criar uma classe anotada com @Configuration e metódos anotados com @Bean, quando a aplicação é iniciada esses metédos são executados e neles instanciamos os beans como for necessário.

-------------

Pontos de injeção é onde a gnt pode injetar os objetos dentro do nossos beans.

Por exemplo, a classe AtivacaoClienteService possui a dependência/atributo de Notificacao, então no construtor estamos passando o objeto Notificacao. O construtor é um ponto de injeção.

No nosso exemplo a classe AtivacaoClienteService possui somente um construtor então o Spring sabe o que executar. Caso a classe tivesse outro construtor o Spring não saberia qual construtor executar com isso daria erro.

Para resolver esse problema anotamos o método/construtor que queremos que seja executado com a anotação @Autowired.

Os 3 pontos de injeção mais comuns são : pelo construtor, pelo método setter e pelo declaração do atributo/dependência.

O ideal é usar como ponto de injeção, o construtor, pois nele fica claro quais são as dependências do bean.
