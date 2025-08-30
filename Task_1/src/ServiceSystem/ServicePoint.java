package ServiceSystem;

import java.util.LinkedList;

class ServicePoint {
    private LinkedList<Customer> queue;

    public ServicePoint() {
        queue = new LinkedList<>();
    }

    public void addToQueue(Customer customer) {
        queue.addFirst(customer); // add to front
        customer.setTimeArrival(System.currentTimeMillis());
    }

    public Customer removeFromQueue() {
        if (!queue.isEmpty()) {
            return queue.removeLast();
        }
        return null;
    }

    public void serve() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
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