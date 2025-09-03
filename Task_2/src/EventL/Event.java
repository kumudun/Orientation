package EventL;

public class Event implements Comparable<Event> {
    private int time;
    private String name;

    public Event(int time, String name) {
        this.time = time;
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Event other) {
        return this.time - other.time;
    }

    @Override
    public String toString() {
        return "Event{" + "time=" + time + ", name='" + name + "'}";
    }
}

