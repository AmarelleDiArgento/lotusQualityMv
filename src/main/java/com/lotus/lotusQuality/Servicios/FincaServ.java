/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Servicios;

import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.Tabs.Finca;
import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.iFinca;
import java.util.List;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author freya
 */
@Path("fincas")
public class FincaServ {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allFinca() {
        iFinca iF = new iFinca();

        List<Finca> lf = iF.all();
        return Response.ok(lf).header("Access-Control-Allow-Origin", "*").build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response oneIdFinca(@PathParam("id") long id) {
        //  long ID = id;
        iFinca iF = new iFinca();
        Finca finca = iF.oneId(id);
        if (finca != null) {
            return Response.ok(finca).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFinca(@PathParam("id") long id) {
        //  long ID = id;
        iFinca iF = new iFinca();
        Finca finca = iF.oneId(id);
        if (finca != null) {
            iF.delete(id);
            iF.closeSession();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertFinca(Finca c) {
        //  long ID = id;

        iFinca iF = new iFinca();
        iF.insert(c);
        iF.closeSession();
        return Response.status(Response.Status.CREATED).entity(c).build();

    }

}
