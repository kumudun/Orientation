package EventL;

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


    public ArrayList<Event> getAllEventsOrdered() {
        ArrayList<Event> list = new ArrayList<>(queue);
        Collections.sort(list);
        return list;
    }
}

