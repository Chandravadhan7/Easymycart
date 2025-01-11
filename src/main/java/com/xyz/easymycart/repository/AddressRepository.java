package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    Address save(Address address);

    @Query(value = "select * from address a where a.user_id = :userId",nativeQuery = true)
    List<Address> findAddressByUserId(@Param("userId") Long userId);
}
