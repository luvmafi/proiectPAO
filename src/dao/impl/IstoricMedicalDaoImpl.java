package dao.impl;

import dao.IstoricMedicalDao;
import model.IstoricMedical;

import java.util.ArrayList;
import java.util.List;

public class IstoricMedicalDaoImpl implements IstoricMedicalDao {
    private final List<IstoricMedical> istoricMedical = new ArrayList<>();

    @Override
    public void adaugaIstoric(IstoricMedical istoric) {
        istoricMedical.add(istoric);
    }

    @Override
    public IstoricMedical gasesteIstoricDupaIdPacient(String idPacient) {
        return istoricMedical.stream()
                .filter(istoric -> istoric.getIdPacient().equals(idPacient))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizeazaIstoricMedical(IstoricMedical istoric) {
        int index = istoricMedical.indexOf(istoric);
        if (index != -1) {
            istoricMedical.set(index, istoric);
        }
    }

    @Override
    public void stergeIstoricDupaIdPacient(String idPacient) {
        istoricMedical.removeIf(istoric -> istoric.getIdPacient().equals(idPacient));
    }

    @Override
    public IstoricMedical obtineIstoricDupaIdPacient(String idPacient) {
        return gasesteIstoricDupaIdPacient(idPacient);
    }

    @Override
    public void actualizeazaIstoric(IstoricMedical istoric) {
        actualizeazaIstoricMedical(istoric);
    }
}