package ServiceSystem;

class CustomerGenerator {
    private ServicePoint servicePoint;
    private int numberOfCustomers;

    public CustomerGenerator(ServicePoint servicePoint, int numberOfCustomers) {
        this.servicePoint = servicePoint;
        this.numberOfCustomers = numberOfCustomers;
    }

    public void generateCustomers() {
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer();
            servicePoint.addToQueue(customer);
        }
    }
}