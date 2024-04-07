package daoservices.impl;

import dao.RetetaDao;
import daoservices.RetetaRepoService;
import model.Reteta;

public class RetetaRepoServiceImpl implements RetetaRepoService {
    private final RetetaDao retetaDao;

    public RetetaRepoServiceImpl(RetetaDao retetaDao) {
        this.retetaDao = retetaDao;
    }

    @Override
    public void adaugaReteta(Reteta reteta) {
        retetaDao.adaugaReteta(reteta);
    }

    @Override
    public Reteta obtineRetetaDupaId(String id) {
        return retetaDao.obtineRetetaDupaId(id);
    }

    @Override
    public void actualizeazaReteta(Reteta reteta) {
        retetaDao.actualizeazaReteta(reteta);
    }

    @Override
    public void stergeRetetaDupaId(String id) {
        retetaDao.stergeRetetaDupaId(id);
    }
}