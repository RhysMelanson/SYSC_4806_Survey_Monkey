package JpaApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private long id;

    private String name = "";
    private String address = "";
    private String number = "";

    public BuddyInfo(){}

    public BuddyInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String s = "BuddyInfo: [id: " + id + ", name:" + name + ", address:" + address + ", number:" + number + " ]";
        return s;
    }
}
