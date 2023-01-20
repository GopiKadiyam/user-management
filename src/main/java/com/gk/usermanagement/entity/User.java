package com.gk.usermanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String passWord;
    private Long phoneNumber;
    private String gmail;

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProfessionalDetail> professionalDetails;

    public User() {
    }

    public User(Long userId, String passWord, Long phoneNumber, String gmail, UserProfile userProfile, List<ProfessionalDetail> professionalDetails) {
        this.userId = userId;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
        this.userProfile = userProfile;
        this.professionalDetails = professionalDetails;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<ProfessionalDetail> getProfessionalDetails() {
        return professionalDetails;
    }

    public void setProfessionalDetails(List<ProfessionalDetail> professionalDetails) {
        this.professionalDetails = professionalDetails;
    }
}
