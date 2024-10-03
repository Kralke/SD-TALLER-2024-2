package com.DAO.TiendaVirtualSB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.TiendaVirtualSB.ProductosVO;

public class ProductosDAO {
	 
	public void registrarProducto(ProductosVO cli) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO clientes (codigo_producto ,ivacompra ,nitproveedor ,nombre_producto ,precio_compra ,precio_venta) VALUES ('"+cli.getCodigo_producto()+"', '"
	     +cli.getIvacompra()+"', '"+cli.getNitproveedor()+"', '"+cli.getNombre_producto()+"', '"+cli.getPrecio_compra()+"', '"+cli.getPrecio_venta()+"')");
	   estatuto.close();
	   conex.desconectar();   
	  } catch (SQLException e) {
	      System.out.println(e.getMessage());
	  }
	 } 

	 public ArrayList<ProductosVO> consultarClientes(String ced) {
	  ArrayList<ProductosVO> clientes = new ArrayList<ProductosVO>();
	  Conexion conex= new Conexion();
	  String sql = "SELECT * FROM clientes ";
	  if (!ced.equals("null")) {
		sql = sql + "WHERE cedula_cli = '" + ced + "'";
	  }
	  try {
		Statement consulta = conex.getConnection().createStatement();
	    ResultSet res = consulta.executeQuery(sql);   
	    while (res.next()){
	    	ProductosVO cli = new ProductosVO(Integer.valueOf(res.getString("codigo_producto")) ,Double.valueOf(res.getString("ivacompra")),Integer.valueOf(res.getString("nitproveedor")),
	                                    res.getString("nombre_producto"),Integer.valueOf(res.getString("precio_compra")),Integer.valueOf(res.getString("precio_venta")));
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
