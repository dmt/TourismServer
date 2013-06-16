package org.oos.travel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Visa {

    @JsonProperty
    private final long id;
    @JsonProperty
    private final String companyName;
    @JsonProperty
    private final String address;

    @JsonCreator
    public Visa(@JsonProperty("id") long id, @JsonProperty("companyName") String companyName, @JsonProperty("address") String address) {
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
