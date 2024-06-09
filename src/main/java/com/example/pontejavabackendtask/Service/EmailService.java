package com.example.pontejavabackendtask.Service;

import com.example.pontejavabackendtask.Entity.ContactEntity;
import com.example.pontejavabackendtask.Entity.EmailEntity;
import com.example.pontejavabackendtask.Repository.ContactRepository;
import com.example.pontejavabackendtask.Repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository, ContactRepository contactRepository) {
        this.emailRepository = emailRepository;
        this.contactRepository = contactRepository;
    }

    public ResponseEntity<?> addEmailToContact(int contactId, String email) {
        if (!isValidEmail(email)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email format");
        }
        Optional<ContactEntity> contact = contactRepository.findById(contactId);
        if (contact.isPresent()) {
            EmailEntity newEmail = new EmailEntity();
            newEmail.setEmail(email);
            newEmail.setContact(contact.get());
            emailRepository.save(newEmail);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEmail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> deleteEmailFromContact(int emailId) {
        Optional<EmailEntity> email = emailRepository.findById(emailId);
        if (email.isPresent()) {
            emailRepository.delete(email.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> updateEmailFromContact(int emailId, String newEmail) {
        if (!isValidEmail(newEmail)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email format");
        }
        Optional<EmailEntity> email = emailRepository.findById(emailId);
        if (email.isPresent()) {
            EmailEntity existingEmail = email.get();
            existingEmail.setEmail(newEmail);
            emailRepository.save(existingEmail);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> getContactEmails(int contactId) {
        Optional<ContactEntity> contact = contactRepository.findById(contactId);
        if (contact.isPresent()) {
            return ResponseEntity.ok(contact.get().getEmails());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


}
