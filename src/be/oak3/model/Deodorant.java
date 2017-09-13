package be.oak3.model;

public class Deodorant extends  Product{

    public enum DeoType {VAPO, STICK}
    private DeoType deoType;

    public Deodorant(int productNummer, String merk, String naam, int volume, double prijs, DeoType deoType) {
        super(productNummer, merk, naam, volume, prijs);
        this.deoType=deoType;
    }

    @Override
    public String toString() {
        return super.toString() + " \t" + deoType.name();
    }
}
