class Record {
    private long id;
    private String phoneNumber;
    private String name;

    public Record(long id, String num, String name) {
        this.id = id;
        this.phoneNumber = num;
        this.name = name;
    }

    public Record(long id) {
        this.id = id;
        this.phoneNumber = null;
        this.name = null;
    }

    public long getId() {
        return id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println(name + " " + phoneNumber);
    }
}
