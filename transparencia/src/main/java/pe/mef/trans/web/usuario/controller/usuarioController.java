package pe.mef.trans.web.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.mef.trans.repo.mapper.UsuarioMapper;
import pe.mef.trans.web.config.Transaccion;
import pe.mef.trans.web.solicitud.vo.TsocSolicitudVo;
import pe.mef.trans.web.usuario.vo.GsecUsuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/rest/usuario")
public class usuarioController {
	
	@Autowired
	public UsuarioMapper usuarioMapper;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"todoOk\" : true }";
	}
	
	
	
	

	@GetMapping("/usuarios")
	public List<GsecUsuario> getUsuaios()
	{
		
		System.out.println("List<GsecUsuario>");
		return usuarioMapper.findAll();
		//return null;
	}
	
	
	
	@PostMapping(path="/registrar")
	public Transaccion insertarServicio(@RequestBody GsecUsuario user) {
		// TODO Auto-generated method stub
		
		System.out.println("--registrar--");
		Transaccion tx= new Transaccion();
		
		
		
		String trama = user.getGpecPersona().getTraNNrodoc()+"|"+user.getGpecPersona().getTraDApepat()+"|"+user.getGpecPersona().getTraDApemat()+"|"+user.getGpecPersona().getTraDNombres()+"|"+user.getGpecPersona().getTraCSexos()+"|"+user.getGpecPersona().getTraNCelular()+"¬";
		
		
		user.setUsuDPassword(bCryptPasswordEncoder().encode(user.getUsuDPassword()));
		
		
		trama = trama.toUpperCase()+user.getUsuDUsuario().toUpperCase()+"|"+user.getUsuDPassword()+"|"+user.getTracArea().getAreCArea();
		
		if(user.getTracArea().getAreCArea()==1)
			trama=trama+"|ROLE_ADMIN";
		else
			trama=trama+"|ROLE_MANAGER";
		
		 trama=trama+"|"+user.getUsuNUbigeo();
		
		
		System.out.println(trama);
		tx.setTraDatos(trama);
		//user.setTraDatos(trama);
		
		try {
			
			usuarioMapper.call_pkg_tra_usuario(tx);

			}catch (Exception e) {
				tx.setsCOD("0001");
				tx.setsDESCOD(e.getMessage());
				
			System.out.println(e.getMessage());
			}
		
		return tx;
	}
	
	
	@PutMapping("/updateUsuario/{id}")
	public Transaccion updateUsuario(@RequestBody GsecUsuario user, @PathVariable String id) {
		// TODO Auto-generated method stub
		
		System.out.println("--updateUsuario--");
		Transaccion tx= new Transaccion();
		
		
		String trama =user.getGpecPersona().getTraCCodigo()+"|"+user.getGpecPersona().getTraNNrodoc()+"|"+user.getGpecPersona().getTraDApepat()+"|"+user.getGpecPersona().getTraDApemat()+"|"+user.getGpecPersona().getTraDNombres()+"|"+user.getGpecPersona().getTraCSexos()+"|"+user.getGpecPersona().getTraNCelular()+"¬";
		
		trama = trama.toUpperCase()+user.getUsuCUsuario()+"|"+user.getUsuDUsuario().toUpperCase()+"|"+user.getUsuDPassword()+"|"+user.getTracArea().getAreCArea()+"|"+user.getUsuNUbigeo();
		
		tx.setTraDatos(trama);
		tx.setsCOD("0000");
		//user.setTraDatos(trama);
		
		try {
			
			usuarioMapper.call_sp_rus_registro(tx);
			
			//System.out.println("update ------------------------- = "+usuarioMapper.updateEstado(user));	
			tx.setTraDatos(null);
			
			}catch (Exception e) {
				tx.setsCOD("0001");
				tx.setsDESCOD(e.getMessage());
				
			System.out.println(e.getMessage());
			}
		
		return tx;
	}
	
	@PostMapping("/updatePassword")
	public Transaccion updatePassword	(@RequestBody GsecUsuario user) {
		
		
		System.out.println("--updatePassword--");
		
		
		System.out.println("usuCUsuario="+user.getUsuCUsuario());
		System.out.println("usuDPassword="+user.getUsuDPassword());
		
		Transaccion tx= new Transaccion();
		
		tx.setsCOD("0000");
		
		
		user.setUsuDPassword(bCryptPasswordEncoder().encode(user.getUsuDPassword()));
		
		//user.setTraDatos(trama);
		
		try {
			
			usuarioMapper.updatePassword(user);
			
			//System.out.println("update ------------------------- = "+usuarioMapper.updateEstado(user));	
			
			
			}catch (Exception e) {
				tx.setsCOD("0001");
				tx.setsDESCOD(e.getMessage());
				
			System.out.println(e.getMessage());
			}
		
		return tx;
	}
	
	
	
	
	@PutMapping("/updateEstado")
	public Transaccion updateEstado(@RequestBody GsecUsuario  user)
	{
		Transaccion tx= new Transaccion();
		
		
		
		System.out.println("user.getUsuCUsuario() ---------"+user.getUsuCUsuario());
		System.out.println("user.getUsuEUsuario() ---------"+user.getUsuEUsuario());
		
try {
			//user.setUsuCUsuario(Integer.parseInt(id));
			//user.setUsuEUsuario(0);
	if(user.getUsuEUsuario()==1)
		user.setUsuEUsuario(0);
	else if(user.getUsuEUsuario()==0)
		user.setUsuEUsuario(1);
	
			
			usuarioMapper.updateEstado(user);
			
			tx.setsCOD("0000");
			
			}catch (Exception e) {
				tx.setsCOD("0001");
				tx.setsDESCOD(e.getMessage());
				
			System.out.println(e.getMessage());
			}


		return tx;
	}
	

}
