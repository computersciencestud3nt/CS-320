import java.util.Objects;

/**
 * Contact domain object.
 * 
 * Requirements:
 * - contactId: required, unique, non-null, max length 10, not updatable
 * - firstName: required, non-null, max length 10
 * - lastName:  required, non-null, max length 10
 * - phone:     required, non-null, exactly 10 digits
 * - address:   required, non-null, max length 30
 */
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateId(contactId);
        this.contactId = contactId;

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName cannot be null");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("firstName too long (max 10)");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName cannot be null");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("lastName too long (max 10)");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException("phone cannot be null");
        }
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("phone must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("address cannot be null");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("address too long (max 30)");
        }
        this.address = address;
    }

    private static void validateId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("contactId cannot be null");
        }
        if (id.length() > 10) {
            throw new IllegalArgumentException("contactId too long (max 10)");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        // Equality by ID (which is unique/immutable)
        return contactId.equals(contact.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId);
    }
}