package rs.ac.bg.student.marko.MavenClientMuseum.form;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import rs.ac.bg.student.marko.MavenClientMuseum.controller.ClientController;
import rs.ac.bg.student.marko.MavenClientMuseum.form.eksponat.NewEksponatForm;
import rs.ac.bg.student.marko.MavenClientMuseum.form.eksponat.SearchEksponatForm;
import rs.ac.bg.student.marko.MavenClientMuseum.form.izlozba.NewIzlozbaForm;
import rs.ac.bg.student.marko.MavenClientMuseum.form.izlozba.SearchIzlozbaForm;
import rs.ac.bg.student.marko.MavenClientMuseum.form.kustos.NewKustosForm;
import rs.ac.bg.student.marko.MavenClientMuseum.form.kustos.SearchKustosForm;
import rs.ac.bg.student.marko.MavenClientMuseum.form.stalnaPostavka.NewStalnaPostavkaForm;
import rs.ac.bg.student.marko.MavenClientMuseum.form.stalnaPostavka.SearchStalnaPostavkaForm;
import rs.ac.bg.student.marko.MavenClientMuseum.help.Transakcija;
import rs.ac.bg.student.marko.MavenClientMuseum.session.Session;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Eksponat;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Izlozba;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.StalnaPostavka;

public class MainForm extends javax.swing.JFrame {
    
    private static final String BASE_URL = "http://api.currencylayer.com/";
    private static final String API_KEY = "8b2de8e77c0967d683bea6a478bf74e6";
    private static final String SOURCE = "USD";
    private static final String CURRENCIES = "EUR";


    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblTrenutnoUlogovani.setText(Session.getInstance().getTrenutnoUlogovani().toString());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        lblTrenutnoUlogovani = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtValuta1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtValuta2 = new javax.swing.JTextField();
        btnKonvertuj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblKurs = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEksponat = new javax.swing.JMenu();
        menuItemNoviEksponat = new javax.swing.JMenuItem();
        menuItemPretragaEksponata = new javax.swing.JMenuItem();
        menuIzlozba = new javax.swing.JMenu();
        menuItemNovaIzlozba = new javax.swing.JMenuItem();
        menuItemPretragaIzlozba = new javax.swing.JMenuItem();
        menuKustos = new javax.swing.JMenu();
        menuItemNoviKustos = new javax.swing.JMenuItem();
        menuItemPretragaKustosa = new javax.swing.JMenuItem();
        menuStalnaPostavka = new javax.swing.JMenu();
        menuItemNovaStalnaPostavka = new javax.swing.JMenuItem();
        menuItemPretragaStalnihPostavka = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ulogovani korisnik"));

        lblTrenutnoUlogovani.setForeground(new java.awt.Color(0, 0, 51));
        lblTrenutnoUlogovani.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(593, Short.MAX_VALUE)
                .addComponent(lblTrenutnoUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTrenutnoUlogovani)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Konvertor"));

