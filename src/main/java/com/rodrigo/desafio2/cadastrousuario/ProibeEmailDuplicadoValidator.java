package com.rodrigo.desafio2.cadastrousuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ProibeEmailDuplicadoValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoUsuarioRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        NovoUsuarioRequest request = (NovoUsuarioRequest) target;
        Optional<Usuario> possivelUsuario = usuarioRepository.findByEmail(request.getEmail());
        if (possivelUsuario.isPresent()){
            errors.rejectValue("email", null, "este email já existe");
        }
    }
}
