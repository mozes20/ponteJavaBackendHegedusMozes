package com.example.pontejavabackendtask.Controller;

import com.example.pontejavabackendtask.dto.ContactCreateDto;
import com.example.pontejavabackendtask.dto.ContactDeleteDto;
import com.example.pontejavabackendtask.dto.ContactUpdateDto;
import com.example.pontejavabackendtask.dto.EmailCreateDto;
import com.example.pontejavabackendtask.service.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    private final ContactService contactService;
    private final Logger logger = LoggerFactory.getLogger(ContactController.class);


    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }



    @PostMapping("/contact")
    public ResponseEntity<?> createContact(@RequestBody ContactCreateDto contact) {
        return contactService.createContact(contact.getName());
    }

    @PutMapping("/contact")
    public ResponseEntity<?> updateContact(@RequestBody ContactUpdateDto contact) {
        return contactService.updateContact(contact.getId(), contact.getName());
    }

    @DeleteMapping("/contact")
    public ResponseEntity<?> deleteContact(@RequestBody ContactDeleteDto contact) {
        return contactService.deleteContact(contact.getId());
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<?> getContact(@PathVariable int id) {
        return contactService.getContact(id);
    }

    @GetMapping("/contacts")
    public ResponseEntity<?> getContacts() {
        return ResponseEntity.ok(contactService.getContacts());
    }

    @PostMapping("/contact/email")
    public ResponseEntity<?> addEmailToContact(@RequestBody EmailCreateDto emailCreateDto) {
        return contactService.addEmailToContact(emailCreateDto.getContactId(), emailCreateDto.getEmail());
    }

}
