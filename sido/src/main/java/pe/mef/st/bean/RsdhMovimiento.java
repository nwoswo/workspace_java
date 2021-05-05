package pe.mef.st.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class RsdhMovimiento {
	
	private Long movCMovimiento;
	private Long expCExpediente;
	
	
	private Long expCUnidadOrigen;
	private Long expCUnidadDestino;
	private Long expCEstado;
	private Long movEEstado;
	private String movDObservacion;
	private Long insCInstruccion;
	private List<RsdhCopia> rsdhCopia;
	
	
	
	
	public Long getMovCMovimiento() {
		return movCMovimiento;
	}
	public void setMovCMovimiento(Long movCMovimiento) {
		this.movCMovimiento = movCMovimiento;
	}
	public Long getExpCExpediente() {
		return expCExpediente;
	}
	public void setExpCExpediente(Long expCExpediente) {
		this.expCExpediente = expCExpediente;
	}
	public Long getExpCUnidadOrigen() {
		return expCUnidadOrigen;
	}
	public void setExpCUnidadOrigen(Long expCUnidadOrigen) {
		this.expCUnidadOrigen = expCUnidadOrigen;
	}
	public Long getExpCUnidadDestino() {
		return expCUnidadDestino;
	}
	public void setExpCUnidadDestino(Long expCUnidadDestino) {
		this.expCUnidadDestino = expCUnidadDestino;
	}
	public Long getExpCEstado() {
		return expCEstado;
	}
	public void setExpCEstado(Long expCEstado) {
		this.expCEstado = expCEstado;
	}
	public Long getMovEEstado() {
		return movEEstado;
	}
	public void setMovEEstado(Long movEEstado) {
		this.movEEstado = movEEstado;
	}
	public String getMovDObservacion() {
		return movDObservacion;
	}
	public void setMovDObservacion(String movDObservacion) {
		this.movDObservacion = movDObservacion;
	}
	public Long getInsCInstruccion() {
		return insCInstruccion;
	}
	public void setInsCInstruccion(Long insCInstruccion) {
		this.insCInstruccion = insCInstruccion;
	}
	public List<RsdhCopia> getRsdhCopia() {
		return rsdhCopia;
	}
	public void setRsdhCopia(List<RsdhCopia> rsdhCopia) {
		this.rsdhCopia = rsdhCopia;
	}
	
	
	
		
}
