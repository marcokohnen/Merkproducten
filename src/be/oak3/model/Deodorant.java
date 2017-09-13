package be.oak3.model;

public class Deodorant extends  Product{

    private DeoType deoType;

    public Deodorant(int productNummer, int volume, String merk, String naam, double prijs, DeoType deoType) {
        super(productNummer, volume, merk, naam, prijs);
        this.deoType=deoType;
    }

    @Override
    public String toString() {
        return return  super.toString() + " \t" + deoType;
    }
}
