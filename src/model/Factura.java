package model;
import java.time.LocalDate;

public class Factura {
    private String id;
    private Pacient pacient;
    private double sumaDePlata;
    private LocalDate dataEmiterii;
    private boolean estePlatita;


    public Factura(String id, Pacient pacient, double sumaDePlata, LocalDate dataEmiterii, boolean estePlatita) {
        this.id = id;
        this.pacient = pacient;
        this.sumaDePlata = sumaDePlata;
        this.dataEmiterii = dataEmiterii;
        this.estePlatita = estePlatita;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public double getSumaDePlata() {
        return sumaDePlata;
    }

    public void setSumaDePlata(double sumaDePlata) {
        this.sumaDePlata = sumaDePlata;
    }

    public LocalDate getDataEmiterii() {
        return dataEmiterii;
    }

    public void setDataEmiterii(LocalDate dataEmiterii) {
        this.dataEmiterii = dataEmiterii;
    }

    public boolean isEstePlatita() {
        return estePlatita;
    }

    public void setEstePlatita(boolean estePlatita) {
        this.estePlatita = estePlatita;
    }
    @Override
    public String toString() {
        return "Factura{" +
                "id='" + id + '\'' +
                ", pacient=" + pacient +
                ", sumaDePlata=" + sumaDePlata +
                ", dataEmiterii=" + dataEmiterii +
                ", estePlatita=" + estePlatita +
                '}';
    }
}
