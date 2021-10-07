import java.util.ArrayList;

public class FileAccountManager implements AccountManager {
    private ArrayList<Account> data;

    @Override
    public void register(Account newAccount) throws AccountAlreadyExistsException {
        /**
         * Метод проверяет по полю email, что данный аккаунт в базе
         * отсутствует, и создает новую запись, в противном случае
         * выбрасывает ошибку AccountAlreadyExistsException
         */
        for (Account account : data) {
            if (account.getEmail().equals(newAccount.getEmail())) {
                throw new AccountAlreadyExistsException();
            }
        }
        data.add(newAccount);
    }

    @Override
    public Account login(String email, String password) throws AccountBlockedException, WrongCredentialsException {
        /**
         * Метод возвращает Account, если для email+пароль есть
         * подходящая запись в базе и аккаунт не заблокирован.
         * Если неверно введены email и/или пароль - выбрасывается
         * исключение WrongCredentialsException.
         * Если email и пароль верны, но аккаунт заблокирован -
         * выбрасывается исключение AccountBlockedException.
         * Если для конкретного пользователя больше 5 неудачных
         * попыток авторизоваться, то аккаунт блокируется.
         */
        for (Account account : data) {
            if (account.getEmail().equals(email)) {
                if (account.getBlocked()) {
                    // если аккаунт заблокирован
                    throw new AccountBlockedException();
                }
                if (account.getPassword().equals(password)) {
                    if (!account.getBlocked()) {
                        // если все хорошо
                        System.out.println("\n\tWelcome, " + account.getName() + "!\n");
                        return account;
                    } else {
                        // если аккаунт заблокирован
                        throw new AccountBlockedException();
                    }
                } else {
                    // если неверный пароль
                    throw new WrongCredentialsException();
                }
            }
        }
        // если неверный email
        throw new WrongCredentialsException();
    }


    @Override
    public void removeAccount(String email, String password) throws WrongCredentialsException {
        /**
         * Метод удаляет пользователя из базы, если логин и пароль
         * введены верно. В противном случае выбрасывает
         * ошибку WrongCredentialsException
         */
        for (Account account : data) {
            if (account.getEmail().equals(email)) {
                if (account.getPassword().equals(password)) {
                    if (account.getBlocked()) {
                        // если все хорошо
                        data.remove(account);
                        return;
                    }
                }
            }
        }
        // если неверный вход
        throw new WrongCredentialsException();
    }

    public Account findAccount(String email) throws WrongCredentialsException {
        for (Account account : data) {
            if (account.getEmail().equals(email)) {
                return account;
            }
        }
        // если неверный email
        throw new WrongCredentialsException();
    }

    public ArrayList<Account> getData() {
        return this.data;
    }

    public void setData(ArrayList<Account> accounts) {
        this.data = accounts;
    }


}
