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
    
    
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)) {
            contents.addProduct(product, quantity);
        }
    }
   
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
    
    public String toString() {
        return getLabel();
    }
    
    public double getWeight() {
        return contents.getTotalWeight();
    }
    
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) <= 20;
    }
    
    public double remainingCapacity() {
        return 20 - this.getWeight();
    }
    
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
    
    public boolean isHeavy(){
        return contents.getTotalWeight() > 15;
    }
}
