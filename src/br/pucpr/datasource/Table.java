package br.pucpr.datasource;

/**
 * Nesta versao sem uso de reflection, a tabela depende da interface TableDatasource para obter as informacoes a serem
 * desenhadas. Essa interface e que fara a abstracao dos dados.
 */
public class Table {
    private String colSeparator = " ";
    private String headerSeparator = "--------------------------------";

    public void print(TableDatasource data) {
        if (data.getRowCount() == 0)	 {
            System.out.println("No data to print...");
            return;
        }

        if (data.getColumnCount() == 0) {
            System.out.println("No columns to print...");
            return;
        }

        //HEADER SECTION
        for (int col = 0; col < data.getColumnCount(); col++) {
            System.out.print(data.getHeader(col));
            System.out.print(colSeparator);
        }

        System.out.println();
        System.out.println(headerSeparator);

        //LINES SECTION
        for (int row = 0; row < data.getRowCount(); row++) {
            for (int col = 0; col < data.getColumnCount(); col++) {
                System.out.printf(data.getFormat(col), data.getValueAt(row, col));
                System.out.print(colSeparator);
            }
            System.out.println();
        }
    }

    public Table setColumnSeparator(String colSeparator) {
        this.colSeparator = colSeparator;
        return this;
    }

    public Table setHeaderSeparator(String headerSeparator) {
        this.headerSeparator = headerSeparator;
        return this;
    }
}
