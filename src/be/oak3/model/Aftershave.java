package be.oak3.model;

public class Aftershave extends Product {

    private Soort soort;

    public Aftershave(int productNummer, int volume, String merk, String naam, double prijs, Soort soort) {
        super(productNummer, volume, merk, naam, prijs);
        this.soort=soort;
    }

    @Override
    public String toString() {
        return  super.toString() + " \t" + soort;
    }
}
