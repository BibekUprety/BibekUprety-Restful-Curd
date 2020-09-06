package com.example.demo.repository;/*
 * @created 04/09/2020-7:38 AM
 * @project demo
 * @author Bibek Upreti
 */

import com.example.demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
