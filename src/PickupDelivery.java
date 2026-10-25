public class PickupDelivery extends Delivery {

    private String deliveryAddress;

    public PickupDelivery(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public void deliver() {
        deliveryStatus = "OUT FOR DELIVERY";
        System.out.println("Order is out for delivery to: " + deliveryAddress);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}