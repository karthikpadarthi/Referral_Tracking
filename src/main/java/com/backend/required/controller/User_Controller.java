package com.backend.required.controller;

import com.backend.required.model.ReferralDto;
import com.backend.required.model.User_Model;
import com.backend.required.service.User_Service;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users") // Base URL for user-related APIs
public class User_Controller {

    @Autowired
    private User_Service userService;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Map<String, String> request) {
        try {
            String name = request.get("name");
            String email = request.get("email");
            String password = request.get("password");
            String referralCode = request.getOrDefault("referralCode", null);


            User_Model user = userService.signup(name, email, password, referralCode);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "User registered successfully!");
            response.put("userId", user.getId());
            response.put("referralCode", user.getReferralCode());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    @PostMapping("/complete-profile/{userId}")
    public ResponseEntity<?> completeProfile(@PathVariable Long userId) {
        try {
            User_Model user = userService.completeProfile(userId);
            return ResponseEntity.ok("Profile completed successfully for user: " + user.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    @GetMapping("/referred-users/{referralCode}")
    public ResponseEntity<List<User_Model>> getReferredUsers(@PathVariable String referralCode) {
        List<User_Model> referredUsers = userService.getReferredUsers(referralCode);
        return ResponseEntity.ok(referredUsers);
    }
    @GetMapping("/referrals/{referralCode}")
    public ResponseEntity<?> getReferralCount(@PathVariable String referralCode) {
        long count = userService.countReferrals(referralCode);
        return ResponseEntity.ok("Total referrals: " + count);
    }



    @GetMapping("/download-csv/{referralCode}")
    public void downloadReferralCSV(HttpServletResponse response,@PathVariable String referralCode) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=referrals.csv");
        List<ReferralDto> referrals = userService.getAllReferrals(referralCode);
        PrintWriter writer = response.getWriter();
        writer.println("Referrer Name,Referred Email,Referral Code"); // CSV Header

        for (ReferralDto referral : referrals) {
            writer.println(referral.getReferrerName() + "," +
                    referral.getReferredEmail() + "," +
                    referral.getReferralCode());
        }

        writer.flush();
        writer.close();
    }

}
