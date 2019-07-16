package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 */
public class Manifest {
    
    // This tracks the quantity of each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    
    /**
     * Adds the products into the manifest
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            int q = quantities.get(p) + quantity;
            quantities.put(p, q);
            
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    /**
     * Removes the product from the manifest
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p, quantities.get(p) - 1);
        }
        if (quantities.get(p) == null) {
            quantities.remove(p);
        }
        if (quantities.get(p) == 0) {
            byWeight.remove(p);
        }
    }
    
    /**
     * Get the total weight of the products in the manifest
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += quantities.get(p) * p.getWeight();
        }
        return weight;
    }
    
    /**
     * Get the heaviest product under a certain weight
     * @return the heaviest product under a certain weight
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Check if the manifest is empty
     * @return if the products list is empty
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    /**
     * Check if the manifest contains the product
     * @return if the manifest contains the product
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    /**
     * The list of products
     * @return the list of products in the manifest
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }
    
    /**
     * Check if any fragile items in the list
     * @return if there are any fragile items in the list
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if any hazardous items in the list
     * @return if there are any hazardous items in the list
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
   
}
    

