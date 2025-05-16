package com.rodrigo.desafio2.senhalimpa;

import com.rodrigo.desafio2.cadastrousuario.SenhaLimpa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SenhalimpaTeste {

    @DisplayName("Só aceita senha com seis ou mais caracteres")
    @ParameterizedTest
    @CsvSource({
            "123456",
            "1234567",
            "123456789123456789"
    })
    void teste1 (String senhaLimpa) throws Exception{
        new SenhaLimpa(senhaLimpa);
    }

    @DisplayName("Só aceita senha com seis ou mais caracteres")
    @ParameterizedTest
    @CsvSource({
            "12345",
            "12"
    })
    void teste2 (String senhaLimpa) throws Exception{
        Assertions.assertThrows(IllegalAccessException.class, () ->
                new SenhaLimpa(senhaLimpa));
    }
}
