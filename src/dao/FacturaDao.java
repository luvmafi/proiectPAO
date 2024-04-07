package dao;
import model.Factura;

public interface FacturaDao {
    void adaugaFactura(Factura factura);
    Factura gasesteFacturaDupaId(String id);
    void actualizeazaFactura(Factura factura);
    void stergeFacturaDupaId(String id);
    Factura obtineFacturaDupaId(String id);
}
