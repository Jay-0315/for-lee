package com.kakeibo.domain.auth.repository;
import com.kakeibo.domain.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository; //기본 crud 자동 제공
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //find user by email(이메일로 유저 조회)
    Optional<User> findByEmail(String email);

    //check if email exists(이메일 중복 체크)
    boolean existsByEmail(String email);
}
