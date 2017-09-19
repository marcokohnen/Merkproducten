package be.oak3.persistence;

import be.oak3.model.Parfum;
import be.oak3.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.*;


public class BestellingImpl implements Bestelling {

    private List<Product> bestelling;
    private static Logger logger = LogManager.getLogger();

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
            //System.out.println(product);
            logger.debug(product);
        }
    }

    @Override
    public void sorteerOpMerk() {
        Collections.sort(bestelling, Product.sorteerOpMerkNaam());
        for (Product product : bestelling) {
            //System.out.println(product);
            logger.debug(product);
        }
    }

    @Override
    public void sorteerOpVolume() {
        Collections.sort(bestelling, Comparator.comparing(Product::getVolume));
        //Collections.sort(bestelling, (vol1,vol2) -> vol1.getVolume() - vol2.getVolume());
        for (Product product : bestelling) {
            //System.out.println(product);
            logger.debug(product);
        }
    }


    @Override
    public void toonPerMerk(String merk) {
        bestelling.stream()
                  .filter(p -> p.getMerk().equals(merk))
//                .map(lijn -> lijn.toString())
//                .filter(lijn -> lijn.contains(merk))
                  //.forEach(p -> System.out.println(p));
                  .forEach(p -> logger.debug(p));
    }

    @Override
    public void toonParfums() {
        for (Product product : bestelling) {
            if (product instanceof Parfum) {
                //System.out.println((Parfum)product);
                logger.debug(product);
            }
        }
    }

    @Override
    public void toonGoedkopeProducten() {
        bestelling.stream()
                .filter(p -> p.getPrijs()<50)
                //.forEach(p -> System.out.println(p));
                .forEach(p -> logger.debug(p));
    }

    @Override
    public Product zoekDuursteProduct() {
            return Collections.max(bestelling, Comparator.comparing(Product::getPrijs));
//          return Collections.max(bestelling, (p1, p2) -> {
//                if (p1.getPrijs() < p2.getPrijs()) return -1;
//                if (p1.getPrijs() > p2.getPrijs()) return 1;
//                return 0;});
    }

    @Override
    public double totalePrijs() {
    return bestelling.stream()
//            .map(product -> product.getPrijs())
            .mapToDouble(product -> product.getPrijs())
            .sum();
    }
}
