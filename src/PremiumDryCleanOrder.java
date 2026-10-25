public class PremiumDryCleanOrder extends DryCleanOrder {

    // Constructor
    public PremiumDryCleanOrder(int orderID, Customer customer, int itemCount,
                                double[] itemWeights) {

        super(orderID, customer, itemCount, itemWeights);

        setServiceType("Premium Dry Clean");
    }

    // Method overriding
    @Override
    public int calculateTurnaroundTime() {
        return 1;
    }

    // Method overriding
    @Override
    public void getServiceDetails() {
        System.out.println("Service       : Premium Dry Cleaning");
        System.out.println("Turnaround    : 1 day");
    }
}