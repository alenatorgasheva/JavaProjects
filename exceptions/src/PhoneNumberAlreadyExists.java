class PhoneNumberAlreadyExists extends Exception {
    public void PhoneNumberAlreadyExists() {}

    public void printErrMessage() {
        System.err.println("Error PhoneNumberAlreadyExists: the phone book has already have the record with this number.");
    }
}
