package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I.M.Bad
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;
    
    /**
     * The customer
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * adds address to the customer
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
     * the name of the customer
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }
    
    /**
     * gets the closest address to the depot from the customers addresses
     * @return the closest address to the depot
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = addresses.get(0).getCoordinates().companyDistanceTo(d.getCoordinates());
        Address bestAddress = addresses.get(0);
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestAddress = a;
                bestDistance = distance;
            }
        }
        return bestAddress;
    }
    
    /**
     * the name of the customer
     * @return the name 
     */
    public String toString() {
        return this.getName();
    }
}
