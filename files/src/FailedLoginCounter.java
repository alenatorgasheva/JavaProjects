import java.util.HashMap;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;
    private HashMap<String, Integer> counter;

    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
            instance.counter = new HashMap<>();
        }
        return instance;
    }

    public void counterAdd (String email) {
        if (counter.containsKey(email)) {
            counter.replace(email, counter.get(email) + 1);
        } else {
            counter.put(email, 1);
        }
    }

    public int getCounter(String email) {
        return counter.get(email);
    }

    public void updateCounter(String email) {
        counter.put(email, 1);
    }
}
