package packer;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author 92019472
 */
public class PackerTest {
    //test data
    Address address1 = new Address("1 Cool St", "Suburb1", "City1", "POST1", new Coordinates(12, 42));
    Address address2 = new Address("2 Wow St", "Suburb2", "City2", "POST2", new Coordinates(12, 42));
    Customer customer1 = new Customer("First Customer", address1);
    Customer customer2 = new Customer("Second Customer", address2);
    Depot depot1 = new Depot("Depot 1", address1);
    Depot depot2 = new Depot("Depot 2", address2);
    
    Product a1 = new Product("Apple", 1, false, false);
    Product a2 = new Product("Apricot", 2, true, false);
    Product a3 = new Product("Avocado", 3, false, true);
    Product a4 = new Product("Akee", 4, true, true);
     
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer Class");
    }
    
    /**
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts() {
        Manifest manifest1 = new Manifest();
        manifest1.addProduct (a1, 20);
        List packer1 = Packer.packProducts(customer1, depot1, manifest1);
        assertEquals(customer1.getName()+"\n"+address1.toString()+"\nApple x 20\nHEAVY\n", packer1.get(0).toString());
        
        Manifest manifest2 = new Manifest();
        manifest2.addProduct(a1, 19);
        manifest2.addProduct(a2, 5);
        manifest2.addProduct(a3, 3);
        List packer2 = Packer.packProducts(customer1, depot1, manifest2);
        assertEquals(customer1.getName()+"\n"+address1.toString()+"\nApricot x 5\nAvocado x 3\nApple x 1\nFRAGILE\nHAZARDOUS\nHEAVY\n", packer2.get(0).toString());
        assertEquals(customer1.getName()+"\n"+address1.toString()+"\nApple x 18\nHEAVY\n", packer2.get(1).toString());
        

    }
    
}
