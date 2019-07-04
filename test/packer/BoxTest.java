package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author 92019472
 */
public class BoxTest {
    
    // Test Data
    Coordinates testCoordinates = new Coordinates(3,4);
    Address testAddress = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates);
    Depot testDepot = new Depot("Test Depot", testAddress);
    Customer testCustomer = new Customer("Customer", testAddress);
    
    Product a1 = new Product("Apple", 1, false, false);
    Product a2 = new Product("Apricot", 2, false, false);
    Product a3 = new Product("Avocado", 3, false, false);
    Product a4 = new Product("Akee", 4, false, false);
    
    Product b1 = new Product("Banana", 1, false, false);
    Product b2 = new Product("Blackcurrant", 2, true, true);
    Product b3 = new Product("Blueberry", 3, false, true);
    Product b4 = new Product("Boysenberry", 4, true, false);
    
    Product c1 = new Product("Carrot", 1, false, false);
    Product c2 = new Product("Currant", 2, true, true);
    Product c3 = new Product("Cherry", 3, false, true);
    Product c4 = new Product("Coconut", 4, true, false);
    
    Box testBox1 = new Box(testCustomer, testDepot);
    Box testBox2 = new Box(testCustomer, testDepot);
    Box testBox3 = new Box(testCustomer, testDepot);
    

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Customer class...");
        
        
    }
    
    /**
     * Test of addProduct method, of class Box.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        testBox1.addProduct(a1, 5);
        testBox1.addProduct(a2, 2);
        testBox1.addProduct(a3, 1);
        testBox1.addProduct(a4, 2);
        testBox3.addProduct(c1, 0);
        testBox3.addProduct(c1, 1);
        assertEquals("Customer\n1 First St\nAplace\nCitadel City\nA111\nCarrot x 1\n", testBox3.toString());
        
    }
    /**
     * Test of getLabel method, of class Box.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        testBox2.addProduct(b2, 1);
        assertEquals("Customer\n1 First St\nAplace\nCitadel City\nA111\nBlackcurrant x 1\nFRAGILE\nHAZARDOUS\n", testBox2.getLabel());
        Box testBox8 = new Box(testCustomer, testDepot);
        testBox8.addProduct(b1, 1);
        assertEquals("Customer\n1 First St\nAplace\nCitadel City\nA111\nBanana x 1\n", testBox8.getLabel());
        Box testBox9 = new Box(testCustomer, testDepot);
        testBox9.addProduct(b3, 1);
        assertEquals("Customer\n1 First St\nAplace\nCitadel City\nA111\nBlueberry x 1\nFRAGILE\n", testBox9.getLabel());
        Box testBox10 = new Box(testCustomer, testDepot);
        testBox10.addProduct(b4, 1);
        assertEquals("Customer\n1 First St\nAplace\nCitadel City\nA111\nBoysenberry x 1\nHAZARDOUS\n", testBox10.getLabel());
    }
    /**
     * Test of getWeight method, of class Box.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Box testBox4 = new Box(testCustomer, testDepot);
        testBox4.addProduct(a1, 5);
        testBox4.addProduct(a2, 2);
        testBox4.addProduct(a3, 1);
        testBox4.addProduct(a4, 2);
        
        Box testBox5 = new Box(testCustomer, testDepot);
        testBox4.addProduct(a1, 0);
        testBox4.addProduct(a2, 0);
        testBox4.addProduct(a3, 0);
        testBox4.addProduct(a4, 0);
        
        assertEquals(20.0, testBox4.getWeight(), 0);
        assertEquals(0.0, testBox5.getWeight(), 0);
    }
    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit() {
        System.out.println("canFit");
        Box testBox6 = new Box(testCustomer, testDepot);
        assertEquals(true, testBox6.canFit(a1, 1));
        assertEquals(true, testBox6.canFit(a1, 20));
        assertEquals(false, testBox6.canFit(a1, 21));
        assertEquals(true, testBox6.canFit(a1, 19));
        assertEquals(false, testBox6.canFit(a1, 200));
    }
    /**
     * Test of remainingCapacity method, of class Box.
     */
    @Test
    public void testRemainingCapacity() {
        System.out.println("remainingCapacity");
        Box testBox7 = new Box(testCustomer, testDepot);
        testBox7.addProduct(a1, 5);
        assertEquals(15.0, testBox7.remainingCapacity(), 0);
        testBox7.addProduct(a1, 5);
        assertEquals(10.0, testBox7.remainingCapacity(), 0);
        testBox7.addProduct(a1, 5);
        assertEquals(5.0, testBox7.remainingCapacity(), 0);
        testBox7.addProduct(a1, 5);
        assertEquals(0.0, testBox7.remainingCapacity(), 0);
  
    }
    
}
