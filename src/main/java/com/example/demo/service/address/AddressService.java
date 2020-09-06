package com.example.demo.service.address;/*
 * @created 04/09/2020-7:47 AM
 * @project demo
 * @author Bibek Upreti
 */

import com.example.demo.model.Address;

import java.util.Optional;

public interface AddressService {

//    List<Address> getAllAddress();

    Address addAddress(Address address);

    Optional<Address> getAddressById(Long id);


    Address updateAddress(Long id,Address address);
}
