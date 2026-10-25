public class Customer {

    private String name;
    private String address;

    // Default constructor
    public Customer() {
        name = "Unknown";
        address = "Not Provided";
    }

    // Constructor with name
    public Customer(String name) {
        this.name = name;
        this.address = "Not Provided";
    }

    // Constructor with name and address
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }
}