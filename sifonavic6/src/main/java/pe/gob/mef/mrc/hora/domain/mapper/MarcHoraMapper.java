package pe.gob.mef.mrc.hora.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.gob.mef.mrc.hora.domain.entity.GmrcTrabajador;

public interface MarcHoraMapper {
	
	String horaOracle();
	List<GmrcTrabajador> existeTrabajador(@Param("mrcCDni") String mrcCDni);
	List<GmrcTrabajador> listTxt(@Param("fechaini") String fechaini,@Param("fechafin") String fechafin);
	int insertMarcacion(GmrcTrabajador gmrcTrabajador);
	
}
