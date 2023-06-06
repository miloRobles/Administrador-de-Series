/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cintProgramacion.seriesControlador;
/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.Date;
import cintProgramacion.conexion.ConexionPrincipal;
import cintProgramacion.modelo.Series;
import cintProgramacion.claseDao.SeriesDao;

public class SeriesController {
	private SeriesDao seriesDao;
	
	public SeriesController() {
		Connection con = new ConexionPrincipal().obtenerConnection();
		this.seriesDao = new SeriesDao(con);
	}
	public void guardarDao(Series series) {
		this.seriesDao.guardar(series);
	}
        public Boolean verificarCodigoController( String codigo) {
		if (this.seriesDao.verificarCodigo(codigo)) {
			return true;
		}else {
			return false;
		}
	}
        
	public Series buscar(String codigo) {
     	return this.seriesDao.buscar(codigo);
	}
	
	public void eliminarController(String codigo) {
		this.seriesDao.eliminar(codigo);
	}
	
	public void editarController(/*int id,*/String codigo,String titulos, Date fecha, String temporada,
			String genero,String actores,String sinopsis ) {
		this.seriesDao.editarDao(codigo, titulos, fecha, temporada, genero, actores, sinopsis/*, id*/);
	}
}
 