//package net.parkguide.pgw.mapper;
//
//import net.parkguide.pgw.dto.ParkDto;
//import net.parkguide.pgw.dto.UserDto;
//import net.parkguide.pgw.entity.Park;
//import net.parkguide.pgw.entity.User;
//
//public class UserMapper {
//
//    public static UserDto mapToUserDto(User user) {
//        return new UserDto(
//                user.getUserName(),
//                user.getUserEmail(),
//                user.getUserPassword());
//    }
//
//    public static User mapToUser(UserDto userDto) {
//        return new User(
//                userDto.getUsername(),
//                userDto.getPassword(),
//                userDto.getEmail());
//    }
//}
