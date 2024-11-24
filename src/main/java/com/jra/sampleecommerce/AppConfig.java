package com.jra.sampleecommerce;

import com.jra.sampleecommerce.security.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.Map;

import static com.jra.sampleecommerce.security.Constants.ENCODER_ID;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Supports other password encoding, a must for existing applications.
        // However, uses BCrypt for new passwords. This will allow to use new or future encoders
        Map<String, PasswordEncoder> encoders =
                Map.of(
                        ENCODER_ID,
                        new BCryptPasswordEncoder(),
                        "pbkdf2",
                        Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8(),
                        "scrypt",
                        SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8());
        return new DelegatingPasswordEncoder(ENCODER_ID, encoders);
    }

}
