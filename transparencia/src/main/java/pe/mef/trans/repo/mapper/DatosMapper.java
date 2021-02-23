package pe.mef.trans.repo.mapper;

import java.util.List;

import pe.mef.trans.web.config.Transaccion;
import pe.mef.trans.web.data.vo.tsoCAreaVo;
import pe.mef.trans.web.solicitud.vo.TsocSolicitudVo;
import pe.mef.trans.web.usuario.vo.GsecUsuario;









public interface DatosMapper {
	

	
	List<tsoCAreaVo> findAll();
	
}
