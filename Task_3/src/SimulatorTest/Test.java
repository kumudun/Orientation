package SimulatorTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Clock Singleton
class Clock {
    private static Clock instance;
    private int time;

    private Clock() { time = 0; }

    public static Clock getInstance() {
        if (instance == null) instance = new Clock();
        return instance;
    }

    public int getTime() { return time; }

    public void advanceTime(int units) { time += units; }

    public void setTime(int newTime) { time = newTime; }
}

// EventType enum
enum EventType {
    ARRIVAL, DEPARTURE
}

// Event class
class Event {
    public EventType type;
    public int time;

    public Event(EventType type, int time) {
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" + "type=" + type + ", time=" + time + '}';
    }
}

// Customer class
class Customer {
    public int arrivalTime;
    public int departureTime;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTimeInSystem() {
        return departureTime - arrivalTime;
    }
}

// ArrivalProcess class
class ArrivalProcess {
    private EventType eventType;
    private Random rng;
    private int meanInterval;

    public ArrivalProcess(EventType type, int meanInterval) {
        this.eventType = type;
        this.meanInterval = meanInterval;
        this.rng = new Random();
    }

    public void generateEvent(List<Event> eventList) {
        Clock clock = Clock.getInstance();
        int interval = rng.nextInt(meanInterval) + 1; // random interval 1..meanInterval
        clock.advanceTime(interval);
        Event e = new Event(eventType, clock.getTime());
        eventList.add(e);
    }

    public void generateEvents(List<Event> eventList, int count) {
        for (int i = 0; i < count; i++) {
            generateEvent(eventList);
        }
    }
}

// ServicePoint class
class ServicePoint {
    private List<Customer> queue = new ArrayList<>();

    public void addCustomer(Customer c) {
        queue.add(c);
    }

    public void serveCustomers(Clock clock, int serviceTime) {
        for (Customer c : queue) {
            c.departureTime = clock.getTime() + serviceTime;
        }
    }

    public void printCustomerTimes() {
        for (Customer c : queue) {
            System.out.println("Arrival: " + c.arrivalTime + ", Departure: " + c.departureTime
                    + ", Time in system: " + c.getTimeInSystem());
        }
    }
}

// Test program
public class Test {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        List<Event> eventList = new ArrayList<>();

        // Generate 10 arrival events
        ArrivalProcess arrivals = new ArrivalProcess(EventType.ARRIVAL, 10);
        arrivals.generateEvents(eventList, 10);

        // Print events and time of last event
        System.out.println("Generated Events:");
        for (Event e : eventList) {
            System.out.println(e);
        }
        System.out.println("Time of last event: " + clock.getTime());

        // Process events sequentially
        ServicePoint servicePoint = new ServicePoint();
        for (Event e : eventList) {
            if (e.type == EventType.ARRIVAL) {
                Customer c = new Customer(e.time);
                servicePoint.addCustomer(c);
            }
        }

        // Advance clock slightly (e.g., 5 time units)
        clock.advanceTime(5);

        // Serve customers one by one, assume fixed service time, e.g., 3 units
        servicePoint.serveCustomers(clock, 3);

        // Print results
        System.out.println("\nCustomer times in system:");
        servicePoint.printCustomerTimes();
    }
}

