package fr.insa.msclient.controllers;

import fr.insa.msclient.model.dto.GenerateTokenDTO;
import fr.insa.msclient.model.dto.UserCredentials;
import fr.insa.msclient.model.dto.UserDTO;
import fr.insa.msclient.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ms-client/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity addNewUser(@RequestBody UserDTO userDTO){
        authService.registerUser(userDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/login")
    public ResponseEntity<GenerateTokenDTO> getToken(@RequestBody UserCredentials userCredentials){
        GenerateTokenDTO generateTokenDTO = new GenerateTokenDTO(userCredentials.email(), authService.generateToken(userCredentials.email(), userCredentials.password()));
        return new ResponseEntity<>(generateTokenDTO, HttpStatus.OK);
    }

    @GetMapping("/valide-token")
    public String validateToken(@RequestParam("token") String token){
        return authService.validateToken(token);
    }
}
