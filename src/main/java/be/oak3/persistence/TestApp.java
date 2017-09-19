package be.oak3.persistence;

import be.oak3.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;
import com.google.common.collect.Lists.*;

import static com.google.common.collect.Lists.newArrayList;


public class TestApp {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.printf("Oplossing van %s %s\n", "Kenneth Van Gijsel ",
                "Java Instructeur");

        Bestelling bestelling = new BestellingImpl();
        List<Product> lijst;
        lijst = Data.getData();
        for (Product artikel : lijst) {
            bestelling.voegProductToe(artikel);
        }

        System.out.println("Lijst gesorteerd op natuurlijke volgorde: ");
        bestelling.sorteer();

        System.out.println("\nLijst gesorteerd op merknaam: ");
        bestelling.sorteerOpMerk();

        System.out.println("\nLijst gesorteerd op volume: ");
        bestelling.sorteerOpVolume();

          System.out.println("\nVan het merk Georgio Armani:");
          //bestelling.toonPerMerk("Georgio Armani");
          bestelling.lijstVanBepaaldMerk("Georgio Armani").stream().forEach(p -> logger.debug(p));

          System.out.println("\nAlle Parfums:");
          //bestelling.toonParfums();
          bestelling.lijstVanParfums().stream().forEach(p -> logger.debug(p));

          System.out.println("\nAlle producten onder €50; ");
          //bestelling.toonGoedkopeProducten();
          bestelling.lijstVanGoedkopeProducten().stream().forEach(p -> logger.debug(p));

          Product product = bestelling.zoekDuursteProduct();
          System.out.println();
          //System.out.println("\nDuurste product:\n" + product);
         logger.debug("Duurste product:" + product);

          //System.out.printf("\nTotale prijs:  €%.2f", bestelling.totalePrijs());
         logger.debug("Totale prijs:  €%.2f", bestelling.totalePrijs());

    }
}
