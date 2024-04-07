package dao.impl;

import dao.FacturaDao;
import model.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaDaoImpl implements FacturaDao {
    private final List<Factura> facturi = new ArrayList<>();

    @Override
    public void adaugaFactura(Factura factura) {
        facturi.add(factura);
    }

    @Override
    public Factura gasesteFacturaDupaId(String id) {
        return facturi.stream()
                .filter(factura -> factura.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizeazaFactura(Factura factura) {
        int index = facturi.indexOf(factura);
        if (index != -1) {
            facturi.set(index, factura);
        }
    }

    @Override
    public void stergeFacturaDupaId(String id) {
        facturi.removeIf(factura -> factura.getId().equals(id));
    }

    @Override
    public Factura obtineFacturaDupaId(String id) {
        return gasesteFacturaDupaId(id);
    }
}