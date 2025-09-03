import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Simple Event class
class Event {
    public String type;
    public int time;

    public Event(String type, int time) {
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" + "type='" + type + '\'' + ", time=" + time + '}';
    }
}

// Simple Clock Singleton (from previous task)
class Clock {
    private static Clock instance;
    private int time;

    private Clock() { time = 0; }

    public static Clock getInstance() {
        if (instance == null) instance = new Clock();
        return instance;
    }

    public int getTime() { return time; }

    public void setTime(int newTime) { time = newTime; }

    public void advanceTime(int units) { time += units; }
}

// ArrivalProcess class
public class ArrivalProcess {
    private String eventType; // type of events generated
    private Random rng;       // random number generator
    private int meanInterval; // average time between arrivals

    public ArrivalProcess(String eventType, int meanInterval) {
        this.eventType = eventType;
        this.meanInterval = meanInterval;
        this.rng = new Random();
    }

    // Method to add a new event to the event list
    public void generateEvent(List<Event> eventList) {
        Clock clock = Clock.getInstance();
        int interval = rng.nextInt(meanInterval) + 1; // random interval 1..meanInterval
        clock.advanceTime(interval);
        Event newEvent = new Event(eventType, clock.getTime());
        eventList.add(newEvent);
    }

    // Method to generate multiple events
    public void generateEvents(List<Event> eventList, int count) {
        for (int i = 0; i < count; i++) {
            generateEvent(eventList);
        }
    }

    // Test program
    public static void main(String[] args) {
        List<Event> eventList = new ArrayList<>();
        ArrivalProcess arrivals = new ArrivalProcess("CustomerArrival", 10);

        // Generate 10 events
        arrivals.generateEvents(eventList, 10);

        // Print event list
        for (Event e : eventList) {
            System.out.println(e);
        }
    }
}

