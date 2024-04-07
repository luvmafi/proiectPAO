package dao;
import model.IstoricMedical;

public interface IstoricMedicalDao {
    void adaugaIstoric(IstoricMedical istoricMedical);
    IstoricMedical gasesteIstoricDupaIdPacient(String idPacient);
    void actualizeazaIstoricMedical(IstoricMedical istoricMedical);
    void stergeIstoricDupaIdPacient(String idPacient);
    public IstoricMedical obtineIstoricDupaIdPacient(String idPacient);
    public void actualizeazaIstoric(IstoricMedical istoric);
}
