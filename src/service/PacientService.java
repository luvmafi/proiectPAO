package service;

import model.Pacient;

import java.util.HashMap;
import java.util.Map;

public class PacientService {
    private final Map<String, Pacient> pacienti = new HashMap<>();

    public void adaugaPacient(Pacient pacient) {
        pacienti.put(pacient.getId(), pacient);
    }

    public Pacient gasestePacientDupaId(String id) {
        return pacienti.get(id);
    }

    public void actualizeazaPacient(Pacient pacient) {
        pacienti.put(pacient.getId(), pacient);
    }

    public void stergePacientDupaId(String id) {
        pacienti.remove(id);
    }

    public void afiseazaTotiPacientii() {
        pacienti.values().forEach(System.out::println);
    }
}
