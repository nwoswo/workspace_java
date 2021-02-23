package pe.mef.trans.repo.mapper;

import java.util.List;

import pe.mef.trans.web.config.Transaccion;
import pe.mef.trans.web.usuario.vo.GsecUsuario;




public interface UsuarioMapper {
	
	List<GsecUsuario> findAll();
	void call_pkg_tra_usuario(Transaccion tx);
	int updateEstado(GsecUsuario gsecUsuario);
	int updatePassword(GsecUsuario gsecUsuario);
	
	void call_sp_rus_registro(Transaccion tx);
	
}
