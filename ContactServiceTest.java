import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void addAndGetContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("ID100", "Amy", "Smith", "1112223333", "1 Oak Ave");
        service.addContact(c);

        Contact found = service.getContact("ID100");
        assertNotNull(found);
        assertEquals("Amy", found.getFirstName());
    }

    @Test
    void addDuplicateIdThrows() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("X1", "A", "B", "1234567890", "addr");
        Contact c2 = new Contact("X1", "C", "D", "0987654321", "addr2");
        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    @Test
    void deleteContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("DEL1", "A", "B", "1234567890", "addr");
        service.addContact(c);

        assertTrue(service.deleteContact("DEL1"));
        assertFalse(service.deleteContact("DEL1")); // already deleted
        assertNull(service.getContact("DEL1"));
    }

    @Test
    void updateFields() {
        ContactService service = new ContactService();
        Contact c = new Contact("UP1", "Ann", "Bee", "1234567890", "addr");
        service.addContact(c);

        service.updateFirstName("UP1", "Zed");
        service.updateLastName("UP1", "Kay");
        service.updatePhone("UP1", "5556667777");
        service.updateAddress("UP1", "22 Cedar Blvd");

        Contact updated = service.getContact("UP1");
        assertEquals("Zed", updated.getFirstName());
        assertEquals("Kay", updated.getLastName());
        assertEquals("5556667777", updated.getPhone());
        assertEquals("22 Cedar Blvd", updated.getAddress());
    }

    @Test
    void updateOnMissingIdThrows() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("NOPE", "A"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("NOPE", "B"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("NOPE", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("NOPE", "addr"));
    }

    @Test
    void updateValidationIsEnforced() {
        ContactService service = new ContactService();
        Contact c = new Contact("UP2", "Ann", "Bee", "1234567890", "addr");
        service.addContact(c);

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("UP2", "01234567890")); // 11
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("UP2", null));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("UP2", "12345"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("UP2", null));
    }
}