package com.businesskeeper.bkmstp.exchangerate;

import com.businesskeeper.bkmstp.exchangerate.rest.resources.CountryResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author schroeder
 * @date 28. Apr 2016
 */
@Configuration
public class SpringConfig {

    @Bean
    @Scope("prototype")
    public CountryResource countryResource( Long id, String name, String capital, String region, String population ){

        return new CountryResource( id, name, capital, region, population);
    }
}
