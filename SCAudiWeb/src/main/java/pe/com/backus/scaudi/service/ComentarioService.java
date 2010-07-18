/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.backus.scaudi.service;

import java.util.List;
import pe.com.backus.scaudi.domain.Comentario;

/**
 *
 * @author Administrador
 */
public interface ComentarioService {


    public void guardar(Comentario comentario);

    public void eliminar(Comentario comentario);

    public Comentario obtenerComentario(Integer codigo);

    public List<Comentario> listarComentarios();

}
