package ServiceSystemAverage;

import java.util.Random;

public class CustomerService {
    public static void main(String[] args) {
        int numberOfCustomers = 10;

        // Real-time simulation (sleeps 1–3s per customer)
        ServicePoint servicePoint = new ServicePoint(new Random(), true);
        CustomerGenerator generator = new CustomerGenerator(servicePoint, numberOfCustomers);
        generator.generateCustomers();

        servicePoint.serveAllAndReturnAverageServiceSeconds();
    }
}

