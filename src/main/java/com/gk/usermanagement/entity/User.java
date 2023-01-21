package com.gk.usermanagement.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String passWord;
    private Long phoneNumber;
    private String gmail;

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProfessionalDetail> professionalDetails;

    public User() {
    }

    public User(Long id, String passWord, Long phoneNumber, String gmail, UserProfile userProfile, Set<Address> addresses, List<ProfessionalDetail> professionalDetails) {
        this.id = id;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
        this.userProfile = userProfile;
        this.addresses = addresses;
        this.professionalDetails = professionalDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public List<ProfessionalDetail> getProfessionalDetails() {
        return professionalDetails;
    }

    public void setProfessionalDetails(List<ProfessionalDetail> professionalDetails) {
        this.professionalDetails = professionalDetails;
    }
}
