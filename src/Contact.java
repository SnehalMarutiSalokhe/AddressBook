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

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", zip=" + zip +
                '}';
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
