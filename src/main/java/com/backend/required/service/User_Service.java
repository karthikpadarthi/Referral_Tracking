package com.backend.required.service;

import com.backend.required.model.ReferralDto;
import com.backend.required.model.User_Model;
import com.backend.required.repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class User_Service {

    @Autowired
    private User_Repository userRepository;

    public User_Model signup(String name, String email, String password, String referralCode) {
        String newReferralCode = generateReferralCode();
        User_Model user = new User_Model();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setReferralCode(newReferralCode);
        if (referralCode != null && !referralCode.isEmpty()) {
            Optional<User_Model> referrer = userRepository.findByReferralCode(referralCode);
            if (referrer.isPresent()) {
                user.setReferredBy(referralCode);
            } else {
                throw new IllegalArgumentException("Invalid referral code provided.");
            }
        }
        return userRepository.save(user);
    }

    public User_Model completeProfile(Long userId) {
        Optional<User_Model> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found.");
        }

        User_Model user = userOptional.get();
        user.setProfileCompleted(true);
        userRepository.save(user);
        if (user.getReferredBy() != null) {
            Optional<User_Model> referrer = userRepository.findByReferralCode(user.getReferredBy());
            referrer.ifPresent(userRepository::save);
        }
        return user;
    }
    public long countReferrals(String referralCode) {
        return userRepository.countByReferredBy(referralCode);
    }
    public List<User_Model> getReferredUsers(String referralCode) {
        return userRepository.findAllByReferredBy(referralCode);
    }
    private String generateReferralCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }


    public List<ReferralDto> getAllReferrals(String referralCode) {
//            return Arrays.asList(
//                    new referralDto("Alice", "bob@example.com", "REF123"),
//                    new referralDto("John", "jane@example.com", "REF456")
//            );
        List<ReferralDto> temp = new ArrayList<>();
        List<User_Model> users = getReferredUsers(referralCode);
        for(User_Model user : users){
            ReferralDto referralDto = new ReferralDto(user.getName(), user.getEmail(), user.getReferralCode());
            temp.add(referralDto);
        }
        return temp;
    }

}
