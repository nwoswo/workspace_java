package pe.mef.trans.repo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.mef.trans.web.config.Transaccion;
import pe.mef.trans.web.solicitud.vo.TsocSolicitudVo;
import pe.mef.trans.web.solicitud.vo.tsoDArchivosVo;
import pe.mef.trans.web.solicitud.vo.tsoDReqinf;
import pe.mef.trans.web.usuario.vo.GsecUsuario;









public interface SolicitudMapper {
	

	void call_pkg_tsoRsolicitud(Transaccion tx);
	void call_pkg_tsoUsolicitud(Transaccion tx);
	List<TsocSolicitudVo> findAll( @Param("param1 ") List param1,@Param("param2 ") String param2 );
	
	List<TsocSolicitudVo> findDNI(  @Param("param1 ") String param1, @Param("param2") String param2);
	
	void call_pkg_spTsoUestado(Transaccion tx);
	

	void call_pkg_tsoDelReq(Transaccion tx);
	
	
	int updateFRespuesta(@Param("param1 ") int param1 );
	int updateFEntrega(@Param("param1 ") int param1 );
}
