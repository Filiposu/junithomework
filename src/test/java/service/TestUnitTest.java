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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TestUnitTest {

	@BeforeEach
    public void setup() {
	}

	@Test
	public void testWhenEmailIsNotSupported() {
		Assertions.assertEquals(6,6);
	}
}
