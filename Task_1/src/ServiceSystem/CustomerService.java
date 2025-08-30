package ServiceSystem;

import java.util.LinkedList;

public class CustomerService {

    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();
        int numberOfCustomers = 10;
        CustomerGenerator generator = new CustomerGenerator(servicePoint, numberOfCustomers);
        generator.generateCustomers();

        servicePoint.serve();
    }
}
