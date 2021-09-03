package rs.ac.bg.student.marko.MavenClientMuseum.form.izlozba;

import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.student.marko.MavenClientMuseum.controller.ClientController;
import rs.ac.bg.student.marko.MavenClientMuseum.form.FormEnum;
import rs.ac.bg.student.marko.MavenClientMuseum.form.eksponat.TableModelEksponat;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Eksponat;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Izlozba;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Kustos;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.OcenaEksponata;

public class NewIzlozbaForm extends javax.swing.JDialog {


    private Izlozba izlozba;
    private FormEnum formEnum;
    private TableModelEksponat tableModelEksponat;
    private TableModelOceneEksponata  tableModelOceneEksponata;
    public NewIzlozbaForm(java.awt.Frame parent, boolean modal,FormEnum formEnum, Izlozba izlozba) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.izlozba = izlozba;
        this.formEnum = formEnum;
        try {
            List<Kustos> list = ClientController.getInstance().getAllKustosi();
            cmbKustos.removeAllItems();
            for (Kustos k: list) {
                cmbKustos.addItem(k);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof SocketException) {
                JOptionPane.showMessageDialog(this, "Server vam je prekinuo komunikaciju! Gasenje programa...", "Greska", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }

        if(formEnum.equals(FormEnum.IZMENA)){
            SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yyyy");
            txtNazivIzlozbe.setText(izlozba.getNazivIzlozbe());
            txtDatumPocetka.setText(sdf.format(izlozba.getDatumPocetka()));
            txtDatumZavrsetka.setText(sdf.format(izlozba.getDatumZavrsetka()));
            cmbKustos.setSelectedItem(izlozba.getKustos());
        }
        
        setTableModel();
    }
    
    private void setTableModel() {
        try {
            List<Eksponat> listaKandidata = ClientController.getInstance().getAllEksponati();
            tableModelEksponat = new TableModelEksponat(listaKandidata);
            tblEksponati.setModel(tableModelEksponat);

            if(formEnum.equals(FormEnum.IZMENA))
                tableModelOceneEksponata = new TableModelOceneEksponata(izlozba.getList());
            else
                tableModelOceneEksponata = new TableModelOceneEksponata(new LinkedList<OcenaEksponata>());
            tblOceneEksponata.setModel(tableModelOceneEksponata);

        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof SocketException) {
                JOptionPane.showMessageDialog(this, "Server vam je prekinuo komunikaciju! Gasenje programa...", "Greska", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNazivIzlozbe = new javax.swing.JTextField();
        txtDatumPocetka = new javax.swing.JFormattedTextField();
        txtDatumZavrsetka = new javax.swing.JFormattedTextField();
        cmbKustos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEksponati = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOceneEksponata = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        txtOcenaEksponata = new javax.swing.JTextField();
        btnObrisiOcenu = new javax.swing.JButton();
        btnDodajOcenu = new javax.swing.JToggleButton();
        lblOpsegOcene = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv izložbe:");

        jLabel2.setText("Datum početka:");

        jLabel3.setText("Datum završetka:");

        jLabel4.setText("Kustos:");

        txtDatumPocetka.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        txtDatumZavrsetka.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        jLabel5.setText("Eksponat:");

        tblEksponati.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEksponati);

        jLabel6.setText("Ocene eksponata:");

        tblOceneEksponata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblOceneEksponata);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnObrisiOcenu.setText("Obriši ocenu");
        btnObrisiOcenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiOcenuActionPerformed(evt);
            }
        });

        btnDodajOcenu.setText("Dodaj ocenu");
        btnDodajOcenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajOcenuActionPerformed(evt);
            }
        });

        lblOpsegOcene.setText("[1-10]");

        lblHint.setText("(Datume unositi u formatu: dd.MM.yyyy)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtOcenaEksponata, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOpsegOcene)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                        .addComponent(btnDodajOcenu)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisiOcenu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHint)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbKustos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumZavrsetka)
                            .addComponent(txtNazivIzlozbe)
                            .addComponent(txtDatumPocetka))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNazivIzlozbe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatumZavrsetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbKustos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblHint)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtOcenaEksponata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisiOcenu)
                    .addComponent(btnDodajOcenu)
                    .addComponent(lblOpsegOcene))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSacuvaj))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
    }                                         

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try{
            String nazivIzlozbe = txtNazivIzlozbe.getText().trim();
            if(nazivIzlozbe.isEmpty())
                throw new Exception("Niste uneli naziv izlozbe");
            
            String datumPocetkaText = txtDatumPocetka.getText();
            if(datumPocetkaText.isEmpty())
                throw new Exception("Niste uneli datum pocetka");
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumPocetka = sdf.parse(datumPocetkaText);
            
            String datumZavrsetkaText = txtDatumZavrsetka.getText();
            if(datumZavrsetkaText.isEmpty())
                throw new Exception("Niste uneli datum pocetka");
            Date datumZavrsetka = sdf.parse(datumZavrsetkaText);
            
            if(datumPocetka.after(new Date()))
                throw new Exception("Datum pocetka mora biti pre sadasnjeg datuma");
            if(datumZavrsetka.after(new Date()))
                throw new Exception("Datum zavrsetka mora biti pre sadasnjeg datuma");
            if(datumPocetka.after(datumZavrsetka))
                throw new Exception("Datum zavrsetka mora biti posle datuma pocetka");
            Kustos kustos = (Kustos)cmbKustos.getSelectedItem();
            
            
            List<OcenaEksponata> list = tableModelOceneEksponata.getList();
            if(list.isEmpty())
                throw new Exception("Morate uneti barem jednu ocenu eksponata");
            
            int brojEksponata = list.size();
            int sumOcena = 0;
            for(OcenaEksponata o:list)
                sumOcena+=o.getOcena();
            double ocenaIzlozbe = (double)sumOcena/list.size();
            
            izlozba.setNazivIzlozbe(nazivIzlozbe);
            izlozba.setDatumPocetka(datumPocetka);
            izlozba.setDatumZavrsetka(datumZavrsetka);
            izlozba.setKustos(kustos);
            izlozba.setBrojEksponata(brojEksponata);
            izlozba.setOcenaIzlozbe(ocenaIzlozbe);
            izlozba.setList(list);
            if(formEnum.equals(FormEnum.IZMENA)){
                ClientController.getInstance().editIzlozba(izlozba);
                JOptionPane.showMessageDialog(this, "Uspesno ste izmenili izlozbu");
            }else{
                ClientController.getInstance().saveIzlozba(izlozba);
                JOptionPane.showMessageDialog(this, "Uspesno ste sacuvali izlozbu");
            }
            this.dispose();
        }catch(Exception ex){
            ex.printStackTrace();
            if (ex instanceof SocketException) {
                JOptionPane.showMessageDialog(this, "Server vam je prekinuo komunikaciju! Gasenje programa...", "Greska", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }                                          

    private void btnDodajOcenuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try{
            int row = tblEksponati.getSelectedRow();
            if(row>-1){
                Eksponat eksponat = tableModelEksponat.getSelected(row);
                String ocenaText = txtOcenaEksponata.getText();
                if(ocenaText.isEmpty())
                    throw new Exception("Niste uneli ocenu eksponata");
                int ocena = Integer.parseInt(txtOcenaEksponata.getText());
                if(ocena<0 || ocena >10)
                    throw new Exception("Ocena eksponata mora biti broj izmedju 0 i 10");
                OcenaEksponata ocenaEksponata = new OcenaEksponata(izlozba, eksponat, ocena);
                tableModelOceneEksponata.add(ocenaEksponata);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            if (ex instanceof SocketException) {
                JOptionPane.showMessageDialog(this, "Server vam je prekinuo komunikaciju! Gasenje programa...", "Greska", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }if(ex instanceof NumberFormatException){
                JOptionPane.showMessageDialog(this, "Niste ispravno uneli ocenu eksponata. Mogu se uneti samo brojevi");
            }else
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }                                             

    private void btnObrisiOcenuActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int row  = tblOceneEksponata.getSelectedRow();
        if(row >-1){
            tableModelOceneEksponata.remove(row);
        }
    }                                              


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancel;
    private javax.swing.JToggleButton btnDodajOcenu;
    private javax.swing.JButton btnObrisiOcenu;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cmbKustos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblOpsegOcene;
    private javax.swing.JTable tblEksponati;
    private javax.swing.JTable tblOceneEksponata;
    private javax.swing.JFormattedTextField txtDatumPocetka;
    private javax.swing.JFormattedTextField txtDatumZavrsetka;
    private javax.swing.JTextField txtNazivIzlozbe;
    private javax.swing.JTextField txtOcenaEksponata;
    // End of variables declaration                   

    
}