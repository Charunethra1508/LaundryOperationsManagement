public class LaundryOrder implements Trackable, Cancellable {

    private int orderID;
    private Customer customer;
    private int itemCount;
    private double[] itemWeights;
    private String serviceType;
    private String status;
    private double totalBill;

    // Constructor
    public LaundryOrder(int orderID, Customer customer, int itemCount,
                         double[] itemWeights, String serviceType) {

        this.orderID = orderID;
        this.customer = customer;
        this.itemCount = itemCount;
        this.itemWeights = itemWeights;
        this.serviceType = serviceType;
        this.status = "BOOKED";
        this.totalBill = calculateBill();
    }

    // Calculate bill based on weight
    public double calculateBill() {

        double totalWeight = 0;

        for (double weight : itemWeights) {
            totalWeight += weight;
        }

        double pricePerKg;

        if (serviceType.equalsIgnoreCase("Normal")) {
            pricePerKg = 60;
        } else if (serviceType.equalsIgnoreCase("Dry Clean")) {
            pricePerKg = 100;
        } else {
            pricePerKg = 150;
        }

        return totalWeight * pricePerKg;
    }

    // Turnaround time
    public int calculateTurnaroundTime() {
        return 2;
    }

    // Service details
    public void getServiceDetails() {
        System.out.println("Service       : " + serviceType);
        System.out.println("Turnaround    : " + calculateTurnaroundTime() + " days");
    }

    // Track order
    @Override
    public void trackOrder() {
        System.out.println("Order ID      : " + orderID);
        System.out.println("Current Status: " + status);
    }

    // Cancel order
    @Override
    public void cancelOrder() {

        if (status.equals("BOOKED")) {
            status = "CANCELLED";
            System.out.println("Order " + orderID + " has been cancelled.");
        } else {
            System.out.println("Order cannot be cancelled at this stage.");
        }
    }

    // Display order details
    public void displayOrderDetails() {

        System.out.println("\n========== ORDER DETAILS ==========");
        System.out.println("Order ID       : " + orderID);
        System.out.println("Customer       : " + customer.getName());
        System.out.println("Address        : " + customer.getAddress());
        System.out.println("Item Count     : " + itemCount);
        System.out.println("Service Type   : " + serviceType);
        System.out.println("Order Status   : " + status);
        System.out.println("Total Bill     : ₹" + totalBill);
        System.out.println("===================================");
    }

    // Getters and setters

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double[] getItemWeights() {
        return itemWeights;
    }

    public void setItemWeights(double[] itemWeights) {
        this.itemWeights = itemWeights;
        this.totalBill = calculateBill();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
        this.totalBill = calculateBill();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalBill() {
        return totalBill;
    }
}