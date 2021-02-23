package pe.mef.trans.web.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.mef.trans.repo.mapper.DatosMapper;
import pe.mef.trans.repo.mapper.SolicitudMapper;
import pe.mef.trans.web.config.Transaccion;
import pe.mef.trans.web.data.vo.tsoCAreaVo;
import pe.mef.trans.web.solicitud.vo.TsocSolicitudVo;
import pe.mef.trans.web.solicitud.vo.tsoDArchivosVo;
import pe.mef.trans.web.usuario.vo.GsecUsuario;

@RestController
//@CrossOrigin("*")
@RequestMapping("/data")
public class dataController {

	@Autowired
	public DatosMapper datosMapper;

	@GetMapping("/listareas")
	public List<tsoCAreaVo> getAreas() {
System.out.println("listareas...............");
		return datosMapper.findAll();

	}

	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		
		System.out.println("employees");
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee("1","edwin","maravi","emaravi@cjavaperu.com"));
		employeesList.add(new Employee("2","noritza","rondon","info@cjavaperu.com"));
		return employeesList;
	}

	

}
