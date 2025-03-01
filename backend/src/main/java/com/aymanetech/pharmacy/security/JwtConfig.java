package com.aymanetech.pharmacy.security;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.SecretKey;

@ConfigurationProperties("app.security.jwt")
public record JwtConfig(
        String secretKey,
        long expirationTime,
        String algorithm
) {

    public SecretKey getSecretKey() {
        return new OctetSequenceKey.Builder(secretKey.getBytes())
                .algorithm(new JWSAlgorithm(algorithm))
                .build()
                .toSecretKey();
    }

    public JWSAlgorithm getAlgorithm() {
        return new JWSAlgorithm(algorithm);
    }
}
