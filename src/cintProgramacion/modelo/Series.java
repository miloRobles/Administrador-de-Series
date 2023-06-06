/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cintProgramacion.modelo;
/**
 *
 * @author Usuario
 */
import java.sql.Date;

public class Series {
		private int id;
		private String codigo;
		private String titulo;
		private Date fecha; 
		private String temporada;
		private String genero;
		private String actores;
		private String sinopsis;
		
		public Series() {}
		public Series( String codigo, String titulo, Date fecha, String temporada, String genero, String actores,
				String sinopsis ) {
			this.codigo = codigo;
			this.titulo = titulo;
			this.fecha = fecha;
			this.temporada = temporada;
			this.genero = genero;
			this.actores = actores;
			this.sinopsis = sinopsis;
		}
		public Series(int id, String codigo, String titulo, Date fecha, String temporada, String genero, String actores,
				String sinopsis) {
			this.id = id;
			this.codigo = codigo;
			this.titulo = titulo;
			this.fecha = fecha;
			this.temporada = temporada;
			this.genero = genero;
			this.actores = actores;
			this.sinopsis = sinopsis;
		} 
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public String getTemporada() {
			return temporada;
		}
		public void setTemporada(String temporada) {
			this.temporada = temporada;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public String getActores() {
			return actores;
		}
		public void setActores(String actores) {
			this.actores = actores;
		}
		public String getSinopsis() {
			return sinopsis;
		}
		public void setSinopsis(String sinopsis) {
			this.sinopsis = sinopsis;
		}
}

