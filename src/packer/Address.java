package packer;

/**
 *
 * @author I.M.Bad
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;
    
    /**
     * The address of the customer 
     */
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }
    /**
     * Returns the address formatted
     */
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * The coordinates of the address
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
}
