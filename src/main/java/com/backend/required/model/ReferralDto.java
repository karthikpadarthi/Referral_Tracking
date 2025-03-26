package com.backend.required.model;

public class ReferralDto {
    private String referrerName;
    private String referredEmail;
    private String referralCode;

    public ReferralDto(String referrerName, String referredEmail, String referralCode) {
        this.referrerName = referrerName;
        this.referredEmail = referredEmail;
        this.referralCode = referralCode;
    }

    // Getters and Setters
    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName;
    }

    public String getReferredEmail() {
        return referredEmail;
    }

    public void setReferredEmail(String referredEmail) {
        this.referredEmail = referredEmail;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
}
