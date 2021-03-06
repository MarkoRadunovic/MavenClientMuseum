package rs.ac.bg.student.marko.MavenClientMuseum.form.stalnaPostavka;

import java.awt.Frame;
import java.net.SocketException;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.bg.student.marko.MavenClientMuseum.controller.ClientController;
import rs.ac.bg.student.marko.MavenClientMuseum.form.FormEnum;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.StalnaPostavka;

public class SearchStalnaPostavkaForm extends javax.swing.JDialog {

    private TableModelStalnaPostavka tableModel;

    public SearchStalnaPostavkaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTableModel();

    }

    private void setTableModel() {
        try {
            List<StalnaPostavka> list = ClientController.getInstance().getAllStalnePostavke();
            tableModel = new TableModelStalnaPostavka(list);
            tblStalnaPostavka.setModel(tableModel);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStalnaPostavka = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        btnIzmeniStalnuPostavku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblStalnaPostavka.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStalnaPostavka);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Pretraga:");

        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        btnIzmeniStalnuPostavku.setText("Izmeni stalnu postavku");
        btnIzmeniStalnuPostavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniStalnuPostavkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzmeniStalnuPostavku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(jLabel1)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzmeniStalnuPostavku))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
    }                                         

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {                                        
        try {
            String param = txtPretraga.getText();
            List<StalnaPostavka> list;
            if (param.equals("")) {
                list = ClientController.getInstance().getAllStalnePostavke();
            } else {
                list = ClientController.getInstance().searchStalnePostavke(param);
            }
            tableModel = new TableModelStalnaPostavka(list);
            tblStalnaPostavka.setModel(tableModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof SocketException) {
                JOptionPane.showMessageDialog(this, "Server vam je prekinuo komunikaciju! Gasenje programa...", "Greska", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }                                       

    private void btnIzmeniStalnuPostavkuActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        int row = tblStalnaPostavka.getSelectedRow();
        if (row > -1) {
            StalnaPostavka stalnaPostavka = tableModel.getSelected(row);
            new NewStalnaPostavkaForm((Frame) getParent(), rootPaneCheckingEnabled, stalnaPostavka, FormEnum.IZMENA).setVisible(true);
            this.dispose();
        }
    }                                                       


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnIzmeniStalnuPostavku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStalnaPostavka;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration                   
}
