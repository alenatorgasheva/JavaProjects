public class Account {
    private String name;
    private String bday;
    private String email;
    private String password;
    private boolean blocked;

    public Account(String name, String bday, String email, String password, String blocked) {
        this.name = name;
        this.bday = bday;
        this.email = email;
        this.password = password;
        if (blocked == "true") {
            this.blocked = true;
        } else {
            this.blocked = false;
        }
    }

    public Account(String name, String bday, String email, String password) {
        this.name = name;
        this.bday = bday;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void block() {
        blocked = true;
    }

    public void printInfo() {
        System.out.println(name + " " + bday + " " + email);
    }

    public String toCSV() {
        return name + ";" + bday + ";" + email + ";" + password + ";" + blocked + "\n";
    }


}
