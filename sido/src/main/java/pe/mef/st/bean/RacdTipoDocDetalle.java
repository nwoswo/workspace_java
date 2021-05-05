package pe.mef.st.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RacdTipoDocDetalle {

	private Long tddCTipoDoc;
	private String tddDTipoDetalle;
	private Long tddCTipoDoc1;
	private Long tddERegistro;
	
	public Long getTddCTipoDoc() {
		return tddCTipoDoc;
	}
	public void setTddCTipoDoc(Long tddCTipoDoc) {
		this.tddCTipoDoc = tddCTipoDoc;
	}
	public String getTddDTipoDetalle() {
		return tddDTipoDetalle;
	}
	public void setTddDTipoDetalle(String tddDTipoDetalle) {
		this.tddDTipoDetalle = tddDTipoDetalle;
	}
	public Long getTddCTipoDoc1() {
		return tddCTipoDoc1;
	}
	public void setTddCTipoDoc1(Long tddCTipoDoc1) {
		this.tddCTipoDoc1 = tddCTipoDoc1;
	}
	public Long getTddERegistro() {
		return tddERegistro;
	}
	public void setTddERegistro(Long tddERegistro) {
		this.tddERegistro = tddERegistro;
	}
	
	
	
}
