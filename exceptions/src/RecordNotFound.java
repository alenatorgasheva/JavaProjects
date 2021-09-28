class RecordNotFound extends RuntimeException {
    public void RecordNotFound() {}

    public void printErrMessage() {
        System.err.println("Error RecordNotFound: the phone book has no such records.");
    }
}
