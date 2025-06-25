package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Address;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

  Address save(Address address);

  @Query(value = "select * from address a where a.user_id = :userId", nativeQuery = true)
  List<Address> findAddressByUserId(@Param("userId") Long userId);

  @Query(value = "select * from address a where a.id = :Id", nativeQuery = true)
  Address findAddressById(@Param("Id") Long Id);

  @Modifying
  @Transactional
  @Query(value = "delete from address a where a.id = :Id",nativeQuery = true)
  void deleteAddressById(@Param("Id") Long Id);

  @Modifying
  @Transactional
  @Query(
      value =
          "UPDATE address SET full_name = :fullName, phone = :phone, pin_code = :pinCode, flat_number = :flatNumber, Area = :area, village = :village, landmark = :landmark, district = :district, state = :state WHERE id = :id",
      nativeQuery = true)
  void updateAddressById(
      @Param("id") Long id,
      @Param("fullName") String fullName,
      @Param("phone") String phone,
      @Param("pinCode") String pinCode,
      @Param("flatNumber") String flatNumber,
      @Param("area") String area,
      @Param("village") String village,
      @Param("landmark") String landmark,
      @Param("district") String district,
      @Param("state") String state);
}
