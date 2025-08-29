
public class Customer {
    private int id; // 32 bits
    private long timeStart; // 64 bits
    private long timeEnd;
    private static int _id = 1;

    public Customer() {
        this.id = _id++;
    }

    public int getId() {
        return this.id;
    }

    public long getTimeStart() {
        return this.timeStart;
    }

    public long getTimeEnd() {
        return this.timeEnd;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(long timeEnd) {
        this.timeEnd = timeEnd;
    }

    // returns the time (in seconds) the customer has spent in the system
    public double timeSpend() {
        return (this.timeEnd - this.timeStart) / 1000.0;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Customer customer2 = new Customer();

        // Customer entering to the system
        customer.setTimeStart(System.currentTimeMillis());
        customer2.setTimeStart(System.currentTimeMillis());

        // waiting for one second
        try {
            Thread.sleep(1000);  // 1000 ms = 1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // customer is ready
        customer.setTimeEnd(System.currentTimeMillis());

        try {
            Thread.sleep(1000);  // 1000 ms = 1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customer2.setTimeEnd(System.currentTimeMillis());

        System.out.println("Customer " + customer.getId() + " servicing time: " + customer.timeSpend() + "s");
        System.out.println("Customer " + customer2.getId() + " servicing time: " + customer2.timeSpend() + "s");
    }
}
