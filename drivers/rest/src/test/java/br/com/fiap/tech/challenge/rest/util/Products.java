package br.com.fiap.tech.challenge.rest.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Products {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}