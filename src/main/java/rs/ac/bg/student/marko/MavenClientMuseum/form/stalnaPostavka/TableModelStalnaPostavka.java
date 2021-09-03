package rs.ac.bg.student.marko.MavenClientMuseum.form.stalnaPostavka;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.student.marko.MavenCommonMuseum.domain.StalnaPostavka;

public class TableModelStalnaPostavka extends AbstractTableModel {

    private List<StalnaPostavka> list;
    private String[] index = new String[]{"Naziv postavke", "Datum formiranja", "Broj eksponata", "Kustos"};

    public TableModelStalnaPostavka(List<StalnaPostavka> list) {
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
    public int getColumnCount() {
        return index.length;
    }

    @Override
    public String getColumnName(int i) {
        return index[i];
    }

    @Override
    public Object getValueAt(int i, int i1) {
        StalnaPostavka stalnaPostavka = list.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (i1) {
            case 0:
                return stalnaPostavka.getNazivPostavke();
            case 1:
                return sdf.format(stalnaPostavka.getDatumFormiranja());
            case 2:
                return stalnaPostavka.getBrojEksponata();
            case 3:
                return stalnaPostavka.getKustos();
            default:
                return null;
        }
    }

    public StalnaPostavka getSelected(int i) {
        return list.get(i);
    }

    public void setList(List<StalnaPostavka> list) {
        this.list = list;
        if (this.list == null) {
            this.list = new LinkedList<>();
        }
        fireTableDataChanged();
    }

}
