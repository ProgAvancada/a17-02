package br.pucpr.sample;

import br.pucpr.datasource.TableDatasource;

import java.util.List;

/**
 * Cada objeto desse enum representa uma coluna que será desenhada na classe Planet. O enum pode guardar em suas
 * propriedades o cabeçalho e o formato e usar o polimorfismo para obter o valor. Assim fica evita-se o switch e
 * fica mais fácil acrescentar colunas ao Datasource (basta acrescentar um item na enumeração).
 */
enum PlanetColumns {
    MASS(" Massa", "%6.2f") {
        @Override
        public Object getValue(Planet planet) {
            return planet.getMass();
        }
    }, RADIUS("  Raio", "%6.2f") {
        @Override
        public Object getValue(Planet planet) {
            return planet.getRadius();
        }
    }, NAME("Planeta  ", "%-10s") {
        @Override
        public Object getValue(Planet planet) {
            return planet.getName();
        }
    };

    private String header;
    private String format;

    PlanetColumns(String header, String format) {
        this.header = header;
        this.format = format;
    }

    public String getHeader() {
        return header;
    }

    public String getFormat() {
        return format;
    }

    public abstract Object getValue(Planet planet);
}

/**
 * Esse datasource delega o trabalho ao enum de colunas.
 */
public class PlanetDatasource implements TableDatasource {
    private List<Planet> planets;

    public PlanetDatasource(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public String getHeader(int col) {
        return PlanetColumns.values()[col].getHeader();
    }

    @Override
    public int getColumnCount() {
        return PlanetColumns.values().length;
    }

    @Override
    public int getRowCount() {
        return planets.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return PlanetColumns.values()[col].getValue(planets.get(row));
    }

    @Override
    public String getFormat(int col) {
        return PlanetColumns.values()[col].getFormat();
    }
}
