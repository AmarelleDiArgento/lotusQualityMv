/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Modulos.Presentacion.Modelo;

import com.lotus.lotusQuality.Configuracion.Configuracion;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Interfaces.Tareas;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Tabs.Tarea;
import java.util.List;
import org.hibernate.Session;

public class iTareas extends Configuracion implements Tareas {

    @Override
    public void insert(Tarea o) {

        getSession().persist(o);

    }

    @Override
    public void update(Tarea o) {
        getSession().update(o);

    }

    @Override
    public void delete(Long id) {
        Tarea t = oneId(id);
        if (t != null) {
            getSession().delete(t);

        }

    }

    @Override
    public Tarea oneId(Long id) {
        return (Tarea) getSession().get(Tarea.class, id);
    }

    @Override
    public Tarea oneName(String name) {
        return (Tarea) getSession().createQuery(
                "from Tarea where  NombreTar = :name")
                .setParameter("name", name).uniqueResult();

    }

    @Override
    public List<Tarea> all() {
        return (List<Tarea>) getSession().createQuery("from Tarea").list();
    }

}
