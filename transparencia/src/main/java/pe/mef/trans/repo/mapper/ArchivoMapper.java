package pe.mef.trans.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.mef.trans.web.config.Transaccion;
import pe.mef.trans.web.solicitud.vo.TsocSolicitudVo;
import pe.mef.trans.web.solicitud.vo.tsoDArchivosVo;
import pe.mef.trans.web.usuario.vo.GsecUsuario;


public interface ArchivoMapper {
	
	int insert(tsoDArchivosVo archivo);
	tsoDArchivosVo  getFile(tsoDArchivosVo documento);
	List<tsoDArchivosVo> getListFile(tsoDArchivosVo data);
	int getIdFile();
	
	int deleteByid( @Param("param1 ") String param1);
}
