package com.businesskeeper.bkmstp.exchangerate.rest.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author schroeder
 * @date 28. Apr 2016
 */
public class CountryResource extends ResourceSupport {


    @JsonProperty
    public final Long id;
    @JsonProperty
    public final String name;
    @JsonProperty
    public final String capital;
    @JsonProperty
    public final String region;
    @JsonProperty
    public final String population;

    @JsonCreator
    public CountryResource( @JsonProperty( "id" ) Long id,
                            @JsonProperty( "name" ) String name,
                            @JsonProperty( "capital" ) String capital,
                            @JsonProperty( "region" ) String region,
                            @JsonProperty( "population" ) String population ) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
    }

}
