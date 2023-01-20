package com.gk.usermanagement.entity;

import javax.persistence.*;

@Entity
@Table
public class ProfessionalDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "professional_detail_id")
    private String employeeCode;
    private Integer blockNumber;
    private String companyName;
    private String location;
    private String isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public ProfessionalDetail() {
    }

    public ProfessionalDetail(String employeeCode, Integer blockNumber, String companyName, String location, String isActive, User user) {
        this.employeeCode = employeeCode;
        this.blockNumber = blockNumber;
        this.companyName = companyName;
        this.location = location;
        this.isActive = isActive;
        this.user = user;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Integer getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
