/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cintProgramacion.conexion;
/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionPrincipal {
	private final DataSource dataSource;
	
	public ConexionPrincipal() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
			comboPool.setJdbcUrl("jdbc:mysql://localhost/serietv?useTimeZone=true&serverTimeZone=UTC");
			comboPool.setUser("root");
			comboPool.setPassword("246810");
			this.dataSource = comboPool;
	}
        
        public Connection obtenerConnection() {
		try {
                	return this.dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			throw new RuntimeException();
		}
	}
}
