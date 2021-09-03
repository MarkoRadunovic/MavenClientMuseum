package rs.ac.bg.student.marko.MavenClientMuseum.form.izlozba;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Izlozba;

public class TableModelIzlozba extends AbstractTableModel {

    private List<Izlozba> list;
    private String[] index = new String[]{"Naziv izlozbe", "Datum pocetka", "Datum zavrsetka", "Broj eksponata", "Ocena izlozbe", "Kustos"};

    public TableModelIzlozba(List<Izlozba> list) {
        this.list = list;
        if (this.list == null) {
            this.list = new LinkedList<>();
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public String getColumnName(int i) {
        return index[i];
    }

    @Override
    public int getColumnCount() {
        return index.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Izlozba izlozba = list.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (i1) {
            case 0:
                return izlozba.getNazivIzlozbe();
            case 1:
                return sdf.format(izlozba.getDatumPocetka());
            case 2:
                return sdf.format(izlozba.getDatumZavrsetka());
            case 3:
                return izlozba.getBrojEksponata();
            case 4:
                return izlozba.getOcenaIzlozbe();
            case 5:
                return izlozba.getKustos();
            default:
                return null;
        }
    }

    public Izlozba getSelected(int row) {
        return list.get(row);
    }

    public void setList(List<Izlozba> list) {
        this.list = list;
        if (this.list == null) {
            this.list = new LinkedList<>();
        }
        fireTableDataChanged();
    }

}
