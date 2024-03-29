package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta
 */
public class Packer {
    
    /**
     * Pack the products into boxes
     * @return the packed products of boxes that have been added from the manifest
     */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c,d);
            }
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            if (prodToAdd == null) {
                packedBoxes.add(b);
                b = null;
            }
            else {
                b.addProduct(prodToAdd, 1);
                m.removeProduct(prodToAdd);
            }  
        }
        if (b != null) {
            packedBoxes.add(b);
        }
        return packedBoxes;
    }
    
}
