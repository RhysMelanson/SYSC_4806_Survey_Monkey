package JpaApplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BuddyInfo> book;

    public AddressBook() {
        book = new ArrayList<BuddyInfo>();
    }

    public AddressBook(List<BuddyInfo> book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo buddy) {
        book.add(buddy);
    }

    public List<BuddyInfo> getBook() {
        return book;
    }

    public void setBook(List<BuddyInfo> book) {
        this.book = book;
    }

    public BuddyInfo getBuddy(int index) {
        return book.get(index);
    }

    public void removeBuddy(int index) {
        book.remove(index);
    }

    @Override
    public String toString() {
        String s =  "AddressBook: \n";
        int i = 0;
        for(BuddyInfo buddy: book) {
            i++;
            s += i + " | " + buddy + '\n';
        }
        return s;
    }
}
