/*
 * This document set is the property of GTECH Corporation, Providence,
 * Rhode Island, and contains confidential and trade secret information.
 * It cannot be transferred from the custody or control of GTECH except as
 * authorized in writing by an officer of GTECH. Neither this item nor
 * the information it contains can be used, transferred, reproduced, published,
 * or disclosed, in whole or in part, directly or indirectly, except as
 * expressly authorized by an officer of GTECH, pursuant to written agreement.
 *
 * Copyright 2015 GTECH Corporation. All Rights Reserved.
 */
package hello;

import countries.wsdl.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {

    private final CountriesClient countriesClient;

    @Autowired
    public CountriesController(CountriesClient countriesClient) {
        this.countriesClient = countriesClient;
    }

    @RequestMapping("/countries/{name}")
    public Country getCountry(@PathVariable("name") String name){
        return countriesClient.getCountry(name);
    }
}
