/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Modulos.Monitoreo.Modelo;

import com.lotus.lotusQuality.Configuracion.Configuracion;
import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.Interfaces.Fincas;
import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.Tabs.Finca;
import java.util.LinkedHashSet;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;

public class iFinca extends Configuracion implements Fincas {

    @Override
    public void insert(Finca o) {
        getSession().persist(o);

    }

    @Override
    public void update(Finca o) {
        getSession().update(o);

    }

    @Override
    public void delete(Long id) {
        Finca f = oneId(id);
        if (f != null) {
            getSession().delete(f);
        }
    }

    @Override
    public Finca oneId(Long id) {
        return (Finca) getSession().get(Finca.class, id);
    }

    @Override
    public Finca oneName(String name) {
        return (Finca) getSession().createQuery(
                "from Finca where  NombreAct = :name")
                .setParameter("name", name).uniqueResult();
    }

    @Override
    public List<Finca> all() {
        List<Finca> f = getSession().createQuery("from Finca").list();
        Set<Finca> fu = new LinkedHashSet<>(f);
        f.clear();
        f.addAll(fu);
        return (List<Finca>) f;
    }

}
