package daoservices.impl;
import java.util.ArrayList;
import java.util.List;
import dao.FacturaDao;
import daoservices.FacturaRepoService;
import model.Factura;

public class FacturaRepoServiceImpl implements FacturaRepoService {
    private final FacturaDao facturaDao;
    private final List<Factura> facturi = new ArrayList<>();

    public FacturaRepoServiceImpl(FacturaDao facturaDao) {
        this.facturaDao = facturaDao;
    }

    @Override
    public void adaugaFactura(Factura factura) {
        facturaDao.adaugaFactura(factura);
        facturi.add(factura); // Adăugați această linie
    }

    @Override
    public Factura obtineFacturaDupaId(String id) {
        return facturaDao.obtineFacturaDupaId(id);
    }

    @Override
    public void actualizeazaFactura(Factura factura) {
        facturaDao.actualizeazaFactura(factura);
    }
    @Override
    public void stergeFacturaDupaId(String id) {
        facturaDao.stergeFacturaDupaId(id);
        facturi.removeIf(factura -> factura.getId().equals(id));
    }
    @Override
    public void afiseazaToateFacturile() {
        for (Factura factura : facturi) {
            System.out.println(factura);
        }
    }
}