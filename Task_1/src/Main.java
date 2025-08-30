import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();
        int numberOfCustomers = 10;
        CustomerGenerator generator = new CustomerGenerator(servicePoint, numberOfCustomers);
        generator.generateCustomers();

        servicePoint.serve();
    }
}

// CustomerService class (previously Customer)
class CustomerService {
    private int id;
    private long timeArrival;
    private long timeStartService;
    private long timeEndService;
    private static int _id = 1;

    public CustomerService() {
        this.id = _id++;
    }

    public int getId() { return id; }

    public void setTimeArrival(long timeArrival) { this.timeArrival = timeArrival; }

    public void setTimeStartService(long timeStartService) { this.timeStartService = timeStartService; }

    public void setTimeEndService(long timeEndService) { this.timeEndService = timeEndService; }

    public double getResponseTime() {
        return (timeEndService - timeArrival) / 1000.0;
    }

    public double getServiceTime() {
        return (timeEndService - timeStartService) / 1000.0;
    }
}

// ServicePoint class
class ServicePoint {
    private LinkedList<CustomerService> queue;

    public ServicePoint() {
        queue = new LinkedList<>();
    }

    public void addToQueue(CustomerService customer) {
        queue.addFirst(customer); // add to front
        customer.setTimeArrival(System.currentTimeMillis());
    }

    public CustomerService removeFromQueue() {
        if (!queue.isEmpty()) {
            return queue.removeLast();
        }
        return null;
    }

    public void serve() {
        while (!queue.isEmpty()) {
            CustomerService customer = removeFromQueue();
            if (customer != null) {
                customer.setTimeStartService(System.currentTimeMillis());

                // Simulate service time (random 1 to 3 seconds)
                int sleeptime = 1000 + (int)(Math.random() * 2000);
                try {
                    Thread.sleep(sleeptime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                customer.setTimeEndService(System.currentTimeMillis());

                // Required outputs
                System.out.printf("Customer %d response time: %.3f s, service time: %.3f s%n",
                        customer.getId(), customer.getResponseTime(), customer.getServiceTime());
            }
        }
    }
}

// CustomerGenerator class
class CustomerGenerator {
    private ServicePoint servicePoint;
    private int numberOfCustomers;

    public CustomerGenerator(ServicePoint servicePoint, int numberOfCustomers) {
        this.servicePoint = servicePoint;
        this.numberOfCustomers = numberOfCustomers;
    }

    public void generateCustomers() {
        for (int i = 0; i < numberOfCustomers; i++) {
            CustomerService customer = new CustomerService();
            servicePoint.addToQueue(customer);
        }
    }
}
