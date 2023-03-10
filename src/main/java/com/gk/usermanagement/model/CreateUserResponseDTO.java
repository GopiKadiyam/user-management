package com.gk.usermanagement.model;

import java.util.List;

public class CreateUserResponseDTO {
    private Long user_id;
    private Long phoneNumber;
    private String gmail;
    private String passWord;
    private UserProfileDTO userProfile;
    private List<ProfessionalDetailsDTO> professionalDetailsDTOS;

    public CreateUserResponseDTO() {
    }

    public CreateUserResponseDTO(Long user_id, Long phoneNumber, String gmail, String passWord, UserProfileDTO userProfile, List<ProfessionalDetailsDTO> professionalDetailsDTOS) {
        this.user_id = user_id;
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
        this.passWord = passWord;
        this.userProfile = userProfile;
        this.professionalDetailsDTOS = professionalDetailsDTOS;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public List<ProfessionalDetailsDTO> getProficinalDetailsDTOs() {
        return professionalDetailsDTOS;
    }

    public void setProficinalDetailsDTOs(List<ProfessionalDetailsDTO> professionalDetailsDTOS) {
        this.professionalDetailsDTOS = professionalDetailsDTOS;
    }
}
