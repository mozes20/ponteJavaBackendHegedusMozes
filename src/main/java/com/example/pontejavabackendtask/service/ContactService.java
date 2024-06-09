package com.example.pontejavabackendtask.service;

import com.example.pontejavabackendtask.Entity.AddressEntity;
import com.example.pontejavabackendtask.Entity.ContactEntity;
import com.example.pontejavabackendtask.Entity.EmailEntity;
import com.example.pontejavabackendtask.Repository.AddressRepository;
import com.example.pontejavabackendtask.Repository.ContactRepository;
import com.example.pontejavabackendtask.Repository.EmailRepository;
import com.example.pontejavabackendtask.dto.ContactResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final EmailRepository emailRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, EmailRepository emailRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.emailRepository = emailRepository;
        this.addressRepository = addressRepository;
    }

    public ResponseEntity<?> createContact(String name) {
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Name cannot be null or empty");
        }
        ContactEntity newContact = new ContactEntity();
        newContact.setName(name);
        contactRepository.save(newContact);
        return ResponseEntity.status(HttpStatus.CREATED).body(newContact);
    }
    public ResponseEntity<?> updateContact(int id, String newName) {
        Optional<ContactEntity> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            ContactEntity existingContact = contact.get();
            existingContact.setName(newName);
            contactRepository.save(existingContact);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<?> deleteContact(int id) {
        Optional<ContactEntity> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            contactRepository.delete(contact.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<?> getContact(int id) {
        Optional<ContactEntity> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            return ResponseEntity.ok(contact.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public List<ContactEntity> getContacts() {
        return contactRepository.findAll();
    }

    public ResponseEntity<?> addEmailToContact(int contactId, String email) {
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


    public ResponseEntity<?> addAddresstoContact(int contactId, String address) {
        Optional<ContactEntity> contact = contactRepository.findById(contactId);
        if (contact.isPresent()) {
            AddressEntity newAddress = new AddressEntity();
            newAddress.setAddress(address);
            newAddress.setContact(contact.get());
            addressRepository.save(newAddress);
            return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> getContactAddresses(int contactId) {
        Optional<ContactEntity> contact = contactRepository.findById(contactId);
        if (contact.isPresent()) {
            return ResponseEntity.ok(contact.get().getAddress());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> deleteAddressFromContact(int addressId) {
        Optional<AddressEntity> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> updateAddressFromContact(int addressId, String newAddress) {
        Optional<AddressEntity> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            AddressEntity existingAddress = address.get();
            existingAddress.setAddress(newAddress);
            addressRepository.save(existingAddress);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
