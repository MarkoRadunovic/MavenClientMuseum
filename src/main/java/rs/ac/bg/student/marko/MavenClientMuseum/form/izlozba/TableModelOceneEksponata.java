package rs.ac.bg.student.marko.MavenClientMuseum.form.izlozba;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.student.marko.MavenCommonMuseum.domain.OcenaEksponata;

public class TableModelOceneEksponata extends AbstractTableModel {

    private List<OcenaEksponata> list;
    private String[] index = new String[]{"Naziv", "Visina", "Tezina", "Starost", "Tip eksponata", "Stalna postavka", "Ocena"};

    public TableModelOceneEksponata(List<OcenaEksponata> list) {
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
        OcenaEksponata ocenaEksponata = list.get(i);
        switch (i1) {
            case 0:
                return ocenaEksponata.getEksponat().getNazivEksponata();
            case 1:
                return ocenaEksponata.getEksponat().getVisina();
            case 2:
                return ocenaEksponata.getEksponat().getTezina();
            case 3:
                return ocenaEksponata.getEksponat().getStarost();
            case 4:
                return ocenaEksponata.getEksponat().getTipEksponata().getNazivTipaEksponata();
            case 5:
                return ocenaEksponata.getEksponat().getStalnaPostavka().getNazivPostavke();
            case 6:
                return ocenaEksponata.getOcena();
            default:
                return null;
        }
    }

    public OcenaEksponata getSelected(int i) {
        return list.get(i);
    }

    public List<OcenaEksponata> getList() {
        return list;
    }

    public void remove(int i){
        list.remove(i);
        fireTableDataChanged();
    }
    
    public void add(OcenaEksponata ocenaEksponata) throws Exception{
        for(OcenaEksponata ocena: list)
            if(ocena.getEksponat().equals(ocenaEksponata.getEksponat()))
                throw new Exception("Vec postoji ocena za ovaj eksponat");
        list.add(ocenaEksponata);
        fireTableDataChanged();
    }

}

