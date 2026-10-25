public class SelfCollect extends Delivery {

    private String pickupLocation;

    public SelfCollect(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @Override
    public void deliver() {
        deliveryStatus = "READY FOR SELF COLLECTION";
        System.out.println("Order is ready for collection at: " + pickupLocation);
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
}