package com.gk.usermanagement.model;

import java.util.List;

public class CreateUserRequestDTO {
    private Long phoneNumber;
    private String gmail;
    private String passWord;
    private UserProfileDTO userProfile;
    private List<ProfessionalDetailsDTO> professionalDetailsDTOS;

    public CreateUserRequestDTO() {
    }

    public CreateUserRequestDTO(Long phoneNumber, String gmail, String passWord, UserProfileDTO userProfile, List<ProfessionalDetailsDTO> professionalDetailsDTOS) {
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
        this.passWord = passWord;
        this.userProfile = userProfile;
        this.professionalDetailsDTOS = professionalDetailsDTOS;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserProfileDTO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDTO userProfile) {
        this.userProfile = userProfile;
    }

    public List<ProfessionalDetailsDTO> getProfessionalDetailsDTOS() {
        return professionalDetailsDTOS;
    }

    public void setProfessionalDetailsDTOS(List<ProfessionalDetailsDTO> professionalDetailsDTOS) {
        this.professionalDetailsDTOS = professionalDetailsDTOS;
    }
}
