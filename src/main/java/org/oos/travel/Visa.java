package org.oos.travel;

public class Visa {

    private final long id;
    private final String companyName;
    private final String address;

    public Visa(long id, String companyName, String address) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }
}
