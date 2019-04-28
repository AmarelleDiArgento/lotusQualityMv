/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lotus.lotusQuality.Modulos.Presentacion.Modelo;

import com.lotus.lotusQuality.Configuracion.Configuracion;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Interfaces.Usuarios;
import com.lotus.lotusQuality.Modulos.Presentacion.Modelo.Tabs.Usuario;
import java.util.List;

public class iUsuario extends Configuracion implements Usuarios {

    @Override
    public void insert(Usuario o) {
        getSession().save(o);

    }

    @Override
    public void update(Usuario o) {
        getSession().update(o);

    }

    @Override
    public void delete(String id) {
        Usuario u = oneId(id);
        if (u != null) {
            getSession().delete(u);

        }
    }

    @Override
    public Usuario oneId(String id) {
        return (Usuario) getSession().get(Usuario.class, id);
    }

    @Override
    public Usuario oneName(String name) {
        return (Usuario) getSession().createQuery(
                "from Usuario where  nombreUsu = :name")
                .setParameter("name", name).uniqueResult();
    }

    @Override
    public List<Usuario> all() {
        return (List<Usuario>) getSession().createQuery("from Usuario").list();
    }

}
