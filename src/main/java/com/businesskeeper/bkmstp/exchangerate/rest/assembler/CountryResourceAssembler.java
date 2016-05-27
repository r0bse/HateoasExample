package com.businesskeeper.bkmstp.exchangerate.rest.assembler;

import com.businesskeeper.bkmstp.exchangerate.domain.CountryEntity;
import com.businesskeeper.bkmstp.exchangerate.rest.controller.CountryController;
import com.businesskeeper.bkmstp.exchangerate.rest.resources.CountryResource;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Assemble Entities into resources
 *
 * @author schroeder
 */
@Service
public class CountryResourceAssembler extends ResourceAssemblerSupport<CountryEntity, CountryResource> {

    @Autowired
    protected BeanFactory beanFactory;

    private final ObjectMapper mapper = new ObjectMapper();
    private final static String apiURL = "http://restcountries.eu/rest/v1/";
    private final Map<String, CountryResource> countryMap;

    /**
     * constructor
     * call super and tell him the controller for this assembler with associated resource
     */
    public CountryResourceAssembler() {

        super( CountryController.class, CountryResource.class );

        countryMap = new HashMap<>(  );
    }

    /**
     * @param countryname
     * @return
     */
    public CountryResource toResource( String countryname ) throws IOException {

        getOrCreateResources();
        return countryMap.get( countryname );
    }

    public Collection<CountryResource> toResources( Object... parameter ) throws IOException {

        getOrCreateResources();
        return countryMap.values();
    }

    /**
     * create and fill map of countries if it is not filled yet
     *
     * @return
     */
    private Map<String, CountryResource> getOrCreateResources( ) throws IOException {

        //quick and dirty: creating all needed resource objects
        if ( countryMap.isEmpty() ) {

            Collection<CountryEntity> entities = Arrays.asList( mapper.readValue( new URL( apiURL + "all" ), CountryEntity[].class ) );
            Long key = 0L;
            for ( CountryEntity entry : entities) {

                CountryResource resource = new CountryResource( key,
                                                                entry.getName(),
                                                                entry.getCapital(),
                                                                entry.getRegion(),
                                                                entry.getPopulation());

                ControllerLinkBuilder builder = linkTo( CountryController.class, key );
                builder = builder.slash( entry.getName() );
                Link link = builder.withSelfRel();
                resource.add( link );

                countryMap.put( entry.getName(), resource );
                key = key + 1L;
            }
        }

        return countryMap;
    }

    @Override
    public CountryResource toResource( CountryEntity entity ) {
        throw new NotImplementedException();
    }
}
