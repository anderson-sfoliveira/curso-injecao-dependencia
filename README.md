# curso-injecao-dependencia
 Curso de Spring e Injeção de Dependências

Injeção de Dependência nada mais é do que criar construtor que tenha como parâmetro outro objeto, ou seja, depende deste outro objeto para ser instanciada.

No Spring, os objetos que formam a espinha dorsal da sua aplicação e que sejam gerenciados pelo Spring são chamados de beans. Um bean é um objeto que é instanciado, montado e gerenciado pelo Spring IoC container.

Quando uma classe é anotada com @Component significa que ela deve ser gerenciada pelo Spring, ou seja, é um bean e será instanciada na inicialização da aplicação e colocada no Spring IoC container.

A classe @Controller também anota a classe como um @Component do Spring pois a anotação (classe) @Controller é anotada com @Component.


