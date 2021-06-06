package kodlamaio.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.cvImage.CloudinaryService;
import kodlamaio.hrms.core.cvImage.ImageService;
import org.modelmapper.ModelMapper;


@Configuration
public class Config {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}
	
	
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddilwthbu",
                "api_key", "182962136828711",
                "api_secret", "KiDvRH05pKXvBRgV_td9ln3y8yM"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryService();
    }
    
}
