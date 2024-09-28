package com.DTO.TiendaVirtualSB;

public class Ventas {

	private int codigo_venta;
	private int cedula_cliente;
	private int cedula_uduario;
	private double ivaventa;
	private double total_venta;
	private double valor_venta;
	
	public Ventas(int codigo_venta, int cedula_cliente, int cedula_uduario, double ivaventa, double total_venta,
			double valor_venta) {
		super();
		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;
		this.cedula_uduario = cedula_uduario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}

	public int getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public int getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(int cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public int getCedula_uduario() {
		return cedula_uduario;
	}

	public void setCedula_uduario(int cedula_uduario) {
		this.cedula_uduario = cedula_uduario;
	}

	public double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	
	
	
}
