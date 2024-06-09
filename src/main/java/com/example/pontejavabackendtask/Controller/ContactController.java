package com.example.pontejavabackendtask.Controller;

import com.example.pontejavabackendtask.dto.*;
import com.example.pontejavabackendtask.Service.AddressService;
import com.example.pontejavabackendtask.Service.ContactService;
import com.example.pontejavabackendtask.Service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    private final ContactService contactService;
    private final EmailService emailService;
    private final AddressService addressService;
    private final Logger logger = LoggerFactory.getLogger(ContactController.class);


    @Autowired
    public ContactController(ContactService contactService, EmailService emailService, AddressService addressService) {
        this.contactService = contactService;
        this.emailService = emailService;
        this.addressService = addressService;
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

    //manage emails

    @PostMapping("/contact/email")
    public ResponseEntity<?> addEmailToContact(@RequestBody EmailCreateDto emailCreateDto) {
        return emailService.addEmailToContact(emailCreateDto.getContactId(), emailCreateDto.getEmail());
    }

    @PutMapping("/contact/email")
    public ResponseEntity<?> updateEmailFromContact(@RequestBody EmailUpdateDto emailUpdateDto) {
        return emailService.updateEmailFromContact(emailUpdateDto.getId(), emailUpdateDto.getEmail());
    }

    @DeleteMapping("/contact/email")
    public ResponseEntity<?> deleteEmailFromContact(@RequestBody EmailDeleteDto emailDeleteDto) {
        return emailService.deleteEmailFromContact(emailDeleteDto.getId());
    }

    //manage addresses

    @PostMapping("/contact/address")
    public ResponseEntity<?> addAddressToContact(@RequestBody AddressCreateDto addressCreateDto) {
        return addressService.addAddresstoContact(addressCreateDto.getContactId(), addressCreateDto.getAddress());
    }


}
