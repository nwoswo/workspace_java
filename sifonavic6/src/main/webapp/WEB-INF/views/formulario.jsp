
<!doctype html>
<html lang="en">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 



<head> 

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="<%= request.getContextPath() %>/assets/css/mdb.min.css" rel="stylesheet">
    
    


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

 
  
 <script src="<%= request.getContextPath() %>/assets/js/jquery.form-validation.min.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/smoothness/jquery-ui.css" />



 <style>

         
        /* dialog div must be hidden */
        .basicModal{
            display:none; 
            font-family: "Trebuchet MS", "Helvetica", "Arial",  "Verdana", "sans-serif";
           
        }
        
        .ui-widget-header {
		  /*Change the Header color here*/
		    background: #23456B;
		    border: 0;
		    color: #fff;
		    font-weight: normal;
		}

		/*.ui-dialog-titlebar { display: none; }*/


		.body-dialog{

			 font-size: .8em;
	   }


</style>

    <title>Secretaria Tecnica Fonavi</title>
    

</head>

<body>

	
	  <div class="d-flex w-100 justify-content-center align-self-center">
	  
	  	 <div class="card mt-5" style="width: 50rem;">
	  	 <div class="card">
			  <div class="card-header text-white " style="background-color: #275a82;">
			    Generar Reporte
			  </div>
			  
			  
			   <div class="card-body">
			   
			   
				   <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputEmail4">Fecha inicial</label>
				      <input type="text" class="form-control" id="fechaini" readonly="readonly" data-validator="required" >
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Fecha Termino</label>
				      <input type="text" class="form-control" id="fechafin" readonly="readonly"  data-validator="required">
				    </div>
				  </div>
				  <div class="d-flex justify-content-end"> 
				  	<button type="button" id="mybutton" class="btn btn-primary ">Exportar</button>
				  </div>
			  	  
	
			  </div>
		  </div>
		</div>
	</div>
	
</body>


<script src="<%= request.getContextPath() %>/assets/js/aplicacion.js"></script>

<script>

$(document).ready(function() {
	
	

	
	
	 download = function(url, key, data,key2,data2){
		    // Build a form
		    var form = $('<form></form>').attr('action', url).attr('method', 'post');
		    // Add the one key/value
		    form.append($("<input></input>").attr('type', 'hidden').attr('name', key).attr('value', data));
		    form.append($("<input></input>").attr('type', 'hidden').attr('name', key2).attr('value', data2));
		    //send request
		    form.appendTo('body').submit().remove();
		};
		
		
		
		
		$("#mybutton").click( function() {
			
			let v1 = new Validator($("#fechaini"));
			let v2 = new Validator($("#fechafin"));
			
			
			if(v1.val && v2.val ){
				 
				console.log("true");
				download('files','fechaini', $('#fechaini').val(),'fechafin', $('#fechafin').val());
			}else{
				console.log("false")
			}
				
			
			
		});
		
		
		$.datepicker.regional['es'] = {
				 closeText: 'Cerrar',
				 prevText: '< Ant',
				 nextText: 'Sig >',
				 currentText: 'Hoy',
				 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
				 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
				 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
				 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
				 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
				 weekHeader: 'Sm',
				 dateFormat: 'dd/mm/yy',
				 firstDay: 1,
				 isRTL: false,
				 showMonthAfterYear: false,
				 yearSuffix: ''
				 };
		
		 $.datepicker.setDefaults($.datepicker.regional['es']);
		
		 
		 $('#fechaini').datepicker({dateFormat: 'dd/mm/yy', });
		 $('#fechafin').datepicker({dateFormat: 'dd/mm/yy', });
		 
		 
		 
		 $("div.ui-datepicker").css("font-size", "80%")
		 

		

		
	
});



</script>

</html>