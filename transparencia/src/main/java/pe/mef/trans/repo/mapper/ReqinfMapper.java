package pe.mef.trans.repo.mapper;

import java.util.List;

import pe.mef.trans.web.solicitud.vo.tsoDReqinf;

public interface ReqinfMapper {

	//ReqnINf
	int insertReqInf(tsoDReqinf datos);
	List<tsoDReqinf> findAllRequerimientos(int solCDocumento);
	List<tsoDReqinf> findAllRequerimientosBA(tsoDReqinf datos);
	int updateRespuesta(tsoDReqinf datos);
	
	int updatePregunta(tsoDReqinf datos);
	
	
}
