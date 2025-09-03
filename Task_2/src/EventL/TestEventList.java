package EventL;

public class TestEventList {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // a) Generate a list of events
        eventList.addEvent(new Event(10, "Arrival"));
        eventList.addEvent(new Event(5, "Service Start"));
        eventList.addEvent(new Event(20, "Service End"));
        eventList.addEvent(new Event(15, "Exit"));

        // b) Remove the first event (next to be processed)
        Event next = eventList.getNextEvent();
        System.out.println("Next event processed: " + next);

        // c) Print the contents of EventList, ordered by event time
        System.out.println("Remaining events in chronological order:");
        for (Event e : eventList.getAllEventsOrdered()) {
            System.out.println(e);
        }
    }
}

