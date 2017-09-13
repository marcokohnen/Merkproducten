package be.oak3.model;

import java.util.Arrays;
import java.util.Comparator;

public abstract class Product implements Comparable<Product> {

    private int productNummer, volume;
    private String merk, naam;
    private double prijs;

    public Product(int productNummer, int volume, String merk, String naam, double prijs) {
        this.productNummer = productNummer;
        this.volume = volume;
        this.merk = merk;
        this.naam = naam;
        this.prijs = prijs;
    }

    public int getVolume() {
        return volume;
    }

    public String getMerk() {
        return merk;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getProductNummer() {
        return productNummer;
    }

    public String getProductCode() {
        return (getMerk().substring(0,3).toUpperCase()+ getNaam().substring(0,3).toUpperCase() + getPrijs()).replace(' ', '-');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productNummer != product.productNummer) return false;
        if (getVolume() != product.getVolume()) return false;
        if (Double.compare(product.getPrijs(), getPrijs()) != 0) return false;
        if (getMerk() != null ? !getMerk().equals(product.getMerk()) : product.getMerk() != null) return false;
        return getNaam() != null ? getNaam().equals(product.getNaam()) : product.getNaam() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productNummer;
        result = 31 * result + getVolume();
        result = 31 * result + (getMerk() != null ? getMerk().hashCode() : 0);
        result = 31 * result + (getNaam() != null ? getNaam().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrijs());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static Comparator<Product> sorteerOpMerkNaam() {
        return (p1, p2) -> p1.getMerk().compareTo(p2.getMerk());
    }

    @Override
    public int compareTo(Product o) {
        if (this.equals(o)) {
            return 0;
        }
        return this.getProductNummer()-o.getProductNummer();
    }

    @Override
    public String toString() {
        return "Merk:" + getMerk() + "\t" + "Naam: " + getNaam() + "Volume: " + getVolume() + "ml" +
                "\t" + "Prijs: " + getPrijs() + " Code: " + getProductCode();
    }
}
