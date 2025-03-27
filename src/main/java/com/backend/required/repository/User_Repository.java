package com.backend.required.repository;

import com.backend.required.model.User_Model;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface User_Repository extends JpaRepository<User_Model,Long> {
    Optional<User_Model> findByReferralCode(String referralCode);
    long countByReferredBy(String referralCode);
    List<User_Model> findAllByReferredBy(String referredBy);
}
