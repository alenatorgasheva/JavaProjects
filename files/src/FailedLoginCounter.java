public class FailedLoginCounter {
    private static FailedLoginCounter instance;
    private int counter = 1;

    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    public void counterAdd () {
        counter += 1;
    }

    public int getCounter() {
        return counter;
    }

    public void updateCounter() {
        counter = 1;
    }
}
