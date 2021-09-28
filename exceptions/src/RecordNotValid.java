class RecordNotValid extends Exception {
    public void RecordNotValid() {}

    public void printErrMessage() {
        System.err.println("Error RecordNotValid: the record is not correct.");
    }
}
