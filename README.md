# Uso do padrão Data Mapper

Neste exemplo, resolvemos novamente o exercício proposto para a atividade de reflection, sem usar esse recurso.

O problema que queremos resolver é: Como fazer com que a tabela possa imprimir os dados de qualquer classe, sem que 
precisemos alterar a implementação da classe que ela imprime? 

A solução para isso está no padrão [Data Mapper](https://en.wikipedia.org/wiki/Data_mapper_pattern). Neste padrão 
criamos uma interface que encapsula o acesso aos dados (DataSource). A tabela então consulta essa interface na hora de 
se desenhar.

Nesta implementação, a interface foi chamada de 
[TableDatasource](https://github.com/ProgAvancada/a17-02/blob/master/src/br/pucpr/datasource/TableDatasource.java)
e define métodos para informar a tabela a quantidade de linhas, colunas, cabeçalhos, valores e formatos de dado. 
Enquanto a classe [Table](https://github.com/ProgAvancada/a17-02/blob/master/src/br/pucpr/datasource/Table.java) 
continua encarregada pelo desenho da tabela em si.

Foram feitas duas implementações diferentes dessa interface. A 
[DogDatasource](https://github.com/ProgAvancada/a17-02/blob/master/src/br/pucpr/sample/DogDatasource.java), mais 
simples e direta, porém com o mau cheiro de ter vários switchs. E a 
[PlanetDatasource](https://github.com/ProgAvancada/a17-02/blob/master/src/br/pucpr/sample/PlanetDatasource.java) que 
resolve o mal cheiro criando um 
[enum de colunas](https://github.com/ProgAvancada/a17-02/blob/master/src/br/pucpr/sample/PlanetDatasource.java#L12-L47).

 Observe que o resultado final, ao executar o main é exatamente o mesmo do projeto com reflection.