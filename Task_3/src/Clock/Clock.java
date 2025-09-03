package Clock;

public class Clock {
    private static Clock instance; // Singleton instance
    private int time; // current time of the clock

    // Private constructor prevents instantiation from outside
    private Clock() {
        this.time = 0;
    }

    // Public method to get the Singleton instance
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }


    public int getTime() {
        return time;
    }

    public void setTime(int newTime) {
        time = newTime;
    }


    public void advanceTime(int units) {
        time += units;
    }
}


