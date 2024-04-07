package service;

import model.Medic;

import java.util.HashMap;
import java.util.Map;

public class MedicService {
    private final Map<String, Medic> medici = new HashMap<>();

    public void adaugaMedic(Medic medic) {
        medici.put(medic.getId(), medic);
    }

    public Medic gasesteMedicDupaId(String id) {
        return medici.get(id);
    }

    public void actualizeazaMedic(Medic medic) {
        medici.put(medic.getId(), medic);
    }

    public void stergeMedicDupaId(String id) {
        medici.remove(id);
    }

    public void afiseazaTotiMedicii() {
        medici.values().forEach(System.out::println);
    }
}
