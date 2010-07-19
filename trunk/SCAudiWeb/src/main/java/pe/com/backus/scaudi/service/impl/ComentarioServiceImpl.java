/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service.impl;

import java.util.List;
import pe.com.backus.scaudi.dao.ComentarioDAO;
import pe.com.backus.scaudi.domain.Comentario;
import pe.com.backus.scaudi.service.ComentarioService;

/**
 *
 * @author Administrador
 */
public class ComentarioServiceImpl implements ComentarioService{

    private ComentarioDAO comentarioDAO;

    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }


    public void guardar(Comentario comentario) {
       comentarioDAO.guardar(comentario);
    }

    public void eliminar(Comentario comentario) {
        comentarioDAO.eliminar(comentario);
    }

    public Comentario obtenerComentario(Integer codigo) {
        return comentarioDAO.obtenerComentario(codigo);
    }

    public List<Comentario> listarComentarios() {
        return comentarioDAO.listarComentarios();

    }


}
