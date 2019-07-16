package packer;

/**
 *
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     * the name of the depot
     * @return the name of the depot
     */
    public String getName() {
        return name.toString();
    }
    
    /**
     * the coordinates of the depot
     * @return the coordinates of the depot
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    /**
     * the name of the depot
     * @return the name of the depot
     */
    public String toString() {
        return this.getName();
    }
    
}
