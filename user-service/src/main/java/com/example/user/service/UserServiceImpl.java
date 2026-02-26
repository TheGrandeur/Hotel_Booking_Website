package com.example.user.service;

import com.example.user.dto.UserRequestDTO;
import com.example.user.dto.UserResponseDTO;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository,
                           RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.modelMapper = new ModelMapper();
    }

    // ✅ CREATE USER
    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {

        User user = modelMapper.map(request, User.class);
        User saved = userRepository.save(user);

        return convertToResponse(saved);
    }

    // ✅ GET ALL USERS
    @Override
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    // ✅ GET USER BY ID
    @Override
    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        return convertToResponse(user);
    }

    // ✅ UPDATE USER
    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        User updated = userRepository.save(user);

        return convertToResponse(updated);
    }

    // ✅ DELETE USER
    @Override
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }

    // ✅ CALL HOTEL SERVICE (INTER-SERVICE COMMUNICATION)
    @Override
    public Object getAllHotelsFromHotelService() {

        String hotelServiceUrl = "http://localhost:8081/api/hotels";

        return restTemplate.getForObject(hotelServiceUrl, Object.class);
    }

    // ✅ Helper Method
    private UserResponseDTO convertToResponse(User user) {

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPhone()
        );
    }
}