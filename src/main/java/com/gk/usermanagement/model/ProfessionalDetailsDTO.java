package com.gk.usermanagement.model;

public class ProfessionalDetailsDTO {
    private Long id;
    private Integer blockNumber;
    private String companyName;
    private String location;
    private String isActive;

    public ProfessionalDetailsDTO() {
    }

    public ProfessionalDetailsDTO(Long id, Integer blockNumber, String companyName, String location, String isActive) {
        this.id = id;
        this.blockNumber = blockNumber;
        this.companyName = companyName;
        this.location = location;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
