package rs.ac.bg.student.marko.MavenClientMuseum.form.kustos;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Kustos;

public class TableModelKustos extends AbstractTableModel {

    private String[] kolone = new String[]{"Ime", "Prezime", "Adresa", "Specijalnost"};
    private List<Kustos> list;

    public TableModelKustos(List<Kustos> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Kustos kustos = list.get(i);
        switch (i1) {
            case 0:
                return kustos.getIme();
            case 1:
                return kustos.getPrezime();
            case 2:
                return kustos.getAdresa();
            case 3:
                return kustos.getSpecijalnost().getOblast();
            default:
                return "";
        }
    }

    public Kustos getSelected(int row) {
        return list.get(row);
    }
}
