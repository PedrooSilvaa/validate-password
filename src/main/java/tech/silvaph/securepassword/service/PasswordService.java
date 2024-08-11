package tech.silvaph.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validatePass(String pass){
        List<String> failures = new ArrayList<>();

        validateLength(pass, failures);
        validateUppercase(pass, failures);
        validateLowercase(pass, failures);
        validateNumber(pass, failures);
        validateSpecialCharacter(pass, failures);
        return failures;
    }


    private void validateLength(String pass, List<String> failures) {
        //validando se a senha não é nula e nem menor que 8 caracteres
        if (pass != null && pass.length() < 8){
            failures.add("A senha deve possuir pelo menos 8 caracteres.");
        }
    }

    private void validateUppercase(String pass, List<String> failures) {
        // .* - qualquer palavra antes ou depois
        //[A-Z] - validando se existe alguma maiúscula dentro
        if(!Pattern.matches(".*[A-Z].*", pass)){
            failures.add("A senha deve possuir uma letra maiúscula.");
        }
    }

    private void validateLowercase(String pass, List<String> failures) {
        // .* - qualquer palavra antes ou depois
        //[a-z] - validando se existe alguma minúscula dentro
        if(!Pattern.matches(".*[a-z].*", pass)){
            failures.add("A senha deve possuir uma letra minúscula.");
        }
    }

    private void validateNumber(String pass, List<String> failures) {
        // [0-9] se existe algum numero
        if(!Pattern.matches(".*[0-9].*", pass)){
            failures.add("A senha deve possuir um digito numérico.");
        }
    }

    private void validateSpecialCharacter(String pass, List<String> failures) {
        // \\w todas a letras q estão no alfabeto normal
        // \\W todas as letras fora do alfabeto normal ou seja caracteres especiais
        if(!Pattern.matches(".*[\\W].*", pass)){
            failures.add("A senha deve possuir um caractere especial (e.g, !@#$%).");
        }

    }

}
