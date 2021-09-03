package rs.ac.bg.student.marko.MavenClientMuseum.controller;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import rs.ac.bg.student.marko.MavenClientMuseum.session.Session;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Eksponat;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Izlozba;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Kustos;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.OcenaEksponata;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.Specijalnost;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.StalnaPostavka;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.TipEksponata;
import rs.ac.bg.student.marko.MavenCommonMuseum.domain.User;
import rs.ac.bg.student.marko.MavenCommonMuseum.transfer.Operation;
import rs.ac.bg.student.marko.MavenCommonMuseum.transfer.Request;
import rs.ac.bg.student.marko.MavenCommonMuseum.transfer.Response;

public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public User login(User user) throws Exception {
        return (User) sendRequest(user, Operation.LOGIN);
    }

    public List<Eksponat> getAllEksponati() throws Exception {
        return (List<Eksponat>) sendRequest(null, Operation.GET_ALL_EKSPONATI);
    }

    public List<Izlozba> getAllIzlozbe() throws Exception {
        return (List<Izlozba>) sendRequest(null, Operation.GET_ALL_IZLOZBE);
    }

    public List<Kustos> getAllKustosi() throws Exception {
        return (List<Kustos>) sendRequest(null, Operation.GET_ALL_KUSTOSI);
    }

    public List<OcenaEksponata> getAllOcene() throws Exception {
        return (List<OcenaEksponata>) sendRequest(null, Operation.GET_ALL_OCENE);
    }

    public List<Specijalnost> getAllSpecijalnosti() throws Exception {
        return (List<Specijalnost>) sendRequest(null, Operation.GET_ALL_SPECIJALNOSTI);
    }

    public List<StalnaPostavka> getAllStalnePostavke() throws Exception {
        return (List<StalnaPostavka>) sendRequest(null, Operation.GET_ALL_STALNE_POSTAVKE);
    }

    public List<TipEksponata> getAllTipoviEksponata() throws Exception {
        return (List<TipEksponata>) sendRequest(null, Operation.GET_ALL_TIPOVI_EKSPONATA);
    }

    public void saveEksponat(Eksponat eksponat) throws Exception {
        sendRequest(eksponat, Operation.SAVE_EKSPONAT);
    }

    public void saveIzlozba(Izlozba izlozba) throws Exception {
        sendRequest(izlozba, Operation.SAVE_IZLOZBA);
    }

    public void saveKustos(Kustos kustos) throws Exception {
        sendRequest(kustos, Operation.SAVE_KUSTOS);
    }

    public void saveStalnaPostavka(StalnaPostavka stalnaPostavka) throws Exception {
        sendRequest(stalnaPostavka, Operation.SAVE_STALNA_POSTAVKA);
    }

    public List<Eksponat> searchEksponati(String param) throws Exception {
        return (List<Eksponat>) sendRequest(param, Operation.SEARCH_EKSPONATI);
    }

    public List<Izlozba> searchIzlozbe(String param) throws Exception {
        return (List<Izlozba>) sendRequest(param, Operation.SEARCH_IZLOZBE);
    }

    public List<Kustos> searchKustosi(String param) throws Exception {
        return (List<Kustos>) sendRequest(param, Operation.SEARCH_KUSTOSI);
    }

    public List<StalnaPostavka> searchStalnePostavke(String param) throws Exception {
        return (List<StalnaPostavka>) sendRequest(param, Operation.SEARCH_STALNE_POSTAVKE);
    }

    public void editEksponat(Eksponat eksponat) throws Exception {
        sendRequest(eksponat, Operation.EDIT_EKSPONAT);
    }

    public void editIzlozba(Izlozba izlozba) throws Exception {
        sendRequest(izlozba, Operation.EDIT_IZLOZBA);
    }

    public void editKustos(Kustos kustos) throws Exception {
        sendRequest(kustos, Operation.EDIT_KUSTOS);
    }

    public void editStalnaPostavka(StalnaPostavka stalnaPostavka) throws Exception {
        sendRequest(stalnaPostavka, Operation.EDIT_STALNA_POSTAVKA);
    }

    private Object sendRequest(Object podatak, int operacija) throws Exception {
        Request zahtev = new Request(podatak, operacija);
        ObjectOutputStream oos = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        oos.writeObject(zahtev);
        ObjectInputStream ois = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response odgovor = (Response) ois.readObject();
        if (odgovor.getGreska() != null) {
            throw odgovor.getGreska();
        }
        return odgovor.getPodaci();
    }

}
