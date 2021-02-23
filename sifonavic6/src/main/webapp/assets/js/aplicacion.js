$(document).ready(function() {
	
	
	
	$("#marcarHora").click( function() {
		
		let v = new Validator($("#valida1"));
		
		if(v.val && $("#valida1").val().length === 8  ){
			if($('#captcha-input').val().toUpperCase() !== $('.dynamic-code').text().toUpperCase()){
				$('#errCaptcha').html('<span style="color: red;"><i class="ion-close"></i> Captecha no Coincide.</span>');
		        $('#captcha-input').val('');
			}else{
				existeTrabajador();
			}
			 
		        
		        
			
		}else{
			console.log("false")
		}
			
		
		
	});
	
	
	
	
	$("#x").click( function() {
		
		
		
	});
	
	
	function clear(){
		$('.modal-title').text('');
		
		$('.modal-body').text('');
		
	}
	 
	
	function existeTrabajador() { 
		clear()
		 
		$.ajax({
			url: 'existeTrabajador',
			type : 'POST',
			data : {mrcCDni : $("#valida1").val()},
			dataType:"json",
			success : function(rpta) {
				
				
				
				if(rpta.codRpta == '001'){
					$("#clock5").clock("destroy");
				
					let gsonv = JSON.parse(rpta.gson);
					$('.modal-title').text('Se registro con éxito');
					$('.modal-title').append(' <i class="fa fa-check-circle fa-2x" aria-hidden="true" style="color:green;"></i>');
					
					$('.modal-body').text('Dni: ');
					$('.modal-body').append($("#valida1").val()  +'<br>');
					$('.modal-body').append('Nombre: ');
					$('.modal-body').append(gsonv.mrcDNombres +' ' + gsonv.mrcDApellidos +'<br>' );
					$('.modal-body').append('Hora : ');
					$('.modal-body').append($('#clock5').text() );
					$('#xmodal').modal('show')
					$('#marcarHora').hide();
					
				
				}
				if(rpta.codRpta == '002'){
					
					
					$('.modal-title').text(rpta.msjRpta);
					$('.modal-title').append(' <i class="fa fa-exclamation-circle fa-2x" aria-hidden="true" style="color:red;"></i>');
					
					$('#xmodal').modal('show')
					 $('.dynamic-code').text(generateCaptcha(5, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'));
					 $('#captcha-input').val('');
				}
				if(rpta.codRpta === '000'){
					
					$('.modal-title').text('Error de Conexion');
					$('.modal-title').append(' <i class="fa fa-exclamation-circle fa-2x" aria-hidden="true" style="color:red;"></i>');
					
					
					$('#xmodal').modal('show')
					$("#clock5").clock("destroy");
					$('#marcarHora').hide();
					
					console.log(rpta.msjRpta)
				}
			},
			error: function (request, status, error) {
				
				$('.modal-title').text('Error de Conexion');
				$('#xmodal').modal('show')
				$("#clock5").clock("destroy");
				$('#marcarHora').hide();
				
				
		        console.log("There was an error: ", request.responseText);
		    }
		});
	    
	}

	
	
	 

		
	
});

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    return (charCode > 47 && charCode < 58 || charCode == 8  || charCode == 9 || charCode == 46  || charCode >36 &&  charCode < 41);
}



function generateCaptcha(length, chars) {
    var result = '';
    for (var i = length; i > 0; --i) result += chars[Math.round(Math.random() * (chars.length - 1))];
    return result;
}		 

//default captcha
$('.dynamic-code').text(generateCaptcha(5, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'));

$('.captcha-reload').on('click', function () {
    $('.dynamic-code').text(generateCaptcha(5, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'));
});

//check captcha
$('#captcha-input').on('change', function () {
    if($(this).val().toUpperCase() !== $('.dynamic-code').text().toUpperCase()){
        $('#errCaptcha').html('<span style="color: red;"><i class="ion-close"></i> Captcha no Coincide.</span>');
        $('#captcha-input').val('');
    }else {
        $('#errCaptcha').html('');
    }
});

