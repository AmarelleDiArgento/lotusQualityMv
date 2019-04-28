/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Modulos.Monitoreo.Modelo;

import com.lotus.lotusQuality.Configuracion.Configuracion;
import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.Interfaces.Postcosechas;
import com.lotus.lotusQuality.Modulos.Monitoreo.Modelo.Tabs.Postcosecha;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

public class iPostcosecha extends Configuracion implements Postcosechas {

    @Override
    public void insert(Postcosecha o) {
        getSession().persist(o);

    }

    @Override
    public void update(Postcosecha o) {
        getSession().update(o);

    }

    @Override
    public void delete(Long id) {
        Postcosecha a = oneId(id);
        if (a != null) {
            getSession().delete(a);
        }
    }

    @Override
    public Postcosecha oneId(Long id) {
        return (Postcosecha) getSession().get(Postcosecha.class, id);
    }

    @Override
    public Postcosecha oneName(String name) {
        return (Postcosecha) getSession().createQuery(
                "from Postcosecha where  NombreAct = :name")
                .setParameter("name", name).uniqueResult();
    }

    @Override
    public List<Postcosecha> all() {
        List<Postcosecha> p = getSession().createQuery("SELECT p FROM Postcosecha p LEFT JOIN FETCH p.fincas").list();
        Set<Postcosecha> pu = new LinkedHashSet<>(p);
        p.clear();
        p.addAll(pu);
        return (List<Postcosecha>) p;
    }

}
