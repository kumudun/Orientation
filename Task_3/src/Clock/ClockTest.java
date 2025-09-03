package Clock;

public class ClockTest {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance(); // Get Singleton instance

        System.out.println("Initial time: " + clock.getTime());

        clock.setTime(10);
        System.out.println("Time after setting to 10: " + clock.getTime());

        clock.advanceTime(5);
        System.out.println("Time after advancing 5 units: " + clock.getTime());

        // Verify Singleton: another reference points to the same instance
        Clock anotherClock = Clock.getInstance();
        System.out.println("Another reference shows time: " + anotherClock.getTime());
    }
}

