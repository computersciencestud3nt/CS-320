import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * In-memory ContactService.
 *
 * Requirements:
 * - add contacts with unique ID
 * - delete contacts by ID
 * - update fields (firstName, lastName, Number/phone, Address) by ID
 */
public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    /** Adds a contact if its ID is unique. */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact cannot be null");
        }
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("duplicate contactId: " + id);
        }
        contacts.put(id, contact);
    }

    /** Deletes a contact by ID. Returns true if it existed. */
    public boolean deleteContact(String contactId) {
        if (contactId == null) {
            return false;
        }
        return contacts.remove(contactId) != null;
    }

    /** Update helpers (throws if ID not found or value invalid per Contact setters). */
    public void updateFirstName(String contactId, String firstName) {
        Contact c = getRequired(contactId);
        c.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        Contact c = getRequired(contactId);
        c.setLastName(lastName);
    }

    /** Requirement uses the word "Number" — interpreted as phone number. */
    public void updatePhone(String contactId, String phone) {
        Contact c = getRequired(contactId);
        c.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        Contact c = getRequired(contactId);
        c.setAddress(address);
    }

    /** Optional getter for tests / diagnostics. Returns null if not found. */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    /** Expose an unmodifiable snapshot for debugging if needed. */
    public Map<String, Contact> allContacts() {
        return Collections.unmodifiableMap(contacts);
    }

    private Contact getRequired(String contactId) {
        Contact c = contacts.get(contactId);
        if (c == null) {
            throw new IllegalArgumentException("No contact with id: " + contactId);
        }
        return c;
    }
}