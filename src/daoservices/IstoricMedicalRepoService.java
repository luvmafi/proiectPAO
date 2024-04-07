package daoservices;
import model.IstoricMedical;

public interface IstoricMedicalRepoService {
    void adaugaIstoric(IstoricMedical istoric);
    IstoricMedical obtineIstoricDupaIdPacient(String idPacient);
    void actualizeazaIstoric(IstoricMedical istoric);
    void stergeIstoricDupaIdPacient(String idPacient);
}
