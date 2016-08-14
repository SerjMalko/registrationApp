package com.sands.regtest.api.rest;

import com.sands.regtest.api.util.filter.ValidData;
import com.sands.regtest.api.util.filter.ValidationData;
import com.sands.regtest.core.beanl.IClientServiceBean;
import com.sands.regtest.data.req.EmailValidationRequest;
import com.sands.regtest.data.req.RegistrationRequest;
import com.sands.regtest.data.resp.RegistrationResponse;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Service for registration
 */
@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManagedBean
public class ClientService {

    @Inject
    private IClientServiceBean clientServiceBean;


    @Path("/registration")
    @POST
    public Response registration(RegistrationRequest request) {
        return clientServiceBean.registration(request);
    }

    @Path("/checkEmail/{secureCode}")
    @GET
    public Response registration(@PathParam("secureCode") String secureCode) {
        return clientServiceBean.checkEmail(secureCode);
    }
}
