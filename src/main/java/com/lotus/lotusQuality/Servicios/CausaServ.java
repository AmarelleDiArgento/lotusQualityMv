/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Servicios;

import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.Tabs.Causa;
import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.iCausa;
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
@Path("causas")
public class CausaServ {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allCausa() {
        iCausa iC = new iCausa();

        List<Causa> lc = iC.all();

        return Response.ok(lc).header("Access-Control-Allow-Origin", "*").build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response oneIdCausa(@PathParam("id") long id) {
        //  long ID = id;
        iCausa iC = new iCausa();
        Causa causa = iC.oneId(id);
        if (causa != null) {
            return Response.ok(causa).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCausa(@PathParam("id") long id) {
        //  long ID = id;
        iCausa iC = new iCausa();
        Causa causa = iC.oneId(id);
        if (causa != null) {
            iC.delete(id);
            iC.closeSession();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertCausa(Causa c) {
        //  long ID = id;

        iCausa iC = new iCausa();
        iC.insert(c);
        iC.closeSession();
        return Response.status(Response.Status.CREATED).entity(c).build();

    }

}
