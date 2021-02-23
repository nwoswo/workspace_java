package pe.mef.trans.web.solicitud.vo;

public class TsocSolicitudVo {

	//SOL_E_CALIFICACION
	
	
private int perCSolicitante;
//SOL_N_HOJA

private String perCTipodoc;
private String perNNrodoc;
private String perDRazonSocial;
private String perDApepat;
private String perDApemat;
private String perDNombre;
private String perDEmail;
private int perNUbigeo;
private String perDUrbanizacion;

private String perDCalleave;
private String perDInterior;
private String perNCelular;
private String perNTelefono;
private String perESolicitante;
private String trama;
private int nrodias;
private int nroArchivos;

private int nroreq;
private int nroreqresp;
private int nroacusescan;
private int nrooficio;



 



private int solCDocumento;
//SOL_E_SOLICITUD



private int solESolicitud;
private String solNHoja;

private String solDInformacion;

private String codDpto;
private String codProv;





private String dedDDepart;
private String prdDProvi;
private String didDDistrito;


private int usuCUsuario;

private int solCOrigen;

private int solCEcalificacion;



private String solFRegistro;

//SOL_F_RESPUESTA
private String solFRespuesta;
//SOL_F_ENTREGA
private String solFEntrega;

private String perDReferencia;

private String solERecojo;







public String getSolERecojo() {
	return solERecojo;
}


public void setSolERecojo(String solERecojo) {
	this.solERecojo = solERecojo;
}


public int getNrooficio() {
	return nrooficio;
}


public void setNrooficio(int nrooficio) {
	this.nrooficio = nrooficio;
}


public String getPerDReferencia() {
	return perDReferencia;
}


public void setPerDReferencia(String perDReferencia) {
	this.perDReferencia = perDReferencia;
}


public String getSolFRespuesta() {
	return solFRespuesta;
}


public void setSolFRespuesta(String solFRespuesta) {
	this.solFRespuesta = solFRespuesta;
}


public String getSolFEntrega() {
	return solFEntrega;
}


public void setSolFEntrega(String solFEntrega) {
	this.solFEntrega = solFEntrega;
}


public int getSolCEcalificacion() {
	return solCEcalificacion;
}


public void setSolCEcalificacion(int solCEcalificacion) {
	this.solCEcalificacion = solCEcalificacion;
}


public int getSolCOrigen() {
	return solCOrigen;
}


public void setSolCOrigen(int solCOrigen) {
	this.solCOrigen = solCOrigen;
}


public int getUsuCUsuario() {
	return usuCUsuario;
}


public void setUsuCUsuario(int usuCUsuario) {
	this.usuCUsuario = usuCUsuario;
}


public void tInsertTrama() {
	
	System.out.println("perDUrbanizacion="+perDUrbanizacion);
	if(perDUrbanizacion.isEmpty())
		System.out.println("insert yes");
	
	 //trama =perCTipodoc+"|"+perNNrodoc+"|"+perDRazonSocial+"|"+perDApepat+"|"+perDApemat+"|"+perDNombre+"|"+perDEmail+"|"+perNUbigeo+"|"+perDUrbanizacion+"|"+perDCalleave+"|"+perDInterior+"|"+perNCelular+"|"+perNTelefono+"¬"+solDInformacion;
	 trama=perCTipodoc+"|"+perNNrodoc+"|"+(perDRazonSocial!=null?perDRazonSocial.toUpperCase():"")+"|"+(perDApepat!=null?perDApepat.toUpperCase():"")+"|"+(perDApemat!=null?perDApemat.toUpperCase():"")+"|"+(perDNombre!=null?perDNombre.toUpperCase():"")+"|"+(perDEmail!=null?perDEmail.toLowerCase():"")+"|"+perNUbigeo+"|"+(perDUrbanizacion!=null?perDUrbanizacion.toUpperCase():"")+"|"+(perDCalleave!=null?perDCalleave.toUpperCase():"")+"|"+(perDInterior!=null?perDInterior.toUpperCase():"")+"|"+(perNCelular!=null?perNCelular.toUpperCase():"")+"|"+(perNTelefono!=null?perNTelefono.toUpperCase():"")+"|"+(perDReferencia!=null?perDReferencia.toUpperCase():"")+"¬"+(solDInformacion!=null?solDInformacion.toUpperCase():"")+"|"+usuCUsuario+"|"+solESolicitud+"|"+solCOrigen+"|"+solERecojo;
		

}
  

public void tUpdateSol() {
	
	System.out.println("perDUrbanizacion="+perDUrbanizacion);
	
	
	System.out.println("perNTelefono="+perNTelefono);
	
	 //trama =perCTipodoc+"|"+perNNrodoc+"|"+perDRazonSocial+"|"+perDApepat+"|"+perDApemat+"|"+perDNombre+"|"+perDEmail+"|"+perNUbigeo+"|"+perDUrbanizacion+"|"+perDCalleave+"|"+perDInterior+"|"+perNCelular+"|"+perNTelefono+"¬"+solDInformacion;
	 trama=perCSolicitante+"|"+perCTipodoc+"|"+perNNrodoc+"|"+(perDRazonSocial!=null?perDRazonSocial.toUpperCase():"")+"|"+(perDApepat!=null?perDApepat.toUpperCase():"")+"|"+(perDApemat!=null?perDApemat.toUpperCase():"")+"|"+(perDNombre!=null?perDNombre.toUpperCase():"")+"|"+(perDEmail!=null?perDEmail.toLowerCase():"")+"|"+perNUbigeo+"|"+(perDUrbanizacion!=null?perDUrbanizacion.toUpperCase():"")+"|"+(perDCalleave!=null?perDCalleave.toUpperCase():"")+"|"+(perDInterior!=null?perDInterior.toUpperCase():"")+"|"+(perNCelular!=null?perNCelular.toUpperCase():"")+"|"+(perNTelefono!=null?perNTelefono.toUpperCase():"")+"|"+(perDReferencia!=null?perDReferencia.toUpperCase():"")+"¬"+solCDocumento+"|"+(solDInformacion!=null?solDInformacion.toUpperCase():"")+"|"+usuCUsuario+"|"+solERecojo;
		

}


public String getCodDpto() {
	
	
	String temp=perNUbigeo+"";
	if(temp.length()==5)
		
		temp=temp.substring(0,1);
		
	else
		temp=temp.substring(0,2);
	return temp;
}



public String getCodProv() {
	
	String temp=perNUbigeo+"";
	if(temp.length()==5)
		temp=temp.substring(0,3);
	else
		temp=temp.substring(0,4);
		//70505
	return temp;
}







public int getNroacusescan() {
	return nroacusescan;
}


public void setNroacusescan(int nroacusescan) {
	this.nroacusescan = nroacusescan;
}


public int getNroreq() {
	return nroreq;
}


public void setNroreq(int nroreq) {
	this.nroreq = nroreq;
}


public int getNroreqresp() {
	return nroreqresp;
}


public void setNroreqresp(int nroreqresp) {
	this.nroreqresp = nroreqresp;
}


public int getNrodias() {
	return nrodias;
}


public void setNrodias(int nrodias) {
	this.nrodias = nrodias;
}


public int getNroArchivos() {
	return nroArchivos;
}


public void setNroArchivos(int nroArchivos) {
	this.nroArchivos = nroArchivos;
}


public String getTrama() {
	return trama;
}


public int getSolESolicitud() {
	return solESolicitud;
}



public void setSolESolicitud(int solESolicitud) {
	this.solESolicitud = solESolicitud;
}



public int getSolCDocumento() {
	return solCDocumento;
}



public void setSolCDocumento(int solCDocumento) {
	this.solCDocumento = solCDocumento;
}



public String getSolNHoja() {
	return solNHoja;
}



public void setSolNHoja(String solNHoja) {
	this.solNHoja = solNHoja;
}



public String getSolFRegistro() {
	return solFRegistro;
}



public void setSolFRegistro(String solFRegistro) {
	this.solFRegistro = solFRegistro;
}




public int getPerCSolicitante() {
	return perCSolicitante;
}
public void setPerCSolicitante(int perCSolicitante) {
	this.perCSolicitante = perCSolicitante;
}
public String getPerCTipodoc() {
	return perCTipodoc;
}
public void setPerCTipodoc(String perCTipodoc) {
	this.perCTipodoc = perCTipodoc;
}
public String getPerNNrodoc() {
	return perNNrodoc;
}
public void setPerNNrodoc(String perNNrodoc) {
	this.perNNrodoc = perNNrodoc;
}
public String getPerDRazonSocial() {
	return perDRazonSocial;
}
public void setPerDRazonSocial(String perDRazonSocial) {
	this.perDRazonSocial = perDRazonSocial;
}
public String getPerDApepat() {
	return perDApepat;
}
public void setPerDApepat(String perDApepat) {
	this.perDApepat = perDApepat;
}
public String getPerDApemat() {
	return perDApemat;
}
public void setPerDApemat(String perDApemat) {
	this.perDApemat = perDApemat;
}
public String getPerDNombre() {
	return perDNombre;
}
public void setPerDNombre(String perDNombre) {
	this.perDNombre = perDNombre;
}
public String getPerDEmail() {
	return perDEmail;
}
public void setPerDEmail(String perDEmail) {
	this.perDEmail = perDEmail;
}
public int getPerNUbigeo() {

	return perNUbigeo;
}

public void setPerNUbigeo(int perNUbigeo) {
	this.perNUbigeo = perNUbigeo;
}
public String getPerDUrbanizacion() {
	
/*	if(!perDUrbanizacion.isEmpty())
		perDUrbanizacion="";
	*/
	
	return perDUrbanizacion;
}
public void setPerDUrbanizacion(String perDUrbanizacion) {
	this.perDUrbanizacion = perDUrbanizacion;
}
public String getPerDCalleave() {
	return perDCalleave;
}
public void setPerDCalleave(String perDCalleave) {
	this.perDCalleave = perDCalleave;
}
public String getPerDInterior() {
	return perDInterior;
}
public void setPerDInterior(String perDInterior) {
	this.perDInterior = perDInterior;
}
public String getPerNCelular() {
	return perNCelular;
}
public void setPerNCelular(String perNCelular) {
	this.perNCelular = perNCelular;
}
public String getPerNTelefono() {
	return perNTelefono;
}
public void setPerNTelefono(String perNTelefono) {
	this.perNTelefono = perNTelefono;
}
public String getPerESolicitante() {
	return perESolicitante;
}
public void setPerESolicitante(String perESolicitante) {
	this.perESolicitante = perESolicitante;
}
public String getSolDInformacion() {
	return solDInformacion;
}
public void setSolDInformacion(String solDInformacion) {
	this.solDInformacion = solDInformacion;
}


public String getDedDDepart() {
	return dedDDepart;
}


public void setDedDDepart(String dedDDepart) {
	this.dedDDepart = dedDDepart;
}


public String getPrdDProvi() {
	return prdDProvi;
}


public void setPrdDProvi(String prdDProvi) {
	this.prdDProvi = prdDProvi;
}


public String getDidDDistrito() {
	return didDDistrito;
}


public void setDidDDistrito(String didDDistrito) {
	this.didDDistrito = didDDistrito;
}




	

}
