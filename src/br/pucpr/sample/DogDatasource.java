package br.pucpr.sample;

import br.pucpr.datasource.TableDatasource;

import java.util.List;

public class DogDatasource implements TableDatasource {
    private static final int COL_AGE = 0;
    private static final int COL_NAME = 1;
    private static final int COL_PRICE = 2;

    private List<Dog> dogs;

    public DogDatasource(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String getHeader(int col) {
        switch (col) {
            case COL_AGE:
                return "age";
            case COL_NAME:
                return "name";
            case COL_PRICE:
                return "";
        }
        return "?";
    }

    @Override
    public int getColumnCount() {
        return 3; //Iremos imprimir 3 campos
    }

    @Override
    public int getRowCount() {
        return dogs.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Dog dog = dogs.get(row);
        switch (col) {
            case COL_AGE:
                return dog.getAge();
            case COL_NAME:
                return dog.getName();
            case COL_PRICE:
                return dog.getPrice();
        }
        return 0;
    }

    @Override
    public String getFormat(int col) {
        switch (col) {
            case COL_AGE:
                return "%02d ";
            case COL_NAME:
                return "%-20s";
            case COL_PRICE:
                return "%7.2f";
        }
        return "";
    }
}
