package com.gk.usermanagement.service;

import com.gk.usermanagement.entity.Address;
import com.gk.usermanagement.entity.ProfessionalDetail;
import com.gk.usermanagement.entity.User;
import com.gk.usermanagement.entity.UserProfile;
import com.gk.usermanagement.model.*;
import com.gk.usermanagement.repository.AddressRepository;
import com.gk.usermanagement.repository.ProfessionalDetailRepository;
import com.gk.usermanagement.repository.UserProfileRepository;
import com.gk.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    /*@Override
    public CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO) {

        *//*Address address=new Address();
        address.setLine1(createUserRequestDTO.getAddress().getLine1());
        address.setLine2(createUserRequestDTO.getAddress().getLine2());

        Address savedAdrees=addressRepository.save(address);*//*


        User user=new User();
        user.setFirstName(createUserRequestDTO.getFirstName());
        user.setLastName(createUserRequestDTO.getLastName());
        user.setGmail(createUserRequestDTO.getGmail());
        user.setPhoneNumber(createUserRequestDTO.getPhoneNumber());

        com.gk.usermanagement.model.Address modelAddress=new com.gk.usermanagement.model.Address();
        modelAddress=createUserRequestDTO.getAddress();
        Address address=new Address();
        address.setLine1(createUserRequestDTO.getAddress().getLine1());
        address.setLine2(createUserRequestDTO.getAddress().getLine2());
        address.setCity(createUserRequestDTO.getAddress().getCity());
        address.setState(createUserRequestDTO.getAddress().getState());
        address.setCountry(createUserRequestDTO.getAddress().getCountry());
        address.setPinCode(createUserRequestDTO.getAddress().getPinCode());

        user.setAddress(address);
        User savedEntity=userRepository.save(user);


        return null;
    }*/


    //@Override
    /*public CreateUserResponseDTO getUser(Long id) {
        Optional<User> optionalUser=userRepository.findById(id);
        User user=null;
        if(optionalUser.isEmpty()){
            throw new RuntimeException(" given id is not available");
        }
        else{
            user= optionalUser.get();
        }
        CreateUserResponseDTO responseDTO=new CreateUserResponseDTO();
        responseDTO.setUser_id(user.getUserId());
        responseDTO.setFirstName(user.getFirstName());
        responseDTO.setLastName(user.getLastName());
        responseDTO.setGmail(user.getGmail());
        responseDTO.setPhoneNumber(user.getPhoneNumber());
        com.gk.usermanagement.model.Address address=new com.gk.usermanagement.model.Address();
        address.setLine1(user.getAddress().getLine1());
        address.setLine2(user.getAddress().getLine2());
        address.setCity(user.getAddress().getCity());
        address.setState(user.getAddress().getState());
        address.setCountry(user.getAddress().getCountry());
        address.setPinCode(user.getAddress().getPinCode());
        responseDTO.setAddress(address);
        return responseDTO;
    }*/

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ProfessionalDetailRepository professionalDetailRepository;

    @Override
    public CreateUserResponseDTO createUserWithProfile(CreateUserRequestDTO requestDTO) {
        // create user entity
        User user = new User();
        user.setPassWord(requestDTO.getPassWord());
        user.setGmail(requestDTO.getGmail());
        user.setPhoneNumber(requestDTO.getPhoneNumber());
        //saving user entity
        User savedUserEntity=userRepository.save(user);
        List<ProfessionalDetail> professionalDetails=new ArrayList<>();
        for(ProfessionalDetailsDTO professionalDetailsDTO :requestDTO.getProfessionalDetailsDTOS()){
            ProfessionalDetail professionalDetail=new ProfessionalDetail();
            professionalDetail.setBlockNumber(professionalDetailsDTO.getBlockNumber());
            professionalDetail.setCompanyName(professionalDetailsDTO.getCompanyName());
            professionalDetail.setLocation(professionalDetailsDTO.getLocation());
            professionalDetail.setIsActive(professionalDetailsDTO.getIsActive());
            professionalDetail.setUser(savedUserEntity);
            professionalDetails.add(professionalDetail);
        }
        List<ProfessionalDetail> savedProfessionalDetails=professionalDetailRepository.saveAll(professionalDetails);

        //create userProfile entity
        UserProfile userProfile = new UserProfile();
        userProfile.setPrefix(requestDTO.getUserProfile().getPrefix());
        userProfile.setFirstName(requestDTO.getUserProfile().getFirstName());
        userProfile.setLastName(requestDTO.getUserProfile().getLastName());
        userProfile.setDob(requestDTO.getUserProfile().getDob());
        userProfile.setGender(requestDTO.getUserProfile().getGender());
        userProfile.setHeight(requestDTO.getUserProfile().getHeight());
        userProfile.setWeight(requestDTO.getUserProfile().getWeight());
        userProfile.setNationality(requestDTO.getUserProfile().getNationality());
        // assigning user_id to userProfile Entity
        userProfile.setUser(savedUserEntity);
        //saving userprofile entiti with respective userId
        UserProfile savedUserProfileEntity = userProfileRepository.save(userProfile);

        Set<Address> addresses = new HashSet<>();
        for (AddressDTO addressDTO : requestDTO.getUserProfile().getAddresses()) {
            // creating address entity
            Address address = new Address();
            address.setType(addressDTO.getType());
            address.setLine1(addressDTO.getLine1());
            address.setLine2(addressDTO.getLine2());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setCountry(addressDTO.getCountry());
            address.setPinCode(addressDTO.getPinCode());
            //setting userProfile against address entity
            address.setUserProfile(savedUserProfileEntity);
            addresses.add(address);
        }
        // saving address entities with userEntity
        List<Address> savedAddressEntity = addressRepository.saveAll(addresses);

        // mapping saveUserEntity and savedAddressEntity to ResponseDTO

        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
        //mapping saveUserEntity details tooooooo  ResponseEntity ==> User
        responseDTO.setUser_id(savedUserEntity.getUserId());
        responseDTO.setPassWord(savedUserEntity.getPassWord());
        responseDTO.setGmail(savedUserEntity.getGmail());
        responseDTO.setPhoneNumber(savedUserEntity.getPhoneNumber());

        List<ProfessionalDetailsDTO> professionalDetailsDTOS=new ArrayList<>();
        for(ProfessionalDetail professionalDetail:savedProfessionalDetails){
            ProfessionalDetailsDTO professionalDetailsDTO=new ProfessionalDetailsDTO();
            professionalDetailsDTO.setBlockNumber(professionalDetail.getBlockNumber());
            professionalDetailsDTO.setCompanyName(professionalDetail.getCompanyName());
            professionalDetailsDTO.setLocation(professionalDetail.getLocation());
            professionalDetailsDTO.setIsActive(professionalDetail.getIsActive());
            professionalDetailsDTOS.add(professionalDetailsDTO);
        }
        responseDTO.setProficinalDetailsDTOs(professionalDetailsDTOS);

        //mapping savedUserProfileEntity details tooooo ResponseEntity ==> userProfileDTO
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setFirstName(savedUserProfileEntity.getFirstName());
        userProfileDTO.setLastName(savedUserProfileEntity.getLastName());
        userProfileDTO.setPrefix(savedUserProfileEntity.getPrefix());
        userProfileDTO.setDob(savedUserProfileEntity.getDob());
        userProfileDTO.setWeight(savedUserProfileEntity.getWeight());
        userProfileDTO.setHeight(savedUserProfileEntity.getHeight());
        userProfileDTO.setGender(savedUserProfileEntity.getGender());
        userProfileDTO.setNationality(savedUserProfileEntity.getNationality());
        //mapping savedAddressEntity List toooooooooo ResponseEntity ==>> userProfileDTO ==> AddressDTO
        List<AddressDTO> addressDTOList = new ArrayList<>();
        for (Address address : savedAddressEntity) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setType(address.getType());
            addressDTO.setLine1(address.getLine1());
            addressDTO.setLine2(address.getLine2());
            addressDTO.setCity(address.getCity());
            addressDTO.setState(address.getState());
            addressDTO.setCountry(address.getCountry());
            addressDTO.setPinCode(address.getPinCode());
            addressDTOList.add(addressDTO);
        }
        userProfileDTO.setAddresses(addressDTOList);
        responseDTO.setUserProfile(userProfileDTO);

        return responseDTO;
    }

    @Override
    public CreateUserResponseDTO getUserWithProfile(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isEmpty()) {
            throw new RuntimeException(" given id is not available");
        } else {
            user = optionalUser.get();
        }
        // setting model with entity data
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
        responseDTO.setUser_id(user.getUserId());
        responseDTO.setPassWord(user.getPassWord());
        responseDTO.setGmail(user.getGmail());
        responseDTO.setPhoneNumber(user.getPhoneNumber());

        List<ProfessionalDetailsDTO> professionalDetailsDTOS=new ArrayList<>();
        for(ProfessionalDetail professionalDetail:user.getProfessionalDetails()){
            ProfessionalDetailsDTO professionalDetailsDTO=new ProfessionalDetailsDTO();
            professionalDetailsDTO.setBlockNumber(professionalDetail.getBlockNumber());
            professionalDetailsDTO.setLocation(professionalDetail.getLocation());
            professionalDetailsDTO.setCompanyName(professionalDetail.getCompanyName());
            professionalDetailsDTO.setIsActive(professionalDetail.getIsActive());
            professionalDetailsDTOS.add(professionalDetailsDTO);
        }
        responseDTO.setProficinalDetailsDTOs(professionalDetailsDTOS);
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setFirstName(user.getUserProfile().getFirstName());
        userProfileDTO.setLastName(user.getUserProfile().getLastName());
        userProfileDTO.setPrefix(user.getUserProfile().getPrefix());
        userProfileDTO.setDob(user.getUserProfile().getDob());
        userProfileDTO.setWeight(user.getUserProfile().getWeight());
        userProfileDTO.setHeight(user.getUserProfile().getHeight());
        userProfileDTO.setGender(user.getUserProfile().getGender());
        userProfileDTO.setNationality(user.getUserProfile().getNationality());

        List<AddressDTO> addressDTOList = new ArrayList<>();
        for (Address address : user.getUserProfile().getAddresses()) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setType(address.getType());
            addressDTO.setLine1(address.getLine1());
            addressDTO.setLine2(address.getLine2());
            addressDTO.setCity(address.getCity());
            addressDTO.setState(address.getState());
            addressDTO.setCountry(address.getCountry());
            addressDTO.setPinCode(address.getPinCode());
            addressDTOList.add(addressDTO);
        }
        userProfileDTO.getAddresses().addAll(addressDTOList);
        responseDTO.setUserProfile(userProfileDTO);
        return responseDTO;
    }
}

