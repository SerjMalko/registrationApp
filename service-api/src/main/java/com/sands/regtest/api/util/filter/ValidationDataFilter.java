package com.sands.regtest.api.util.filter;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.io.*;

/**
 * REST Logging request filter
 *
 * Created by ava on 09.09.2015.
 */
@Provider
@ValidationData
public class ValidationDataFilter implements ContainerRequestFilter {


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Object ob = requestContext.getEntityStream();
        Object st = IOUtils.toString(requestContext.getEntityStream(), "UTF-8");
        System.out.println("st - " + st);




    }

}
