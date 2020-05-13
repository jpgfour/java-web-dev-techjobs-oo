package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {

    //fields
    private int id;
    private static int nextId = 1;
    private String value;

    //constructors
    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //getters and setters - no setId()
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //custom methods
    @Override
    public String toString() {
        if(value!=""&&value!=null) {
            return value;
        }else{
            return "Data not available";
        }
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
