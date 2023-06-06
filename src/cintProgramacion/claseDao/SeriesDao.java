/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cintProgramacion.claseDao;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import cintProgramacion.modelo.Series;

public class SeriesDao {
	private final Connection con;

	public SeriesDao(Connection con) {
		this.con =  con;
	}
	
	public void guardar(Series series) {
		try {
		String sql = "INSERT INTO serie(codigo, titulo, fecha, temporadas, genero, "
				+ "actores, sinopsis) VALUES (?,?,?,?,?,?,?)";
			try(PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, series.getCodigo());
				pstm.setString(2, series.getTitulo());
				pstm.setDate  (3, series.getFecha());
				pstm.setString(4, series.getTemporada());
				pstm.setString(5, series.getGenero());
				pstm.setString(6, series.getActores());
				pstm.setString(7, series.getSinopsis());
				pstm.execute();
			
				try(ResultSet rst = pstm.getGeneratedKeys()){
				
					while(rst.next()) {
						series.setId(rst.getInt(1));
				}
			}
		}
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
  }

	public Series buscar(String codigo) {
		try {
			String sql = "SELECT codigo,titulo, fecha, temporadas, genero,"
					+ "actores, sinopsis FROM serie WHERE codigo = ?";
			try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.setString(1, codigo);
				pstm.execute();
				
				Series serieGuardarDao = new Series();
				try(ResultSet rst= pstm.getResultSet()){
					if(!rst.next()) {
						JOptionPane.showMessageDialog(null, "EL CODIGO NO EXISTE");
					}else {
                                        serieGuardarDao.setCodigo(rst.getString("codigo"));
					serieGuardarDao.setTitulo(rst.getString("titulo"));
					serieGuardarDao.setFecha(rst.getDate("fecha"));
					serieGuardarDao.setTemporada(rst.getString("temporadas"));
					serieGuardarDao.setGenero(rst.getString("genero"));
					serieGuardarDao.setActores(rst.getString("actores"));
					serieGuardarDao.setSinopsis(rst.getString("sinopsis"));
				}					
					return serieGuardarDao;
					}
				}
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR EN LA CONSULTA");
			throw new RuntimeException();
		}	
		}
	
	public void eliminar(String codigo) {
			try{
				String sql="DELETE FROM serie WHERE codigo = ?";
				try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.setString(1, codigo);	
				pstm.execute();
				}
			}catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	
	public void editarDao(String codigo,String titulos, Date fecha, String temporada,
			String genero,String actores,String sinopsis) {
		try {
			String sql = "UPDATE serie SET  titulo = ?, fecha = ?, temporadas = ?,"
					+ "genero = ?, actores = ? , sinopsis = ? WHERE codigo = ?";
		try(PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, titulos);
			pst.setDate(2, fecha);
			pst.setString(3, temporada);
			pst.setString(4, genero);
			pst.setString(5, actores);
			pst.setString(6, sinopsis);
			pst.setString(7, codigo);
			pst.execute();
		}
	}catch (SQLException e) {
		System.out.println("ERROR AL CONECTAR");
		throw new RuntimeException(e);
	}	
    }

        public Boolean verificarCodigo(String codigo ) {
		   try {
		        String codigo1 = codigo;
		        String sql1 = "SELECT COUNT(*) FROM serie WHERE codigo = ?";
		        try (PreparedStatement pst = con.prepareStatement(sql1)) {
		            pst.setString(1, codigo1);
		            try (ResultSet rset = pst.executeQuery()) {
		                rset.next();
		                int count = rset.getInt(1);
		                if (count > 0) {
		                    JOptionPane.showMessageDialog(null, "El código ya existe");
		                    return  false;
		                } else {
                                    return true;
						}
		                }
						}
				}catch (Exception e) { 
				}
		   return false;
	}
}
