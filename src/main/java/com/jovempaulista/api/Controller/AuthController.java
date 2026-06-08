package com.jovempaulista.api.Controller;

import com.jovempaulista.api.dto.LoginRequestDTO;
import com.jovempaulista.api.dto.LoginResponseDTO;
import com.jovempaulista.api.dto.RegisterRequestDTO;
import com.jovempaulista.api.model.Usuario;
import com.jovempaulista.api.repository.usuarioRepository;
import com.jovempaulista.api.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private usuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já cadastrado!");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setRole("ROLE_USER");
        usuario.setAtivo(true);
        usuario.setDataCadastro(LocalDate.now());

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            return ResponseEntity.badRequest().build();
        }

        String token = jwtService.gerarToken(usuario.getEmail());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}