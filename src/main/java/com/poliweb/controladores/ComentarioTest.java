package com.poliweb.controladores;

import com.poliweb.modelo.Comentario;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ComentarioTest {
    @ParameterizedTest
    @MethodSource("mensajeProvider")
    void testCrearComentarioConMensajeVacio(String autor, String mensaje) {
        Comentario comentario = new Comentario(autor, mensaje);
        assertThrows(IllegalArgumentException.class, () -> {
            comentario.setMensaje("");
        });
    }

    static Stream<Arguments> mensajeProvider() {
        return Stream.of(
                Arguments.of("Usuario1", ""),
                Arguments.of("Usuario2", null)
        );
    }

}
