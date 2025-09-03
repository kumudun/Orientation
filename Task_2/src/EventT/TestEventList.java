package EventT;

public class TestEventList {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // a) Generate a list of events with type
        eventList.addEvent(new Event(10, EventType.ARRIVAL, "Customer arrives"));
        eventList.addEvent(new Event(5, EventType.ARRIVAL, "Service start"));
        eventList.addEvent(new Event(20, EventType.EXIT, "Service completed"));
        eventList.addEvent(new Event(15, EventType.EXIT, "Customer leaves"));

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

