import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    List<Contact> adressesBk = new ArrayList<>() ;
    public void addContact(Contact c1){
        adressesBk.add(c1);
        System.out.println("Contact is added");
    }
}
