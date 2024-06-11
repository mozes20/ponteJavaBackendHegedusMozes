package com.example.pontejavabackendtask;
import com.example.pontejavabackendtask.Repository.ContactRepository;
import com.example.pontejavabackendtask.Repository.EmailRepository;
import com.example.pontejavabackendtask.Service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    private EmailService emailService;

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private ContactRepository contactRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        emailService = new EmailService(emailRepository, contactRepository);
    }

    @Test
    void isValidEmail_withValidEmail_returnsTrue() {
        String email = "test@example.com";
        assertTrue(emailService.isValidEmail(email));
    }

    @Test
    void isValidEmail_withInvalidEmail_returnsFalse() {
        String email = "invalid email";
        assertFalse(emailService.isValidEmail(email));
    }
}