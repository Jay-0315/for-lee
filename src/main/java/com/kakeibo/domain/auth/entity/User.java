package com.kakeibo.domain.auth.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //email address
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    //password
    @Column(nullable = false, length = 255)
    private String password;

    //user name
    @Column(nullable = false, length = 50)
    private String name;

    //created at
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    //DB 저장 직전 자동으로 createdAt 설정
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    //factory method (객체 생성 통일)
    public static User create(String email, String password, String name) {
        User user = new User();
        user.email = email;
        user.password = password;
        user.name = name;
        return user;
    }
}
