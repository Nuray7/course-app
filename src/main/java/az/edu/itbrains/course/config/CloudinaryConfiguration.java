package az.edu.itbrains.course.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfiguration {



    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgmr5epeq",
                "api_key", "512918482534671",
                "api_secret", "KwvLKp_CsUQw5Vw3YBFoMnMG__w"));
    }


}
