public abstract class Delivery {

    protected String deliveryStatus;

    public Delivery() {
        deliveryStatus = "NOT ASSIGNED";
    }

    // Abstract method
    public abstract void deliver();

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}