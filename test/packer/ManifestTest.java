package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author 92019472
 */
public class ManifestTest {
    
    //test data
    Product a1 = new Product("Apple", 1, false, false);
    Product a2 = new Product("Apricot", 2, true, false);
    Product a3 = new Product("Avocado", 3, false, true);
    Product a4 = new Product("Akee", 4, true, true);
     
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest Class...");
    }
    
    /**
     * Test of addProduct method, of class Manifest.
     */
    @Test
    public void testAddProduct() {
        Manifest manifest = new Manifest();
        System.out.println("addProduct");
        manifest.addProduct(a1, 5);
        assertEquals("Apple x 5", manifest.toString());
        manifest.addProduct(a1, 10);
        assertEquals("Apple x 15", manifest.toString());
        Manifest manifest2 = new Manifest();
        manifest2.addProduct(a2, 20);
        assertEquals("Apricot x 20", manifest2.toString());
        manifest2.addProduct(a2, 25);
        assertEquals("Apricot x 45", manifest2.toString());
    }
    
    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testRemoveProduct() {
        System.out.println("removeProduct");
        Manifest manifest = new Manifest();
        manifest.addProduct(a1, 5);
        
        manifest.removeProduct(a1);
        assertEquals("Apple x 4", manifest.toString());
        manifest.removeProduct(a1);
        assertEquals("Apple x 3", manifest.toString());
        manifest.removeProduct(a1);
        assertEquals("Apple x 2", manifest.toString());
        manifest.removeProduct(a1);
        assertEquals("Apple x 1", manifest.toString());
        manifest.removeProduct(a1);
        assertEquals("Apple x 0", manifest.toString());
    }
    
    /**
     * Test of getTotalWeight method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        Manifest manifest = new Manifest();
        manifest.addProduct(a1, 10);
        assertEquals(10, manifest.getTotalWeight(), 0);
        manifest.addProduct(a1, 10);
        assertEquals(20, manifest.getTotalWeight(), 0);
        manifest.addProduct(a2, 10);
        assertEquals(40, manifest.getTotalWeight(), 0);
        manifest.addProduct(a2, 10);
        assertEquals(60, manifest.getTotalWeight(), 0);
        manifest.addProduct(a3, 10);
        assertEquals(90, manifest.getTotalWeight(), 0);
    }
    
    /**
     * Test of toString getHeaviestUnder, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("getHeaviestUnder");
        Manifest manifest = new Manifest();
        manifest.addProduct(a1, 1);
        assertEquals(a1, manifest.getHeaviestUnder(20));
        manifest.addProduct(a2, 1);
        assertEquals(a2, manifest.getHeaviestUnder(20));
        manifest.addProduct(a3, 1);
        assertEquals(a3, manifest.getHeaviestUnder(20));
        manifest.addProduct(a4, 1);
        assertEquals(a4, manifest.getHeaviestUnder(20));
    }
    
    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Manifest manifest = new Manifest();
        assertEquals(true, manifest.isEmpty());
        manifest.addProduct(a1, 1);
        assertEquals(false, manifest.isEmpty());
        manifest.removeProduct(a1);
        assertEquals(true, manifest.isEmpty());
    }
    
    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct() {
        System.out.println("containProduct");
        Manifest manifest = new Manifest();
        assertEquals(false, manifest.containsProduct(a1));
        assertEquals(false, manifest.containsProduct(a2));
        manifest.addProduct(a1, 1);
        assertEquals(true, manifest.containsProduct(a1));
        manifest.addProduct(a2, 0);
        assertEquals(false, manifest.containsProduct(a2));
        manifest.removeProduct(a1);
        assertEquals(false, manifest.containsProduct(a1));
    }
    
    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        System.out.println("hasFragileItems");
        Manifest manifest = new Manifest();
        assertEquals(false, manifest.hasFragileItems());
        manifest.addProduct(a1, 1);
        assertEquals(false, manifest.hasFragileItems());
        manifest.addProduct(a3, 1);
        assertEquals(true, manifest.hasFragileItems());
        manifest.addProduct(a4, 1);
        assertEquals(true, manifest.hasFragileItems());
    }
    
    /**
     * Test of hasHazardousItems method, of class Manifest.
     */
    @Test
    public void testHasHazardousItems() {
        System.out.println("hasHazardousItems");
        Manifest manifest = new Manifest();
        assertEquals(false, manifest.hasHazardousItems());
        manifest.addProduct(a1, 1);
        assertEquals(false, manifest.hasHazardousItems());
        manifest.addProduct(a2, 1);
        assertEquals(true, manifest.hasHazardousItems());
        manifest.addProduct(a4, 1);
        assertEquals(true, manifest.hasHazardousItems());
    }
    
}
