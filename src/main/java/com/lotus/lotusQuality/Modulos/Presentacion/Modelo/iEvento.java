/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Modulos.Presentacion.Modelo;

import com.lotus.lotusQuality.Configuracion.Configuracion;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Interfaces.Eventos;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Tabs.Evento;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public class iEvento extends Configuracion implements Eventos {

    @Override
    public void insert(Evento o) {

        getSession().persist(o);

    }

    @Override
    public void update(Evento o) {
        getSession().update(o);

    }

    @Override
    public void delete(Long id) {
        Evento r = oneId(id);
        if (r != null) {
            getSession().delete(r);

        }
    }

    @Override
    public Evento oneId(Long id) {
        return (Evento) getSession().get(Evento.class, id);
    }

    @Override
    public Evento oneName(String titulo) {
        return (Evento) getSession().createQuery(
                "from Evento where  TituloEve = :titulo")
                .setParameter("titulo", titulo).uniqueResult();
    }

    @Override
    public List<Evento> all() {
        return (List<Evento>) getSession().createQuery("from Evento").list();
    }

}
