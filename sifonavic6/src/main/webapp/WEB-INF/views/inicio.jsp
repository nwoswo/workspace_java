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
    <link rel='stylesheet' href="<%= request.getContextPath() %>/assets/css/captcha.css" />
    
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/font-awesome-4.7.0/css/font-awesome.min.css">


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/assets/js/jquery.form-validation.min.js" charset="utf-8"></script>



    <title>Secretaria Tecnica Fonavi</title>
    

</head>

<body>

<section id="captcha">


<div class="d-flex vh-100">
  <div class="d-flex w-100 justify-content-center align-self-center">
    <div class="card p-4" style="width: 30rem;">
      <div class="container ">


        <form class="form-horizontal" novalidate>



          <img class="card-img-top rounded mx-auto d-block" src="<%= request.getContextPath() %>/assets/img/banner_logIn.png"
            style="width: 243px; height: 120px;">
          <hr>
          <p class="h5 mb-4 text-center">MARCACIÓN VIRTUAL</p>

          <!-- Email -->

          <div class="form-group row">
            <label class="col col-form-label text-center" style="font-size: 40px">
            	<div id="clock5"></div>
            </label>
          </div>
          
		  <div class="form-group text-center">
		    <label for="exampleFormControlInput1 " >INGRESE SU DNI</label>
		    <input type="text"    class="form-control" id="valida1"  data-validator-label="DNI"  maxlength="8" onkeypress="return isNumber(event);"
		    data-validator="required|min:8|max:8" >
		     <div class="form-control-feedback"></div>
		  </div>
		  
		  
		  
		  <div class="form-group text-center">
		  
		    <label for="exampleFormControlInput1 " >INGRESE CAPTCHA</label>
		    <div class="captcha-code ">
		    <center>
                    <div class="code">
                        <div class="dynamic-code"></div>
                    </div>
                    <div class="captcha-reload">
                        <i class="ion-ios-loop-strong"></i>
                    </div>
                    <div class="captcha-input">
	                    <input type="text" class="form-control" id="captcha-input"  required autocomplete="off"  >
	                    <span id="errCaptcha"></span>
	                </div>
             </center>
                </div>
                  
		  </div>
		  
		  
		 
  
		  
		
     

          <!-- Sign in button -->


            <button type="button" id="marcarHora" class="btn btn-primary btn-block text-white mt-3">INGRESAR MARCACIÓN</button>
            
          <hr>

         
          <!-- Register -->

          <div class="text-center">
            <p>Secretaría Técnica FONAVI ®Todos los derechos reservados v
             1.0.0</p>
            <br>
          </div>

        </form>



      </div>
    </div>
  </div>
</div>


</section><!-- #/main -->

</body>


<div id="xmodal" class="modal" tabindex="-1" style="font-size: 25px" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>--</p>
      </div>
      <div class="modal-footer">
        
        <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar </button>
      </div>
    </div>
  </div>
</div>

<script>


(function($){$.clock={version:"2.0.1",locale:{}};t=[];$.fn.clock=function(d){var c={it:{weekdays:["Domenica","Lunedì","Martedì","Mercoledì","Giovedì","Venerdì","Sabato"],months:["Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"]},en:{weekdays:["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"],months:["January","February","March","April","May","June","July","August","September","October","November","December"]},es:{weekdays:["Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"],months:["Enero","Febrero","Marzo","Abril","May","junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"]},de:{weekdays:["Sonntag","Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag"],months:["Januar","Februar","März","April","könnte","Juni","Juli","August","September","Oktober","November","Dezember"]},fr:{weekdays:["Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"],months:["Janvier","Février","Mars","Avril","May","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"]},ru:{weekdays:["???????????","???????????","???????","?????","???????","???????","???????"],months:["??????","???????","????","??????","???","????","????","??????","????????","???????","??????","???????"]}};return this.each(function(){$.extend(c,$.clock.locale);d=d||{};d.timestamp=d.timestamp||"z";y=new Date().getTime();d.sysdiff=0;if(d.timestamp!="z"){d.sysdiff=d.timestamp-y}d.langSet=d.langSet||"en";d.format=d.format||((d.langSet!="en")?"24":"12");d.calendar=d.calendar||"true";if(!$(this).hasClass("jqclock")){$(this).addClass("jqclock");}var e=function(g){if(g<10){g="0"+g}return g;},f=function(j,n){var r=$(j).attr("id");if(n=="destroy"){clearTimeout(t[r]);}else{m=new Date(new Date().getTime()+n.sysdiff);var p=m.getHours(),l=m.getMinutes(),v=m.getSeconds(),u=m.getDay(),i=m.getDate(),k=m.getMonth(),q=m.getFullYear(),o="",z="",w=n.langSet;if(n.format=="12"){o=" AM";if(p>11){o=" PM"}if(p>12){p=p-12}if(p===0){p=12}}p=e(p);l=e(l);v=e(v);if(n.calendar!="false"){z=((w=="en")?"<span class='clockdate'>"+c[w].weekdays[u]+", "+c[w].months[k]+" "+i+", "+q+"</span>":"<span class='clockdate'>"+c[w].weekdays[u]+", "+i+" "+c[w].months[k]+" "+q+"</span>");}$(j).html(z+"<span class='clocktime'>"+p+":"+l+":"+v+o+"</span>");t[r]=setTimeout(function(){f($(j),n)},1000);}};f($(this),d);});};return this;})(jQuery);

/* Now apply on document ready to jsbin page */
$(document).ready(function(){

$.clock.locale = {"pt":{"weekdays":["Domingo","Segunda-feira", "Terça-feira","Quarta-feira","Quinta-feira","Sexta-feira", "Sábado"],"months":["Janeiro","Fevereiro","Março","Abril", "Maio","Junho","Julho","Agosto","Setembro","October","Novembro", "Dezembro"] } };

customtimestamp = new Date().getTime();

console.log(customtimestamp);

$("#clock5").clock({"timestamp":customtimestamp,"format":"24","calendar":"false"});


                                     
});


</script>
 <script src="<%= request.getContextPath() %>/assets/js/aplicacion.js" charset="utf-8"></script>

</html>

 
<!-- include the jquery ui library -->





	