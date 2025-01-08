package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

    Address save(Address address);
}
