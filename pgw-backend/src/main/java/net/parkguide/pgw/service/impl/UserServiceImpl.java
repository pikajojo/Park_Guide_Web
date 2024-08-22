//package net.parkguide.pgw.service.impl;
//
//
//import io.micrometer.common.util.StringUtils;
//import net.parkguide.pgw.dto.UserDto;
//import net.parkguide.pgw.entity.Park;
//import net.parkguide.pgw.entity.User;
//import net.parkguide.pgw.exception.ResourceNotFoundException;
//import net.parkguide.pgw.mapper.UserMapper;
//import net.parkguide.pgw.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Service
//public class UserServiceImpl {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//
//    private final String uploadDir = "uploads/avatars/";
//
//
//    public void updateUserAvatar(Long userId, MultipartFile file) throws IOException {
//        // 检查目录是否存在，不存在则创建
//        File directory = new File(uploadDir);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//
//        // 保存文件到指定目录
//        String filename = file.getOriginalFilename();
//        String filepath = uploadDir + filename;
//        File dest = new File(filepath);
//        file.transferTo(dest);
//
//        // 更新用户头像URL
//        String fileUrl = "/uploads/avatars/" + filename;
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        user.setUserAvatarPath(fileUrl);
//        userRepository.save(user);
//    }
//
//
//    // 获取用户头像路径并转换为字节数组
//    public byte[] getUserAvatar(Long userId) throws IOException {
//        UserDto userDto = getUserById(userId);
//        String avatarPath = UserMapper.mapToUser(userDto).getUserAvatarPath();  // 从数据库中获取头像的相对路径
//
//        if (StringUtils.isEmpty(avatarPath)) {
//            throw new RuntimeException("User avatar not found");
//        }
//
//        Path path = Paths.get(uploadDir + avatarPath);
//        if (!Files.exists(path)) {
//            throw new RuntimeException("File not found");
//        }
//
//        return Files.readAllBytes(path);
//    }
//
//    private UserDto getUserById(Long userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("Park is not found with given id: " + userId));
//        return UserMapper.mapToUserDto(user);
//    }
//
//
//    public void registerUser(UserDto userDto) {
//        // 检查用户是否已存在
//        if (userRepository.existsByUsername(userDto.getUsername())) {
//            throw new RuntimeException("Username is already taken");
//        }
//
//        if (userRepository.existsByEmail(userDto.getEmail())) {
//            throw new RuntimeException("Email is already registered");
//        }
//
//        User user = new User();
//        user.setUserName(userDto.getUsername());
//        user.setUserPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setUserEmail(userDto.getEmail());
//        user.setEnabled(true);
//
//        // 使用密码编码器加密密码
//        user.setUserPassword((passwordEncoder.encode((userDto.getPassword()))));
//
//        // 保存用户到数据库
//        userRepository.save(user);
//    }
//
//    public UserDto loginUser(String username, String password) {
//        User user = userRepository.findByUsername(username);
//        if (user == null || !passwordEncoder.matches(password, user.getUserPassword())) {
//            throw new RuntimeException("Invalid username or password");
//        }
//        return UserMapper.mapToUserDto(user);
//    }
//}
//
