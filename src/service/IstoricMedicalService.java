package service;
import model.IstoricMedical;
import daoservices.IstoricMedicalRepoService;


public class IstoricMedicalService {

    private final IstoricMedicalRepoService istoricMedicalRepoService;

    public IstoricMedicalService(IstoricMedicalRepoService istoricMedicalRepoService) {
        this.istoricMedicalRepoService = istoricMedicalRepoService;
    }

    public void adaugaIstoricMedical(IstoricMedical istoric) {
        istoricMedicalRepoService.adaugaIstoric(istoric);
    }

    public IstoricMedical obtineIstoricPacient(String idPacient) {
        return istoricMedicalRepoService.obtineIstoricDupaIdPacient(idPacient);
    }

    public void actualizeazaIstoricMedical(IstoricMedical istoric) {
        istoricMedicalRepoService.actualizeazaIstoric(istoric);
    }

    public void stergeIstoricMedical(String idPacient) {
        istoricMedicalRepoService.stergeIstoricDupaIdPacient(idPacient);
    }
}