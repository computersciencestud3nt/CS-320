import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void createValidContact() {
        Contact c = new Contact("ABC123", "Jane", "Doe", "1234567890", "123 Main Street");
        assertEquals("ABC123", c.getContactId());
        assertEquals("Jane", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main Street", c.getAddress());
    }

    @Test
    void contactIdValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "A", "B", "1234567890", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("01234567890", "A", "B", "1234567890", "addr")); // 11 chars
    }

    @Test
    void nameValidation() {
        Contact c = new Contact("ID1", "A", "B", "1234567890", "addr");
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("01234567890")); // 11
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("01234567890")); // 11
    }

    @Test
    void phoneValidation() {
        Contact c = new Contact("ID2", "A", "B", "1234567890", "addr");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345678901"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345abcde"));
        // valid boundary
        c.setPhone("0987654321");
        assertEquals("0987654321", c.getPhone());
    }

    @Test
    void addressValidation() {
        Contact c = new Contact("ID3", "A", "B", "1234567890", "addr");
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
        String thirtyOne = "1234567890123456789012345678901"; // 31 chars
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(thirtyOne));
        // valid boundary (30 chars)
        String thirty = "123456789012345678901234567890";
        c.setAddress(thirty);
        assertEquals(thirty, c.getAddress());
    }
}