package daoservices.impl;

import dao.IstoricMedicalDao;
import daoservices.IstoricMedicalRepoService;
import model.IstoricMedical;

public class IstoricMedicalRepoServiceImpl implements IstoricMedicalRepoService {
    private final IstoricMedicalDao istoricMedicalDao;

    public IstoricMedicalRepoServiceImpl(IstoricMedicalDao istoricMedicalDao) {
        this.istoricMedicalDao = istoricMedicalDao;
    }

    @Override
    public void adaugaIstoric(IstoricMedical istoric) {
        istoricMedicalDao.adaugaIstoric(istoric);
    }

    @Override
    public IstoricMedical obtineIstoricDupaIdPacient(String idPacient) {
        return istoricMedicalDao.obtineIstoricDupaIdPacient(idPacient);
    }

    @Override
    public void actualizeazaIstoric(IstoricMedical istoric) {
        istoricMedicalDao.actualizeazaIstoric(istoric);
    }

    @Override
    public void stergeIstoricDupaIdPacient(String idPacient) {
        istoricMedicalDao.stergeIstoricDupaIdPacient(idPacient);
    }
}