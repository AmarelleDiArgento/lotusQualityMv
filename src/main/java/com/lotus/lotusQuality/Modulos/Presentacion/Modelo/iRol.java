/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Modulos.Presentacion.Modelo;

import com.lotus.lotusQuality.Configuracion.Configuracion;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Interfaces.Roles;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Tabs.Rol;
import java.util.List;
import org.hibernate.Session;

public class iRol extends Configuracion implements Roles {

    @Override
    public void insert(Rol o) {

        getSession().persist(o);

    }

    @Override
    public void update(Rol o) {
        getSession().update(o);
    }

    @Override
    public void delete(Long id) {
        Rol r = oneId(id);
        if (r != null) {
            getSession().delete(r);
        }
    }

    @Override
    public Rol oneId(Long id) {
        return (Rol) getSession().get(Rol.class, id);
    }

    @Override
    public Rol oneName(String name) {
        return (Rol) getSession().createQuery(
                "from Rol where  nombreRol = :name")
                .setParameter("name", name).uniqueResult();
    }

    @Override
    public List<Rol> all() {
        return (List<Rol>) getSession().createQuery("from Rol").list();
    }

}
