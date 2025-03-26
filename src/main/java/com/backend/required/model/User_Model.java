package com.backend.required.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String referralCode; // Unique referral code for each user
    private String referredBy; // Stores referral code of the referrer
    private boolean profileCompleted = false; // Default false, updated when user completes profile
    public User_Model() {
    }
    public User_Model(String name, String email, String password, String referralCode, String referredBy, boolean profileCompleted) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.referralCode = referralCode;
        this.referredBy = referredBy;
        this.profileCompleted = profileCompleted;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public boolean isProfileCompleted() {
        return profileCompleted;
    }

    public void setProfileCompleted(boolean profileCompleted) {
        this.profileCompleted = profileCompleted;
    }
}
