package com.github.thamirestissot.sw_devops_test.controller;


import com.github.thamirestissot.sw_devops_test.service.Processor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationPath("/")
public class Metrics extends Application {
    @Autowired
    private Processor processor;

    @GET
    @Path("laaa/health")
    public Response health() {
        try{
            return Response.status(200).build();
        }catch (Exception e){
            return Response.status(500).build();
        }
    }

    @POST
    @Path("laar/ingest")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response ingestLogs(String str) {
        processor.record(str);
        return Response.status(200).build();
    }

//    @GET
//    @Produces("application/json")
//    @Path("laa/metrics")
//    public Response listPrices() throws RuntimeException {
////        Map<String, Double> validVehiclesNamesWithRate = (Map<String, Double>) service.getVehicles().stream().collect(Collectors.toMap(key -> key.getClass().getSimpleName(), Vehicle::getTollPrice));
////        return Response.ok(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(validVehiclesNamesWithRate)).build();
//    }
}