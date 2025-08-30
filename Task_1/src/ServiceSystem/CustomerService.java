package ServiceSystem;



public class CustomerService {

    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();
        int numberOfCustomers = 10; // Example: create 5 customers
        CustomerGenerator generator = new CustomerGenerator(servicePoint, numberOfCustomers);
        generator.generateCustomers();

        servicePoint.serve(); // Serve all customers in the queue
    }
}