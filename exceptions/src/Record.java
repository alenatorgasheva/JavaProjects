class Record {
    public long id;
    public String phoneNumber;
    public String name;

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

    public void printInfo() {
        System.out.println(name + " " + phoneNumber);
    }
}
