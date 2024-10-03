package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.DTO.TiendaVirtualSB.UsuariosVO;

public class UsuarioDAO {

	public void insertUsuario(UsuariosVO prov) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO usuarios(cedula_usuario, email_usuario,nombre_usuario ,password , usuario) VALUES ('" + prov.getCedula_usuario() + "', '" + prov.getEmail_usuario()
					+ "', '" + prov.getNombre_usuario() + "', '" + prov.getPassword() + "', '" + prov.getUsuario() + "')");
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<UsuariosVO> consultarUsuarios(String ced) {
		ArrayList<UsuariosVO> proveedores = new ArrayList<UsuariosVO>();
		Conexion conex = new Conexion();

		String sql = "SELECT * FROM usuarios ";
		if (!ced.equals("null")) {
			sql = sql + "WHERE cedula_usuario = '" + ced + "'";
		}

		try {
			Statement consulta = conex.getConnection().createStatement();
			ResultSet res = consulta.executeQuery(sql);

			while (res.next()) {
				UsuariosVO prov = new UsuariosVO(res.getString("cedula_usuario"), res.getString("email_usuario"),
						res.getString("nombre_usuario"), res.getString("password"), res.getString("usuario"));
				proveedores.add(prov);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return proveedores;
	}
	
}
