# Desenvolvimento de Aplicações Web - AV2

[![Build Status](https://travis-ci.org/lgcavalheiro/webdev-av2.svg?branch=master)](https://travis-ci.org/lgcavalheiro/webdev-av2)

## Grupo

    Lucas Guimarães Cavalheiro - 2012200347
    Wallace Arruda de Macedo - 2013101787

# Instruções

Para buildar o projeto, basta usar o wrapper do gradle de acordo com seu sistema operacional: gradlew.bat (Windows) ou ./gradlew (Unix). Para exemplificar os comandos a seguir, estaremos adotando o padrão Unix.

Para rodar o projeto pela primeira vez, basta rodar o comando `./gradlew devSass tomcatRun`. Caso queira rodar o projeto múltiplas vezes, e os arquivos da pasta scss não tenham sido alterados, basta rodar `./gradlew tomcatRun`.

ATENÇÃO!

O projeto depende de uma base de dados MySQL, uma está disponível na núvem pronta para uso, as credenciais para a mesma estarão disponíveis em uma anotação a parte. Caso queira rodar o banco de dados MySQL localmente, temos um arquivo de dump da base de dados original, que poderá ser carregada localmente com ferramentas como MySQL Workbench, após carregar a base de dados local, basta fazer o projeto apontar para o banco em localhost, definindo as credenciais adequadas no arquivo `src/main/java/av2/webdev/model/utils/DatabaseCredentialsGetter.java`.