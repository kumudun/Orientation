package EventT;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class EventList {
    private PriorityQueue<Event> queue;

    public EventList() {
        queue = new PriorityQueue<>();
    }

    public void addEvent(Event e) {
        queue.add(e);
    }

    public Event getNextEvent() {
        return queue.poll(); // retrieves & removes next event
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Return events in chronological order without disturbing queue
    public ArrayList<Event> getAllEventsOrdered() {
        ArrayList<Event> list = new ArrayList<>(queue);
        Collections.sort(list);
        return list;
    }
}
