package service;

import com.junit.homework.domain.CustomerContact;
import com.junit.homework.repos.CustomerContactRepository;
import com.junit.homework.service.ContactsManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.validation.ValidationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ContactsManagementServiceUnitTest {

    @Mock
    private CustomerContactRepository customerContactRepository;

    @InjectMocks
    private ContactsManagementService contactsManagementService;

    private CustomerContact customerContact() {
        return CustomerContact.builder().firstName("Toghrul")
                .lastName("Mammadov")
                .email("togrul125@gmail.com")
                .deliveryAddressCity("Baku")
                .deliveryAddressLZipCode("az1010")
                .build();
    }

    @BeforeEach
    public void setup() {
        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Toghrul");
        aMockContact.setLastName("Mammadov");
        when(customerContactRepository.save(any())).thenReturn(aMockContact);
    }

    @Test
    public void testAddContactHappyPath() {
        CustomerContact newContact = contactsManagementService.add(customerContact());
        assertThat("Toghrul", equalTo(newContact.getFirstName()));
    }

    @Test
    public void testWhenEmailIsNotSupported() {
        CustomerContact newContact = customerContact();
        newContact.setEmail("togrul.m@yahoo.com");
        Assertions.assertThrows(ValidationException.class, () -> {
            contactsManagementService.add(newContact);
        });
    }

    @Test
    public void testWhenZipCodeIsNull() {
        CustomerContact newContact = customerContact();
        newContact.setDeliveryAddressLZipCode(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactsManagementService.add(newContact);
        });
    }

    @Test
    public void testWhenDbOperationFails() {
        when(customerContactRepository.save(any())).thenThrow(RuntimeException.class);
        CustomerContact newContact = contactsManagementService.add(customerContact());
        assertThat(newContact, is(nullValue()));

    }
}
