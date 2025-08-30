package ServiceSystem;

class Customer {
    private int id;
    private long timeArrival;
    private long timeStartService;
    private long timeEndService;
    private static int _id = 1;

    public Customer() {
        this.id = _id++;
    }

    public int getId() { return id; }

    public long getTimeArrival() { return timeArrival; }
    public void setTimeArrival(long timeArrival) { this.timeArrival = timeArrival; }

    public long getTimeStartService() { return timeStartService; }
    public void setTimeStartService(long timeStartService) { this.timeStartService = timeStartService; }

    public long getTimeEndService() { return timeEndService; }
    public void setTimeEndService(long timeEndService) { this.timeEndService = timeEndService; }

    public double getResponseTime() {
        return (timeEndService - timeArrival) / 1000.0;
    }

    public double getServiceTime() {
        return (timeEndService - timeStartService) / 1000.0;
    }
}

