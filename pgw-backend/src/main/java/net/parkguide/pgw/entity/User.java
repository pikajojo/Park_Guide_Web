package net.parkguide.pgw.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name", nullable=false)

    public String userName;

    @Column(name = "user_password", nullable=false)
    public String userPassword;

    @Column(name = "user_email", nullable=false,  unique=true)
    public String userEmail;

    @Column(name = "user_avatar_path")  // Store User Avatar Path
    private String userAvatarPath;

    private boolean enabled = true;


    public User(String username, String password, String email) {
    }
}
