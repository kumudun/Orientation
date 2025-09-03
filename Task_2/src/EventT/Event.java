package EventT;

public class Event implements Comparable<Event> {
    private int time;             // Event time is essential
    private EventType type;       // Event type (arrival, exit)
    private String name;

    public Event(int time, EventType type, String name) {
        this.time = time;
        this.type = type;
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public EventType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    // Compare events by time (chronological order)
    @Override
    public int compareTo(Event other) {
        return this.time - other.time;
    }

    @Override
    public String toString() {
        return "Event{" + "time=" + time + ", type=" + type + ", name='" + name + "'}";
    }
}

