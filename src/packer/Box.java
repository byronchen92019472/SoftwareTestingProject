package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
     * Add a product to the box
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)) {
            contents.addProduct(product, quantity);
        }
    }
    
    /**
     * The formatted label of the box
     * @return the formatted label for the box
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        if (this.isHazardous()) {
            label.append("HAZARDOUS\n");
        }
        if (this.isHeavy()){
            label.append("HEAVY\n");
        }
        return label.toString();
    }
    
    /**
     * the label of the box
     * @return the label
     */
    public String toString() {
        return getLabel();
    }
    
    /**
     * the weight of the box
     * @return the total weight of the box
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }
    
    /**
     * check if the products can fit in the box
     * @return if a products weight can fit into the box
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) <= 20;
    }
    
    /**
     * the remaining capacity of the box
     * @return the remaining capacity of the box
     */
    public double remainingCapacity() {
        return 20 - this.getWeight();
    }
    
    /**
     * check if the box is fragile
     * @return if any fragile items in the box
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     * check if the box is hazardous
     * @return if any hazardous items in the box
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
    
    /**
     * check if the box is heavy
     * @return if the box weighs over 15 
     */
    public boolean isHeavy(){
        return contents.getTotalWeight() > 15;
    }
}
