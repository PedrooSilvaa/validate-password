package tech.silvaph.securepassword.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.silvaph.securepassword.service.PasswordService;

@RestController
public class ApiController {

    private PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyRequest bodyRequest){

        var failures = passwordService.validatePass(bodyRequest.password());

        if(failures.isEmpty()){
        return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }

}
