package com.jagan.crudApp.configuration;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@org.springframework.context.annotation.Configuration

public class CloudinaryConfiguration {
    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "doeo9qps6");
        config.put("api_key", "892982778347257");
        config.put("api_secret", "-xr5pMLgX2E_bdD8-DA99kOOqLE");

        return new Cloudinary(config);
    }
}
