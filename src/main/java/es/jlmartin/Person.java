package es.jlmartin;

public class Person {

    long personId;
    String mobile_phone;
    String country;

    public Person(){}

    public Person(long personId, String mobile_phone, String country){
        this.personId = personId;
        this.mobile_phone = mobile_phone;
        this.country = country;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
