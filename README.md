# gerenciador-series
Trabalho prático da disciplina de Algoritmos e Estruturas de Dados II do curso de Engenharia de Software - PUC Minas

## Contexto
A Netflix é uma provedora global de filmes e séries de televisão via streaming, atualmente com mais de 100 milhões de assinantes. Fundada em 1997 nos Estados Unidos, a empresa surgiu como um serviço de entrega de DVD pelo correio. A expansão do *streaming*, disponível nos Estados Unidos a partir de 2007, começou pelo Canadá em 2010. Hoje, mais de 190 países têm acesso à plataforma. Sua primeira websérie original de sucesso foi House of Cards, lançada em 2013.

Hoje em dia, a empresa produz centenas de horas de programação original em diferentes países do mundo, querendo aprimorar-se nas aplicações e em novas programações. Os planos foram apresentados no Mobile World Congress em Barcelona, Espanha. Em setembro de 2016 a empresa anunciou que planeja ter 50% do catálogo composto de produções originais (fonte: Wikipedia 2018).

## Proposta
Projetar uma aplicação em Java para organizar o histórico de séries assistidas por um usuário. Para isso, você recebeu um banco de dados em formato .txt [(Series.txt)](https://github.com/Haddadson/gerenciador-series/blob/master/src/util/Series.txt) de todas as séries disponíveis para exibição.

Estes dados contém os seguintes campos separados por “;”.

> Nome;Tipo;Duracao;Pais;Idioma;Emissora;Transmissao;Num_Temporadas;Num_Episodios

Você deve usar uma estrutura de Lista, fazer a leitura dos dados do arquivo e armazena-los numa lista de objetos do tipo Série. Esta é outra estrutura que você também deve projetar. Além disso, você deve permitir que o usuário que execute as seguintes operações:

 - Visualize todas as séries disponíveis para exibição
 - Busque por série na lista de séries disponíveis
 - Crie sua lista de séries favoritas
 - Remova elementos da sua lista de séries favoritas
 - Visualize sua lista de séries favoritas

Considerando a lista de séries favoritas, crie uma opção para sugestão de uma série baseada em algum atributo da lista de séries ou em escolha aleatória.

### Observações

 1. Nenhuma lista pode conter nomes elementos repetidos. Assim crie as validações necessárias pra evitar a ocorrência de duplicidades e manter a consistência dos dados.
 2. A utilização de interfaces gráficas é opcional. 
 
