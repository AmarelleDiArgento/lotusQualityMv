/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Servicios;

import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.Tabs.Postcosecha;
import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.iPostcosecha;
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
@Path("postcosechas")
public class PostcosechaServ {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allPostcosecha() {
        iPostcosecha iP = new iPostcosecha();

        List<Postcosecha> lp = iP.all();
        return Response.ok(lp).header("Access-Control-Allow-Origin", "*").build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response oneIdPostcosecha(@PathParam("id") long id) {
        //  long ID = id;
        iPostcosecha iP = new iPostcosecha();
        Postcosecha postcosecha = iP.oneId(id);
        if (postcosecha != null) {
            return Response.ok(postcosecha).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePostcosecha(@PathParam("id") long id) {
        //  long ID = id;
        iPostcosecha iP = new iPostcosecha();
        Postcosecha postcosecha = iP.oneId(id);
        if (postcosecha != null) {
            iP.delete(id);
            iP.closeSession();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPostcosecha(Postcosecha c) {
        //  long ID = id;

        iPostcosecha iP = new iPostcosecha();
        iP.insert(c);
        iP.closeSession();
        return Response.status(Response.Status.CREATED).entity(c).build();

    }

}
