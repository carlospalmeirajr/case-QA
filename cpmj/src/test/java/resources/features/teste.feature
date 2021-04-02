# language:pt

@validar_historias
Funcionalidade: Efetuar compra na loja

  @historia1
  Cenário: Validar visualização de produto através da barra de pesquisa
  Dado efetuar um novo cadastro
  E logar com o usuário
  Quando pesquisar o item "Faded Short Sleeve T-shirts" no site
  Então validar que o resultado da busca consta o item

  @historia2
  Cenário: Validar produto na tela de checkout
  Dado efetuar um novo cadastro
  E logar com o usuário
  Quando adicionar o item "Faded Short Sleeve T-shirts" no carrinho
  Então validar que o produto foi adicionado ao carrinho

  @historia3
  Cenário: Validar que a mensagem de serviço ao consumidor foi enviada com sucesso
  Dado efetuar um novo cadastro
  E logar com o usuário
  Quando enviar uma mensagem ao serviço ao consumidor
  Então validar que a mensagem foi enviada com sucesso