        txtValuta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValuta1ActionPerformed(evt);
            }
        });

        jLabel1.setText("USD");

        jLabel2.setText("EUR");

        btnKonvertuj.setText("Konvertuj");
        btnKonvertuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonvertujActionPerformed(evt);
            }
        });

        jLabel3.setText("kurs:");

        lblKurs.setBackground(new java.awt.Color(102, 153, 255));
        lblKurs.setText("_________");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKonvertuj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtValuta2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtValuta1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtValuta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKonvertuj)
                    .addComponent(lblKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValuta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        menuEksponat.setText("Eksponat");

        menuItemNoviEksponat.setText("Novi eksponat");
        menuItemNoviEksponat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNoviEksponatActionPerformed(evt);
            }
        });
        menuEksponat.add(menuItemNoviEksponat);

        menuItemPretragaEksponata.setText("Pretraga eksponata");
        menuItemPretragaEksponata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretragaEksponataActionPerformed(evt);
            }
        });
        menuEksponat.add(menuItemPretragaEksponata);

        jMenuBar1.add(menuEksponat);

        menuIzlozba.setText("Izložba");

        menuItemNovaIzlozba.setText("Nova izložba");
        menuItemNovaIzlozba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNovaIzlozbaActionPerformed(evt);
            }
        });
        menuIzlozba.add(menuItemNovaIzlozba);

        menuItemPretragaIzlozba.setText("Pretraga izložbi");
        menuItemPretragaIzlozba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretragaIzlozbaActionPerformed(evt);
            }
        });
        menuIzlozba.add(menuItemPretragaIzlozba);

        jMenuBar1.add(menuIzlozba);

        menuKustos.setText("Kustos");

        menuItemNoviKustos.setText("Novi kustos");
        menuItemNoviKustos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNoviKustosActionPerformed(evt);
            }
        });
        menuKustos.add(menuItemNoviKustos);

        menuItemPretragaKustosa.setText("Pretraga kustosa");
        menuItemPretragaKustosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretragaKustosaActionPerformed(evt);
            }
        });
        menuKustos.add(menuItemPretragaKustosa);

        jMenuBar1.add(menuKustos);

        menuStalnaPostavka.setText("Stalna postavka");

        menuItemNovaStalnaPostavka.setText("Nova stalna postavka");
        menuItemNovaStalnaPostavka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNovaStalnaPostavkaActionPerformed(evt);
            }
        });
        menuStalnaPostavka.add(menuItemNovaStalnaPostavka);

        menuItemPretragaStalnihPostavka.setText("Pretraga stalnih postavki");
        menuItemPretragaStalnihPostavka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretragaStalnihPostavkaActionPerformed(evt);
            }
        });
        menuStalnaPostavka.add(menuItemPretragaStalnihPostavka);

        jMenuBar1.add(menuStalnaPostavka);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void menuItemNoviEksponatActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        new NewEksponatForm(this, rootPaneCheckingEnabled, new Eksponat(), FormEnum.NOVI).setVisible(true);
    }                                                    

    private void menuItemPretragaEksponataActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        new SearchEksponatForm(this, rootPaneCheckingEnabled).setVisible(true);
    }                                                         

    private void menuItemNovaIzlozbaActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        new NewIzlozbaForm(this, rootPaneCheckingEnabled, FormEnum.NOVI, new Izlozba()).setVisible(true);
    }                                                   

    private void menuItemNoviKustosActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        new NewKustosForm(this, rootPaneCheckingEnabled, FormEnum.NOVI, null).setVisible(true);
    }                                                  

    private void menuItemPretragaKustosaActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        new SearchKustosForm(this, rootPaneCheckingEnabled).setVisible(true);
    }                                                       

    private void menuItemPretragaIzlozbaActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        new SearchIzlozbaForm(this, rootPaneCheckingEnabled).setVisible(true);
    }                                                       

    private void menuItemNovaStalnaPostavkaActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        new NewStalnaPostavkaForm(this, rootPaneCheckingEnabled, new StalnaPostavka(), FormEnum.NOVI).setVisible(true);
    }                                                          

    private void menuItemPretragaStalnihPostavkaActionPerformed(java.awt.event.ActionEvent evt) {                                                                
        new SearchStalnaPostavkaForm(this, rootPaneCheckingEnabled).setVisible(true);
    }                                                               

    private void txtValuta1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btnKonvertujActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try(FileWriter file = new FileWriter("prva_transakcija.json")) {
            Gson gson = new Gson();
            
            URL url = new URL(BASE_URL + "/live?access_key=" + API_KEY +
                    "&source=" + SOURCE + "&currencies=" + CURRENCIES);
            
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            con.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            JsonObject rez = gson.fromJson(reader, JsonObject.class);
            
            System.out.println(rez);
            
            double kurs = rez.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble();
            lblKurs.setText(String.valueOf(kurs));
            
            double iznosValuteZaKonvertovanje = Double.parseDouble(txtValuta1.getText());
            
            double konvertovaniIznos = kurs*iznosValuteZaKonvertovanje;
            
            double iznos = Math.round(konvertovaniIznos*100.0)/100.0;
            
            txtValuta2.setText(String.valueOf(iznos));
            
            Transakcija t = new Transakcija();
            t.setIzvornaValuta(SOURCE);
            t.setKrajnjaValuta(CURRENCIES);
            t.setDatumTransakcije(new Date());
            t.setPocetniIznos(iznosValuteZaKonvertovanje);
            t.setKonvertovaniIznos(konvertovaniIznos);
            
            gson = new GsonBuilder().setPrettyPrinting().create();
			
            gson.toJson(t, file);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnKonvertuj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblKurs;
    private javax.swing.JLabel lblTrenutnoUlogovani;
    private javax.swing.JMenu menuEksponat;
    private javax.swing.JMenuItem menuItemNovaIzlozba;
    private javax.swing.JMenuItem menuItemNovaStalnaPostavka;
    private javax.swing.JMenuItem menuItemNoviEksponat;
    private javax.swing.JMenuItem menuItemNoviKustos;
    private javax.swing.JMenuItem menuItemPretragaEksponata;
    private javax.swing.JMenuItem menuItemPretragaIzlozba;
    private javax.swing.JMenuItem menuItemPretragaKustosa;
    private javax.swing.JMenuItem menuItemPretragaStalnihPostavka;
    private javax.swing.JMenu menuIzlozba;
    private javax.swing.JMenu menuKustos;
    private javax.swing.JMenu menuStalnaPostavka;
    private javax.swing.JTextField txtValuta1;
    private javax.swing.JTextField txtValuta2;
    // End of variables declaration                   
}

