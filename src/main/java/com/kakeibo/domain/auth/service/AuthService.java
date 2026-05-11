package com.kakeibo.domain.auth.service;
import com.kakeibo.domain.auth.dto.LoginRequest;
import com.kakeibo.domain.auth.dto.LoginResponse;
import com.kakeibo.domain.auth.dto.RegisterRequest;
import com.kakeibo.domain.auth.entity.User;
import com.kakeibo.domain.auth.repository.UserRepository;
import com.kakeibo.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void register(RegisterRequest request) {

        //Check email duplication
        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다");
        }

        //Encrypt password
        String encodedPassword = passwordEncoder.encode(request.password());

        //Create user
        User user = User.create(
            request.email(),
            encodedPassword,
            request.name()
        );

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {

        //Find user
        User user = userRepository.findByEmail(request.email())
            .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다"));

        //Verify password
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다");
        }

        //\Generate JWT token
        String token = jwtTokenProvider.generateToken(user.getEmail());

        return new LoginResponse(token, user.getName());
    }
}