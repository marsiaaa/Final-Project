//package com.sda.Final.Project;
//
//import com.sda.Final.Project.dto.UserDTO;
//import com.sda.Final.Project.entity.UserEntity;
//import com.sda.Final.Project.exception.BadRequestException;
//import com.sda.Final.Project.exception.NotFoundException;
//import com.sda.Final.Project.repository.UserRepository;
//import com.sda.Final.Project.service.UserService;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import javax.xml.validation.Validator;
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import static org.mockito.ArgumentMatchers.any;
//
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UserService userService;
//    private Validator validator;
//    private UserEntity userEntity;
//    private UserEntity userWithId;
//    private UserDTO userDTO;
//
//    @BeforeEach
//    public void setupUser() {
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
//        userDTO = createDummyValues();
//        userEntity = fromDTO(userDTO);
//        userWithId = fromDTO(userDTO);
//        userWithId.setId(1);
//    }
//
//    @Test
//    void testValidations() {
//        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
//        Assertions.assertTrue(violations.isEmpty());
//    }
//    @Test
//    void testValidations_name_null() {
//        userDTO.setName(null);
//        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
//        Assertions.assertFalse(violations.isEmpty());
//        Assertions.assertEquals(3, violations.size());
//    }
//
//
//    @Test
//    void test_save_pass() {
//        Mockito.when(userRepository.save(any())).thenReturn(userWithId);
//        Assertions.assertDoesNotThrow(() -> userService.save(userDTO));
//    }
//    @Test
//    @DisplayName("Book Exists")
//    void test_save_must_exception() {
//        Mockito.when(userRepository.findAllByName(userDTO.getName())).thenReturn(List.of(userWithId));
//        Assertions.assertThrows(BadRequestException.class, () -> userService.save(userDTO));
//    }
//
//    static UserDTO createDummyValues() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setName("test");
//        userDTO.setSurname("test");
//        userDTO.setFeedback("test");
//        userDTO.setDateCreated(LocalDate.now());
//        userDTO.setDateModified(LocalDate.now());
//        userDTO.setRating(3);
//        userDTO.setEmail("test");
//        userDTO.setPassword("password");
//        userDTO.setLocation("test");
//        return userDTO;
//    }
//    static UserEntity fromDTO(UserDTO userDTO) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(userEntity.getId());
//        userEntity.setName(userEntity.getName());
//        userEntity.setSurname(userEntity.getSurname());
//        userEntity.setEmail(userEntity.getEmail());
//        userEntity.setPassword(userEntity.getPassword());
//        userEntity.setDateCreated(userEntity.getDateCreated());
//        userEntity.setDateModified(userEntity.getDateModified());
//        userEntity.setLocation(userEntity.getLocation());
//        userEntity.setFeedback(userEntity.getFeedback());
//        userEntity.setRating(userEntity.getRating());
//        return userEntity;
//    }
//
//    @Test
//    @DisplayName("Update existing user")
//    void givenExistingBookDTO_whenUpdate_thenMustBeSaved() {
//        userDTO.setId(1);
//        userEntity.setId(1);
//        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(userEntity));
//        Assertions.assertDoesNotThrow(() -> userService.update(userDTO));
//    }
//
//    @Test
//    @DisplayName("Update existing user")
//    void givenNotExistingUserDTO_whenUpdate_thenExceptionMustBeThrown() {
//        userDTO.setId(3);
//        Mockito.when(userRepository.findById(userDTO.getId()))
//                .thenReturn(Optional.empty());
//        Assertions.assertThrows(NotFoundException.class, () -> userService.update(userDTO));
//    }
//
//
//
//    @Test
//    void givenNotExistingUserDTO_whenDelete_thenMustNotBeDeleted() {
//        Mockito.when(userRepository.findById(3))
//                .thenReturn(Optional.empty());
//        Assertions.assertThrows(NotFoundException.class, () ->userService.delete(3));
//    }
//
//    @Test
//    void givenExistingUserDTO_whenDeleted_thenMustBeDeleted(){
//        Mockito.when(userRepository.findById(1))
//                .thenReturn(Optional.of(userEntity));
//        Assertions.assertDoesNotThrow(()-> userService.delete(1));
//    }
//
//    static UserDTO createDummyUserDTO() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setName("Asgje e re nga fronti Perendimit");
//        return userDTO;
//    }
//    static UserEntity createDummyUserEntity() {
//        UserEntity userEntity1 = new UserEntity();
//        userEntity1.setName("Asgje e re nga fronti Perendimit");
//        return userEntity1;
//    }
//
//
//}
