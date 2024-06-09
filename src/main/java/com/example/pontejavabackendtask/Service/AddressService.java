package com.example.pontejavabackendtask.Service;

import com.example.pontejavabackendtask.Entity.AddressEntity;
import com.example.pontejavabackendtask.Entity.ContactEntity;
import com.example.pontejavabackendtask.Repository.AddressRepository;
import com.example.pontejavabackendtask.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, ContactRepository contactRepository) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
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
