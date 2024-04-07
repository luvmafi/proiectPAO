package dao;
import model.Reteta;

public interface RetetaDao {
    void adaugaReteta(Reteta reteta);
    Reteta obtineRetetaDupaId(String id);
    void actualizeazaReteta(Reteta reteta);
    void stergeRetetaDupaId(String id);
}
