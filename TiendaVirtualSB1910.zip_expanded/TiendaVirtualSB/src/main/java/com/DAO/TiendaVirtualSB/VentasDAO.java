package com.DAO.TiendaVirtualSB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.TiendaVirtualSB.VentasVO;

public class VentasDAO {
	
	public void registrarVenta(VentasVO cli) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO clientes (codigo_venta ,cedula_cliente ,cedula_usuario ,ivaventa ,total_venta ,valor_venta) VALUES ('"+cli.getCodigo_venta()+"', '"
	     +cli.getCedula_cliente()+"', '"+cli.getCedula_uduario()+"', '"+cli.getIvaventa()+"', '"+cli.getTotal_venta()+"', '"+cli.getValor_venta()+"')");
	   estatuto.close();
	   conex.desconectar();   
	  } catch (SQLException e) {
	      System.out.println(e.getMessage());
	  }
	 } 

	 public ArrayList<VentasVO> consultarClientes(String ced) {
	  ArrayList<VentasVO> clientes = new ArrayList<VentasVO>();
	  Conexion conex= new Conexion();
	  String sql = "SELECT * FROM clientes ";
	  if (!ced.equals("null")) {
		sql = sql + "WHERE cedula_cli = '" + ced + "'";
	  }
	  try {
		Statement consulta = conex.getConnection().createStatement();
	    ResultSet res = consulta.executeQuery(sql);   
	    while (res.next()){
	    	VentasVO cli = new VentasVO(Integer.valueOf(res.getString("codigo_venta")) ,Integer.valueOf(res.getString("cedula_cliente")),Integer.valueOf(res.getString("cedula_usuario")),
	    			Double.valueOf(res.getString("ivaventa")),Double.valueOf(res.getString("total_venta")),Double.valueOf(res.getString("valor_venta")));
	      clientes.add(cli);
	    }
	    res.close();
	    consulta.close();
	    conex.desconectar();
	  } catch (Exception e) {
		  System.out.println(e.getMessage());
	  }
	  return clientes;
	 }
}
