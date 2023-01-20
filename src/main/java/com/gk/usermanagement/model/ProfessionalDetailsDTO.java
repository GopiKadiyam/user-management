package com.gk.usermanagement.model;

public class ProfessionalDetailsDTO {
    private String employeeCode;
    private Integer blockNumber;
    private String companyName;
    private String location;
    private String isActive;

    public ProfessionalDetailsDTO() {
    }

    public ProfessionalDetailsDTO(String employeeCode, Integer blockNumber, String companyName, String location, String isActive) {
        this.employeeCode = employeeCode;
        this.blockNumber = blockNumber;
        this.companyName = companyName;
        this.location = location;
        this.isActive = isActive;
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
}
