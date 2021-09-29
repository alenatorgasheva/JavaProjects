import java.util.ArrayList;
import java.util.List;

class PhoneBook {
    private List<Record> book;

    public PhoneBook() {
        this.book = new ArrayList<>();
    }

    public List<Record> getAllRecords() {
        // метод возвращает список из всех записей справочника
        return book;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        // метод сохраняет в справочнике новую запись
        // Если в справочнике есть запись с таким же номером телефона, выбросить проверяемое исключение PhoneNumberAlreadyExists.
        for (Record existingRecord : book) {
            if (existingRecord.phoneNumber.equals(record.phoneNumber)) {
                throw new PhoneNumberAlreadyExists();
            }
        }
        book.add(record);
    }

    public void updateRecord(Record record) throws RecordNotValid {
        // Метод обновляет запись в справочнике
        // Если запись с таким идентификатором не существует, выбросить непроверяемое исключение RecordNotFound.
        // Если в новой записи не заполнено поле name и/или поле phoneNumber, выбросить проверяемое исключение RecordNotValid.

        for (Record existingRecord : book) {
            if (existingRecord.id == record.id) {
                if ((record.phoneNumber != null) || (record.name != null)) {
                    book.remove(existingRecord);
                    book.add(record);
                    return;
                } else {
                    throw new RecordNotValid();
                }
            }
        }
        throw new RecordNotFound();
    }

    public void deleteRecord(long id) {
        // удаляет запись из справочника по идентификатору
        // Если подходящая запись в справочнике не найдена - выбрасывается непроверяемое исключение RecordNotFound.
        for (Record existingRecord : book) {
            if (existingRecord.id == id) {
                book.remove(existingRecord);
                return;
            }
        }
        throw new RecordNotFound();
    }

    public void printInfo() {
        if (book.isEmpty()) {
            System.out.println("Телефонная книга пуста.");
        } else {
            for (Record record : book) {
                record.printInfo();
            }
        }
    }
}
