public class FailedLoginCounter {
    private static FailedLoginCounter instance;

    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }
}
