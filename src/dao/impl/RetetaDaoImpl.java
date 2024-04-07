package dao.impl;

import dao.RetetaDao;
import model.Reteta;

import java.util.ArrayList;
import java.util.List;

public class RetetaDaoImpl implements RetetaDao {
    private final List<Reteta> retete = new ArrayList<>();

    @Override
    public void adaugaReteta(Reteta reteta) {
        retete.add(reteta);
    }

    @Override
    public Reteta obtineRetetaDupaId(String id) {
        return retete.stream()
                .filter(reteta -> reteta.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizeazaReteta(Reteta reteta) {
        int index = retete.indexOf(reteta);
        if (index != -1) {
            retete.set(index, reteta);
        }
    }

    @Override
    public void stergeRetetaDupaId(String id) {
        retete.removeIf(reteta -> reteta.getId().equals(id));
    }
}