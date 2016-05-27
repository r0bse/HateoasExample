package com.businesskeeper.bkmstp.exchangerate.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.UUID;

/**
 * simple implementation of a country entity
 * there are more properties available within the api, but for demonstration purpose this is enough
 *
 * @author schroeder
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryEntity {

    private final String id;
    private final String name;
    private final String capital;
    private final String region;
    private final String population;

    // the following fields are within the provided json, but we won't need them
    private String[] altSpellings;
    private Integer relevance;
    private String subregion;
    private Map<String, String> translations;
    private String[] geoCoords;
    private String demonym;
    private Integer area;
    private Double gini;
    private String[] timezones;
    private String[] borders;
    private String nativename;
    private Integer[] callingCodes;
    private String[] topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private String[] currencies;
    private String[] languages;

    @JsonCreator
    public CountryEntity( @JsonProperty( "name" ) String name,
                          @JsonProperty( "capital" ) String capital,
                          @JsonProperty( "region" ) String region,
                          @JsonProperty( "population" ) String population ) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getPopulation() {
        return population;
    }
}
