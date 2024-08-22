//package net.parkguide.pgw.controller;
//
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import net.parkguide.pgw.dto.UserDto;
//import net.parkguide.pgw.entity.User;
//import net.parkguide.pgw.exception.ResourceNotFoundException;
//import net.parkguide.pgw.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.HashMap;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/api/users")
//public class UserController {
//
//
//    private final UserService userService;
//
//
//    @PostMapping("/{userId}/avatar")
//    public ResponseEntity<?> uploadUserAvatar(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
//        try {
//            userService.updateUserAvatar(userId, file);
//            return ResponseEntity.ok("User avatar updated successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading avatar: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/{userId}/avatar")
//    public ResponseEntity<byte[]> getUserAvatar(@PathVariable Long userId) {
//        byte[] userAvatar = userService.getUserAvatar(userId);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG) // 这里根据图片格式设置
//                .body(userAvatar);
//    }
//
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userRegistrationDTO) {
//        try {
//            // 调用 UserService 处理注册逻辑
//            userService.registerUser(userRegistrationDTO);
//            return ResponseEntity.ok("User registered successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
//        try {
//            UserDto user = userService.loginUser(username, password);
//            return ResponseEntity.ok(user);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}
