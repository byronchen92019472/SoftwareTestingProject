package packer;

/**
 *
 * @author I.M.Bad
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;
    
    /**
     * Description of the product
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * The weight of the product
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * The Name of the product
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Check if the product is hazardous
     * @return the hazardous
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * Check if the product is fragile
     * @return the fragile
     */
    public boolean isFragile() {
        return fragile;
    }
    /**
     * The name of the product
     * @return the name of the product
     */
    public String toString() {
        return this.getName();
    }
    
    /**
     * Check if the product is equal
     * @return if the product equals the object
     */
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}
