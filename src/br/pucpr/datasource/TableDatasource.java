package br.pucpr.datasource;

/**
 * A interface TableDatasource "explica" para a tabela quais dados serão impressos.
 */
public interface TableDatasource {
    /**
     * Implemente esse método para retornar o cabeçalho da coluna indicada no parâmetro col
     */
    String getHeader(int col);

    /**
     * Retorne aqui a quantidade de colunas que a tabela terá
     */
    int getColumnCount();

    /**
     * Retorne aqui a quantidade de linhas que a tabela terá
     */
    int getRowCount();

    /**
     * Retorne o valor desejado para a linha e coluna informadas por parametro
     */
    Object getValueAt(int row, int col);

    /**
     * Retorne o formato do dado da coluna indicada
     */
    String getFormat(int col);
}
