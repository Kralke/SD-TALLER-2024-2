package com.DAO.TiendaVirtualSB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.DTO.TiendaVirtualSB.Detalle_VentasVO;



public class Detalle_VentasDAO {
	
	
	public void insertVentas(Detalle_VentasVO ven) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO ventas(codigo_detalle_venta, cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva) VALUES ('" + ven.getCodigo_detalle_venta() + "', " + ven.getCantidad_producto()
					+ ", '" + ven.getCodigo_producto() + ", '" + ven.getCodigo_venta() + ", '" + ven.getValor_total() + ", '" + ven.getValor_venta() + ", '" + ven.getValoriva() +"')");
			estatuto.close();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList <String> consultarDetalles(String tipo) {
		ArrayList<String> registros = new ArrayList<String>();
		Conexion conex = new Conexion();

		String sql = "";
		if (tipo.trim().equals("producto")) {
			sql = "SELECT nombre_producto AS Item, SUM(cantidad_producto) AS Unidades\r\n"
					+ "FROM detalle_ventas\r\n"
					+ "inner join productos on detalle_ventas.codigo_producto = productos.codigo_producto\r\n"
					+ "GROUP BY nombre_producto\r\n"
					+ "ORDER BY nombre_producto;";
			
		} else if (tipo.trim().equals("cliente")){
			sql = "SELECT nombre_cliente AS Nombre, SUM(total_venta) AS Total\r\n"
					+ "FROM clientes\r\n"
					+ "inner join ventas on clientes.cedula_cliente = ventas.cedula_cliente\r\n"
					+ "GROUP BY nombre_cliente\r\n"
					+ "ORDER BY nombre_cliente;";
		}

		try {
			Statement consulta = conex.getConnection().createStatement();
			ResultSet res = consulta.executeQuery(sql);

			while (res.next()) {
				registros.add(res.getString("Item")+";"+res.getInt("unidades"));

			}
			res.close();
			consulta.close();
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar el Proveedor\n" + e);
		}
		return registros;
	}
}
