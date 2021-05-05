package pe.mef.st.bean;

public class RsdhCopia {
	
	private Long copCCopia;
	private Long expCExpediente;
	private Long expCUnidadOrigen;
	private Long expCUnidadDestino;
	private String copFEnvio;
	private Long copEestado;
	
	public Long getCopCCopia() {
		return copCCopia;
	}
	public void setCopCCopia(Long copCCopia) {
		this.copCCopia = copCCopia;
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
	public String getCopFEnvio() {
		return copFEnvio;
	}
	public void setCopFEnvio(String copFEnvio) {
		this.copFEnvio = copFEnvio;
	}
	public Long getCopEestado() {
		return copEestado;
	}
	public void setCopEestado(Long copEestado) {
		this.copEestado = copEestado;
	}
	
	

}


//COP_C_COPIA            NOT NULL NUMBER(10)   
//EXP_C_EXPEDIENTE                NUMBER(10)   
//EXP_C_UNIDAD_ORIGEN             NUMBER(10)   
//EXP_C_UNIDAD_DESTINO            NUMBER(10)   
//COP_F_ENVIO                     DATE         
//COP_E_ESTADO                    NUMBER(1)   