public class DryCleanOrder extends LaundryOrder {

    // Constructor
    public DryCleanOrder(int orderID, Customer customer, int itemCount,
                         double[] itemWeights) {

        super(orderID, customer, itemCount, itemWeights, "Dry Clean");
    }

    // Method overriding
    @Override
    public int calculateTurnaroundTime() {
        return 3;
    }

    // Method overriding
    @Override
    public void getServiceDetails() {
        System.out.println("Service       : Dry Cleaning");
        System.out.println("Turnaround    : 3 days");
    }
}