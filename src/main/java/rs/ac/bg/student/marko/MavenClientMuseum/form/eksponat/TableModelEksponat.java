package rs.ac.bg.student.marko.MavenClientMuseum.form.eksponat;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Eksponat;

public class TableModelEksponat extends AbstractTableModel {

    private List<Eksponat> list;
    private String[] index = new String[]{"Naziv", "Visina", "Tezina", "Starost", "Tip eksponata", "Stalna postavka"};

    public TableModelEksponat(List<Eksponat> list) {
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
        Eksponat eksponat = list.get(i);
        switch (i1) {
            case 0:
                return eksponat.getNazivEksponata();
            case 1:
                return eksponat.getVisina();
            case 2:
                return eksponat.getTezina();
            case 3:
                return eksponat.getStarost();
            case 4:
                return eksponat.getTipEksponata().getNazivTipaEksponata();
            case 5:
                return eksponat.getStalnaPostavka().getNazivPostavke();
            default:
                return null;
        }
    }

    public Eksponat getSelected(int i) {
        return list.get(i);
    }


}