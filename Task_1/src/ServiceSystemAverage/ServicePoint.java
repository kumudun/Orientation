package ServiceSystemAverage;

import java.util.LinkedList;
import java.util.Random;

class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();
    private final Random rng;
    private final boolean realTimeSleep; // if false, we don't actually sleep
    private long totalServiceTimeMs = 0L;
    private int servedCount = 0;

    public ServicePoint(Random rng, boolean realTimeSleep) {
        this.rng = rng;
        this.realTimeSleep = realTimeSleep;
    }


    public ServicePoint() { this(new Random(), true); }

    public void addToQueue(Customer customer) {
        queue.addFirst(customer);           // add to front
        customer.setTimeArrival(System.currentTimeMillis());
    }

    public Customer removeFromQueue() {
        return queue.isEmpty() ? null : queue.removeLast();
    }

    public double serveAllAndReturnAverageServiceSeconds() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
            if (customer == null) break;

            long start = System.currentTimeMillis();
            customer.setTimeStartService(start);

            int serviceMs = 1000 + rng.nextInt(2000); // 1–3 s
            if (realTimeSleep) {
                try { Thread.sleep(serviceMs); }
                catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }

            long end = realTimeSleep ? System.currentTimeMillis() : (start + serviceMs);
            customer.setTimeEndService(end);

            long thisServiceMs = end - start;
            totalServiceTimeMs += thisServiceMs;
            servedCount++;

            System.out.printf(
                    "Customer %d response time: %.3f s, service time: %.3f s%n",
                    customer.getId(), customer.getResponseTime(), customer.getServiceTime()
            );
        }

        double avg = servedCount == 0 ? 0.0 : (totalServiceTimeMs / (double) servedCount) / 1000.0;
        System.out.printf("Average service time across %d customers: %.3f s%n", servedCount, avg);
        return avg;
    }

    public int getServedCount() { return servedCount; }
    public double getAverageServiceSeconds() {
        return servedCount == 0 ? 0.0 : (totalServiceTimeMs / (double) servedCount) / 1000.0;
    }
}

