package br.com.leadersofts.apioktastorage.auth.user.controller;

import br.com.leadersofts.apioktastorage.auth.user.domain.User;
import br.com.leadersofts.apioktastorage.auth.user.record.AuthenticationRecord;
import br.com.leadersofts.apioktastorage.auth.user.record.LoginResponseDTO;
import br.com.leadersofts.apioktastorage.auth.user.record.RegisterDTO;
import br.com.leadersofts.apioktastorage.auth.user.repository.UserRepository;
import br.com.leadersofts.apioktastorage.auth.user.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationRecord data) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.tokenService.generateToken( (User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid RegisterDTO payload) {

        if(Objects.nonNull(this.userRepository.findByLogin(payload.login()))) {
            return ResponseEntity.badRequest().build();
        }
        var encryptedPassword = new BCryptPasswordEncoder().encode(payload.password());
        var newUser = new User(payload.login(),encryptedPassword,payload.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
