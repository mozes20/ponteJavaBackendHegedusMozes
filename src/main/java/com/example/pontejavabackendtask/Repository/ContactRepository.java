package com.example.pontejavabackendtask.Repository;
import com.example.pontejavabackendtask.Entity.ContactEntity;
import com.example.pontejavabackendtask.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<ContactEntity, Integer> {
}