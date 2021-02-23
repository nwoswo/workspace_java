package pe.mef.trans.web.usuario.vo;

import java.io.Serializable;
import java.util.Date;

public class GsecUsuario implements Serializable{
	
	private int usuCUsuario;
	private String usuDUsuario;
	private String usuDPassword;
	private int usuEUsuario;
	
	private TracArea tracArea;
	private GpecPersona gpecPersona;
	private int usuNUbigeo;
	private String shorttraDNombre;

	
	
	
	public int getUsuNUbigeo() {
		return usuNUbigeo;
	}

	public void setUsuNUbigeo(int usuNUbigeo) {
		this.usuNUbigeo = usuNUbigeo;
	}

	public int getUsuEUsuario() {
		return usuEUsuario;
	}

	public void setUsuEUsuario(int usuEUsuario) {
		this.usuEUsuario = usuEUsuario;
	}

	public int getUsuCUsuario() {
		return usuCUsuario;
	}

	public void setUsuCUsuario(int usuCUsuario) {
		this.usuCUsuario = usuCUsuario;
	}

	public String getUsuDUsuario() {
		return usuDUsuario;
	}

	public void setUsuDUsuario(String usuDUsuario) {
		this.usuDUsuario = usuDUsuario;
	}

	public String getUsuDPassword() {
		return usuDPassword;
	}

	public void setUsuDPassword(String usuDPassword) {
		this.usuDPassword = usuDPassword;
	}



	public TracArea getTracArea() {
		return tracArea;
	}

	public void setTracArea(TracArea tracArea) {
		this.tracArea = tracArea;
	}

	public GpecPersona getGpecPersona() {
		return gpecPersona;
	}

	public void setGpecPersona(GpecPersona gpecPersona) {
		this.gpecPersona = gpecPersona;
	}

	public String getShorttraDNombre() {
		return shorttraDNombre;
	}

	public void setShorttraDNombre(String shorttraDNombre) {
		this.shorttraDNombre = shorttraDNombre;
	}


}
