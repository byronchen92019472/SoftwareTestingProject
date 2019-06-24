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

    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    public String getName() {
        return name;
    }

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

    public String toString() {
        return this.getName();
    }
}
