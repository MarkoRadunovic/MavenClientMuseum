package rs.ac.bg.student.marko.MavenClientMuseum.session;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

import rs.ac.bg.student.marko.MavenCommonMuseum.domain.User;

public class Session {

    private static Session instance;
    private Socket socket;
    private User trenutnoUlogovani;

    public Session() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("../MavenServerMuseum/konfiguracija.properties"));
            Properties prop = new Properties();
            prop.load(fileInputStream);
            String serverPortText = prop.getProperty("serverPort");
            int port = Integer.parseInt(serverPortText);
            socket = new Socket("localhost", port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public User getTrenutnoUlogovani() {
        return trenutnoUlogovani;
    }

    public void setTrenutnoUlogovani(User trenutnoUlogovani) {
        this.trenutnoUlogovani = trenutnoUlogovani;
    }

}


