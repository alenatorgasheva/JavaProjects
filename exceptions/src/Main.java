public class Main {
    public static void main(String[] args) throws PhoneNumberAlreadyExists, RecordNotValid {
        PhoneBook book = new PhoneBook();

        Record record1 = new Record(1, "+7-900-000-00-00", "Person A");
        Record record2 = new Record(2, "+7-900-000-00-01", "Person B");
        Record record3 = new Record(3, "+7-900-000-00-02", "Person C");
        Record record4 = new Record(4, "+7-900-000-00-00", "Person D");
        Record record5 = new Record(3);
        Record record6 = new Record(1, "+7-900-000-00-03", "Person A");

        book.createRecord(record1);
        book.createRecord(record2);
        book.createRecord(record3);

        // Проверка createRecord
//        book.createRecord(record4);

        // Проверка updateRecord
        book.updateRecord(record4);
//        book.updateRecord(record5);
//        book.updateRecord(record6);

        // Проверка deleteRecord
//        book.deleteRecord(5);
        book.deleteRecord(3);

        book.printInfo();
    }
}