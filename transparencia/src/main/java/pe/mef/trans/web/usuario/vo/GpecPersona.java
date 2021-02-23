package pe.mef.trans.web.usuario.vo;

import java.io.Serializable;
import java.util.List;

public class GpecPersona  implements Serializable{
	
	
	
	
	
	
	 //TRA_C_CODIGO
	private int traCCodigo;
    //TRA_N_NRODOC
	private String traNNrodoc;
    //TRA_D_APEPAT
	private String traDApepat;
    //TRA_D_APEMAT
	private String traDApemat;
    //TRA_D_NOMBRES
	private String traDNombres;
    //TRA_C_SEXOS
	private int traCSexos;
    //TRA_N_CELULAR
	private String traNCelular;

	

	
	
	public int getTraCCodigo() {
		return traCCodigo;
	}

	public void setTraCCodigo(int traCCodigo) {
		this.traCCodigo = traCCodigo;
	}

	public String getTraNNrodoc() {
		return traNNrodoc;
	}

	public void setTraNNrodoc(String traNNrodoc) {
		this.traNNrodoc = traNNrodoc;
	}

	public String getTraDApepat() {
		return traDApepat;
	}

	public void setTraDApepat(String traDApepat) {
		this.traDApepat = traDApepat;
	}

	public String getTraDApemat() {
		return traDApemat;
	}

	public void setTraDApemat(String traDApemat) {
		this.traDApemat = traDApemat;
	}

	public String getTraDNombres() {
		return traDNombres;
	}

	public void setTraDNombres(String traDNombres) {
		this.traDNombres = traDNombres;
	}

	public int getTraCSexos() {
		return traCSexos;
	}

	public void setTraCSexos(int traCSexos) {
		this.traCSexos = traCSexos;
	}

	public String getTraNCelular() {
		return traNCelular;
	}

	public void setTraNCelular(String traNCelular) {
		this.traNCelular = traNCelular;
	}

	
	
}
