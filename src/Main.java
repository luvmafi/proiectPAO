import java.util.Scanner;
import model.Pacient;
import service.PacientService;
import service.MedicService;
import model.Medic;
import model.Factura;
import service.FacturaService;
import model.IstoricMedical;
import service.IstoricMedicalService;
import model.Reteta;
import service.RetetaService;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import dao.FacturaDao;
import dao.IstoricMedicalDao;
import dao.RetetaDao;
import dao.impl.FacturaDaoImpl;
import dao.impl.IstoricMedicalDaoImpl;
import dao.impl.RetetaDaoImpl;
import daoservices.RetetaRepoService;
import daoservices.FacturaRepoService;
import daoservices.IstoricMedicalRepoService;
import daoservices.impl.RetetaRepoServiceImpl;
import daoservices.impl.FacturaRepoServiceImpl;
import daoservices.impl.IstoricMedicalRepoServiceImpl;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PacientService pacientService = new PacientService();
        MedicService medicService = new MedicService();

        FacturaDao facturaDao = new FacturaDaoImpl();
        IstoricMedicalDao istoricMedicalDao = new IstoricMedicalDaoImpl();
        RetetaDao retetaDao = new RetetaDaoImpl();

        FacturaRepoService facturaRepoService = new FacturaRepoServiceImpl(facturaDao);
        IstoricMedicalRepoService istoricMedicalRepoService = new IstoricMedicalRepoServiceImpl(istoricMedicalDao);
        RetetaRepoService retetaRepoService = new RetetaRepoServiceImpl(retetaDao);

        FacturaService facturaService = new FacturaService(facturaRepoService);
        IstoricMedicalService istoricMedicalService = new IstoricMedicalService(istoricMedicalRepoService);
        RetetaService retetaService = new RetetaService(retetaRepoService);


        pacientService.adaugaPacient(new Pacient("pacient1", "Popescu", "Ion", "0000000000000", "Str. Libertatii nr. 10", "0722222222"));
        pacientService.adaugaPacient(new Pacient("pacient2", "Ionescu", "Maria", "0000000000001", "Str. Unirii nr. 4", "0733333333"));

        medicService.adaugaMedic(new Medic("medic1", "Dr. Ana Ionescu", "Cardiologie"));
        medicService.adaugaMedic(new Medic("medic2", "Dr. Mircea Popa", "Dermatologie"));
        int idFacturaIntrodusa=1;
        int idRetetaIntrodusa=1;
        while (true) {
            System.out.println("Alege o optiune:");
            System.out.println("1. Adauga factura");
            System.out.println("2. Adauga istoric medical");
            System.out.println("3. Adauga reteta");
            System.out.println("4. Afiseaza toate facturile");
            System.out.println("5. Afiseaza reteta dupa id-ul sau");
            System.out.println("6. Afiseaza istoricul medical al unui pacient");
            System.out.println("7. Sterge factura dupa id-ul sau");
            System.out.println("8. Sterge istoricul medical al unui pacient");
            System.out.println("9. Sterge reteta dupa id-ul sau");
            System.out.println("10. Iesire");

            int optiune = Integer.parseInt(scanner.nextLine());

            switch (optiune) {
                case 1:
                    System.out.println("ID Pacient:");
                    String idPacientFactura = scanner.nextLine();
                    System.out.println("Suma de plata:");
                    double sumaDePlata = Double.parseDouble(scanner.nextLine());
                    System.out.println("Factura este platita? (da/nu):");
                    String estePlatitaRaspuns = scanner.nextLine();
                    boolean estePlatita = estePlatitaRaspuns.equalsIgnoreCase("da");

                    Pacient pacientFactura = pacientService.gasestePacientDupaId(idPacientFactura);

                    if (pacientFactura != null) {

                        String idFacturaIntrodusaString = String.valueOf(idFacturaIntrodusa);
                        Factura facturaNoua = new Factura(idFacturaIntrodusaString, pacientFactura, sumaDePlata, LocalDate.now(), false);
                        facturaService.adaugaFactura(facturaNoua);
                        System.out.println("Factura adaugata cu succes!");
                        idFacturaIntrodusa++;
                    } else {
                        System.out.println("Pacientul nu a fost gasit.");
                    }
                    break;
                case 2:
                    System.out.println("ID Pacient pentru istoric:");
                    String idPacientIstoric = scanner.nextLine();
                    System.out.println("Introdu boli:");
                    String boala = scanner.nextLine();
                    List<String> boli = new ArrayList<>();
                    boli.add(boala);

                    Pacient pacientIstoric = pacientService.gasestePacientDupaId(idPacientIstoric);
                    if (pacientIstoric != null) {
                        IstoricMedical istoricNou = new IstoricMedical(idPacientIstoric);
                        istoricNou.setIstoricBoala(boli);
                        istoricMedicalService.adaugaIstoricMedical(istoricNou);
                        System.out.println("Istoric medical adaugat cu succes!");
                    } else {
                        System.out.println("Pacientul nu a fost gasit.");
                    }
                    break;
                case 3:
                    System.out.println("ID Medic:");
                    String idMedic = scanner.nextLine();
                    System.out.println("ID Pacient:");
                    String idPacientReteta = scanner.nextLine();
                    Map<String, Integer> medicamente = new HashMap<>();
                    String continua;
                    do {
                        System.out.println("Numele medicamentului:");
                        String medicament = scanner.nextLine();
                        System.out.println("Cantitate:");
                        int cantitate = Integer.parseInt(scanner.nextLine());
                        medicamente.put(medicament, cantitate);

                        System.out.println("Adaugi alt medicament? (da/nu):");
                        continua = scanner.nextLine();
                    } while (continua.equalsIgnoreCase("da"));

                    Medic medic = medicService.gasesteMedicDupaId(idMedic);
                    Pacient pacientReteta = pacientService.gasestePacientDupaId(idPacientReteta);

                    if (medic != null && pacientReteta != null) {
                        String idRetetaIntrodusaString = String.valueOf(idRetetaIntrodusa);
                        Reteta retetaNoua = new Reteta(idRetetaIntrodusaString, medic, pacientReteta, medicamente);
                        retetaService.adaugaReteta(retetaNoua);
                        System.out.println("Reteta adaugata cu succes!");
                        idRetetaIntrodusa++;
                    } else {
                        System.out.println("Medic sau pacient nu a fost gasit.");
                    }
                    break;
                case 4:
                    facturaService.afiseazaToateFacturile();
                    break;
                case 5:
                    System.out.println("ID Reteta pentru afisare retete:");
                    String idPacientRetetaAfisare = scanner.nextLine();
                    Reteta reteta = retetaService.obtineRetetaDupaId(idPacientRetetaAfisare);
                    if (reteta != null) {
                        System.out.println(reteta);
                    } else {
                        System.out.println("Nu exista reteta pentru pacientul cu ID-ul dat.");
                    }
                    break;
                case 6:
                    System.out.println("ID Pacient pentru istoric medical:");
                    String idPacientIstoricAfisare = scanner.nextLine();
                    IstoricMedical istoric = istoricMedicalService.obtineIstoricPacient(idPacientIstoricAfisare);
                    if (istoric != null) {
                        System.out.println(istoric);
                    } else {
                        System.out.println("Nu exista istoric medical pentru pacientul cu ID-ul dat.");
                    }
                    break;
                case 7:
                    System.out.println("Introdu ID-ul facturii pentru stergere:");
                    String idFactura = scanner.nextLine();
                    facturaService.stergeFacturaDupaId(idFactura);
                    System.out.println("Factura a fost stearsa.");
                    break;
                case 8:
                    System.out.println("Introdu ID-ul pacientului pentru a sterge istoricul medical:");
                    String idPacientIstoricStergere = scanner.nextLine();
                    istoricMedicalService.stergeIstoricMedical(idPacientIstoricStergere);
                    System.out.println("Istoricul medical al pacientului a fost sters.");
                    break;
                case 9:
                    System.out.println("Introdu ID-ul retetei pentru stergere:");
                    String idReteta = scanner.nextLine();
                    retetaService.stergeRetetaDupaId(idReteta);
                    System.out.println("Reteta a fost stearsa.");
                    break;
                case 10:
                    System.out.println("Iesire...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida. Te rog alege din nou.");
                    break;
            }
        }
    }
}