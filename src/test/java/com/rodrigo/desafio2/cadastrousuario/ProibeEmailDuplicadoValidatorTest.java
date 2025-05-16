package com.rodrigo.desafio2.cadastrousuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;
import java.util.stream.Stream;

class ProibeEmailDuplicadoValidatorTest {
    @DisplayName("Deveria lidar com email duplicado")
    @ParameterizedTest
    @MethodSource("geradorTeste1")
    void teste1(Optional<Usuario> possivelUsuario, boolean esperando) throws Exception{
        UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepository.class);
        ProibeEmailDuplicadoValidator validador = new ProibeEmailDuplicadoValidator(usuarioRepository);
        Object target = new NovoUsuarioRequest("email@gmail.com", "senhaa");
        Errors errors = new BeanPropertyBindingResult(target, "teste");
        Mockito.when(usuarioRepository.findByEmail("email@gmail.com"))
                .thenReturn(possivelUsuario);
        validador.validate(target, errors);
        Assertions.assertEquals(esperando, errors.hasFieldErrors("email"));
    }
    private static Stream<Arguments> geradorTeste1(){
        Optional<Usuario> usuario = Optional.of(new Usuario("email@gmail.com",
                new SenhaLimpa("senhaa")));
        return Stream.of(Arguments.of(usuario, true),
                Arguments.of(Optional.empty(), false));
    }
}