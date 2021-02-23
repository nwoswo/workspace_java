package pe.gob.mef.mrc.common.domain;

import java.util.List;

import com.google.gson.Gson;

public class GralDatosSend {
	
	private String msjRpta;
	private String codRpta;
	private String msjRptaError;
	private String msjRptaOk;
	private String msjRptaWarn;
	private Object persona;
	private Object heredero;
	private Object beneficiario;
	private List   listDatos;
	private Object ctaCte;
	private List   listHeredero;
	private Object padronHeredero;
	
	private String gson;
	
	
	
	
	public String getGson() {
		return gson;
	}
	public void setGson(String gson) {
		this.gson = gson;
	}
	public String getCodRpta() {
		return codRpta;
	}
	public void setCodRpta(String codRpta) {
		this.codRpta = codRpta;
	}
	public String getMsjRpta() {
		return msjRpta;
	}
	public void setMsjRpta(String msjRpta) {
		this.msjRpta = msjRpta;
	}
	public String getMsjRptaError() {
		return msjRptaError;
	}
	public void setMsjRptaError(String msjRptaError) {
		this.msjRptaError = msjRptaError;
	}
	public String getMsjRptaOk() {
		return msjRptaOk;
	}
	public void setMsjRptaOk(String msjRptaOk) {
		this.msjRptaOk = msjRptaOk;
	}
	public String getMsjRptaWarn() {
		return msjRptaWarn;
	}
	public void setMsjRptaWarn(String msjRptaWarn) {
		this.msjRptaWarn = msjRptaWarn;
	}
	public Object getPersona() {
		return persona;
	}
	public void setPersona(Object persona) {
		this.persona = persona;
	}
	public Object getHeredero() {
		return heredero;
	}
	public void setHeredero(Object heredero) {
		this.heredero = heredero;
	}
	public Object getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Object beneficiario) {
		this.beneficiario = beneficiario;
	}
	public List getListDatos() {
		return listDatos;
	}
	public void setListDatos(List listDatos) {
		this.listDatos = listDatos;
	}
	public Object getCtaCte() {
		return ctaCte;
	}
	public void setCtaCte(Object ctaCte) {
		this.ctaCte = ctaCte;
	}
	public List getListHeredero() {
		return listHeredero;
	}
	public void setListHeredero(List listHeredero) {
		this.listHeredero = listHeredero;
	}
	public Object getPadronHeredero() {
		return padronHeredero;
	}
	public void setPadronHeredero(Object padronHeredero) {
		this.padronHeredero = padronHeredero;
	}

}
