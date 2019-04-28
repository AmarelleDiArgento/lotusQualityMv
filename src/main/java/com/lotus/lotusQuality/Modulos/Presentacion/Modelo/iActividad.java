/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Modulos.Presentacion.Modelo;

import com.lotus.lotusQuality.Configuracion.Configuracion;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Tabs.Actividad;
import java.util.List;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Interfaces.Actividades;

public class iActividad extends Configuracion implements Actividades {

    @Override
    public void insert(Actividad o) {

        getSession().persist(o);

    }

    @Override
    public void update(Actividad o) {
        getSession().update(o);

    }

    @Override
    public void delete(Long id) {
        Actividad a = oneId(id);
        if (a != null) {
            getSession().delete(a);
        }
    }

    @Override
    public Actividad oneId(Long id) {
        return (Actividad) getSession().get(Actividad.class, id);
    }

    @Override
    public Actividad oneName(String name) {
        return (Actividad) getSession().createQuery(
                "from Actividad where  NombreAct = :name")
                .setParameter("name", name).uniqueResult();
    }

    @Override
    public List<Actividad> all() {
        return (List<Actividad>) getSession().createQuery("from Actividad").list();
    }

}
