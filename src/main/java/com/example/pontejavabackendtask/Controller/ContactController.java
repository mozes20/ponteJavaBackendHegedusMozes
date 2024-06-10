package com.example.pontejavabackendtask.Controller;

import com.example.pontejavabackendtask.Entity.ContactEntity;
import com.example.pontejavabackendtask.dto.*;
import com.example.pontejavabackendtask.Service.AddressService;
import com.example.pontejavabackendtask.Service.ContactService;
import com.example.pontejavabackendtask.Service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
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


    @PostMapping()
    public ResponseEntity<?> createContact(@RequestBody ContactCreateDto contact) {
        return contactService.createContact(contact.getName());
    }

    @PutMapping("/")
    public ResponseEntity<?> updateContact(@RequestBody ContactUpdateDto contact) {
        return contactService.updateContact(contact.getId(), contact.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable String id) {
        System.out.println("deleteContact");
        return contactService.deleteContact(Integer.parseInt(id));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContact(@PathVariable String id) {
        return contactService.getContact(Integer.parseInt(id));
    }

    @GetMapping("/contacts")
    public ResponseEntity<?> getContacts(Pageable pageable) {
        System.out.println("getContacts");
        Page<ContactEntity> contacts = contactService.getContacts(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(contacts);
    }

    //manage emails

    @PostMapping("/email")
    public ResponseEntity<?> addEmailToContact(@RequestBody EmailCreateDto emailCreateDto) {
        return emailService.addEmailToContact(emailCreateDto.getContactId(), emailCreateDto.getEmail());
    }

    @PutMapping("/email")
    public ResponseEntity<?> updateEmailFromContact(@RequestBody EmailUpdateDto emailUpdateDto) {
        return emailService.updateEmailFromContact(emailUpdateDto.getId(), emailUpdateDto.getEmail());
    }

    @DeleteMapping("/email")
    public ResponseEntity<?> deleteEmailFromContact(@RequestBody EmailDeleteDto emailDeleteDto) {
        return emailService.deleteEmailFromContact(emailDeleteDto.getId());
    }

    //manage addresses

    @PostMapping("address")
    public ResponseEntity<?> addAddressToContact(@RequestBody AddressCreateDto addressCreateDto) {
        return addressService.addAddresstoContact(addressCreateDto.getContactId(), addressCreateDto.getAddress());
    }


}
