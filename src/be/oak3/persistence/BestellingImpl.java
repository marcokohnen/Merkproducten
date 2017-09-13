package be.oak3.persistence;

import be.oak3.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestellingImpl implements Bestelling {

    private List<Product> bestelling;

    public BestellingImpl() {
        this.bestelling = new ArrayList<>();
    }

    @Override
    public void voegProductToe(Product product) {
        bestelling.add(product);
    }

    @Override
    public void sorteer() {
        Collections.sort(bestelling);
        for (Product product : bestelling) {
            System.out.println(product);
        }
    }

    @Override
    public void sorteerOpMerk() {
        Collections.sort(bestelling, Product.sorteerOpMerkNaam());
        for (Product product : bestelling) {
            System.out.println(product);
        }
    }

    @Override
    public void sorteerOpVolume() {
        Collections.sort(bestelling, (vol1,vol2) -> vol1.getVolume() - vol2.getVolume());
        for (Product product : bestelling) {
            System.out.println(product);
        }
    }


    @Override
    public void toonPerMerk(String merk) {
        bestelling.stream()
                .map(lijn -> lijn.toString())
                .filter(lijn -> lijn.contains(merk))
                .forEach(lijn -> System.out.println(lijn));
    }

    @Override
    public void toonParfums() {

    }

    @Override
    public void toonGoedkopeProducten() {

    }

    @Override
    public Product zoekDuursteProduct() {

        return null;
    }

    @Override
    public void totalePrijs() {

    }
}
