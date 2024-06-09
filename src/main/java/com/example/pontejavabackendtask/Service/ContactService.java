package com.example.pontejavabackendtask.Service;

import com.example.pontejavabackendtask.Entity.ContactEntity;
import com.example.pontejavabackendtask.Repository.AddressRepository;
import com.example.pontejavabackendtask.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    private final AddressRepository addressRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
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










}
