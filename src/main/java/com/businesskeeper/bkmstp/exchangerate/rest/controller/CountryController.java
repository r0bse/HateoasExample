package com.businesskeeper.bkmstp.exchangerate.rest.controller;

import com.businesskeeper.bkmstp.exchangerate.domain.CountryEntity;
import com.businesskeeper.bkmstp.exchangerate.rest.assembler.CountryResourceAssembler;
import com.businesskeeper.bkmstp.exchangerate.rest.resources.CountryResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

/**
 * @author schroeder
 * @date 28. Apr 2016
 */
@RestController
@RequestMapping( "/countries" )
public class CountryController {

    @Autowired
    private CountryResourceAssembler countryResourceAssembler;


    /**
     *
     * @return
     * @throws IOException
     */
    @RequestMapping( method = RequestMethod.GET,
                     produces = { MediaType.APPLICATION_JSON_VALUE } )
    public Collection<CountryResource> findAll() throws IOException {

        return countryResourceAssembler.toResources( );
    }


    /**
     *
     * @param countryname
     * @return
     * @throws IOException
     */
    @RequestMapping( value = "/{countryname}",
                     method = RequestMethod.GET,
                     produces = { MediaType.APPLICATION_JSON_VALUE } )
    public CountryResource findOne( @PathVariable( "countryname" ) String countryname ) throws IOException {


        CountryResource resource = countryResourceAssembler.toResource( countryname );

        return resource;
    }

}
