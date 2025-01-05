import java.util.Objects;

public class Contact {
    String firstName;
    String lastName;
    String city;
    String state;
    String email;
    int phone;
    int zip;


    public Contact(String firstName, String lastName, String city, String state, String email, int phone, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.zip = zip;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;  // Full name as a combination of first and last name
    }

    // Override toString method for better print format
    @Override
    public String toString() {
        return String.format("Name: %s %s, City: %s, State: %s, Email: %s, Phone: %d",
                firstName, lastName, city, state, email, phone);
    }


    // Override equals for duplicate check based on firstName and lastName
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return firstName.equalsIgnoreCase(contact.firstName) &&
                lastName.equalsIgnoreCase(contact.lastName);
    }

    // Override hashCode to match equals
    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }
}
