<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
	<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="style.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
</head>
<c:set var="height" scope="session" value="${(rows*35)+50}"/>
<c:set var="weight" scope="session" value="${(cols*35)+50}"/>
<style type="text/css">
	#holder{	
	 height: ${height}px;	 
	 width:${weight}px;
	 background-color:#F5F5F5;
	 border:1px solid #A4A4A4;
	 margin-left:10px;	
	}
	 #place {
	 position:relative;
	 margin:7px;
	 }
     #place a{
	 font-size:0.6em;
	 }
     #place li
     {
         list-style: none outside none;
         position: absolute;   
     }    
     #place li:hover
     {
        background-color:yellow;      
     } 
	 #place .seat{
	 background: lightgreen;
	 height:33px;
	 width:33px;
	 display:block;	 
	 }
      #place .selectedSeat
      { 
		background-color:red;      	 
      }
	   #place .selectingSeat
      { 
		background-color:grey;      	 
      }
	  #place .row-3, #place .row-4{
		margin-top:10px;
	  }
	 #seatDescription{
	 padding:0px;
	 }
	  #seatDescription li{
	  verticle-align:middle;	  
	  list-style: none outside none;
	   padding-left:35px;
	  height:35px;
	  float:left;
	  }
    </style>
	
	<script type="text/javascript">
        $(function () {
            var settings = {
                rows: ${rows},
                cols: ${cols},
                rowCssPrefix: 'row-',
                colCssPrefix: 'col-',
                seatWidth: 35,
                seatHeight: 35,
                seatCss: 'seat',
                selectedSeatCss: 'selectedSeat',
				selectingSeatCss: 'selectingSeat'
            };

            var init = function (reservedSeat) {
                var str = [], seatNo, className;
                for (i = 0; i < settings.rows; i++) {
                    for (j = 0; j < settings.cols; j++) {
                        seatNo = (i + j * settings.rows + 1);
                        className = settings.seatCss + ' ' + settings.rowCssPrefix + i.toString() + ' ' + settings.colCssPrefix + j.toString();
                        if ($.isArray(reservedSeat) && $.inArray(seatNo, reservedSeat) != -1) {
                            className += ' ' + settings.selectedSeatCss;
                        }
                        str.push('<li class="' + className + '"' +
                                  'style="top:' + (i * settings.seatHeight).toString() + 'px;left:' + (j * settings.seatWidth).toString() + 'px">' +
                                  '<a title="' + seatNo + '">' + seatNo + '</a>' +
                                  '</li>');
                    }
                }
                $('#place').html(str.join(''));
            };

            //case I: Show from starting
            //init();

            //Case II: If already booked
            var bookedSeats = [ ${booked}];
            init(bookedSeats);


            $('.' + settings.seatCss).click(function () {
			if ($(this).hasClass(settings.selectedSeatCss)){
				alert('To miejsce jest juz zarezerwowane');
			}
			else{
                $(this).toggleClass(settings.selectingSeatCss);
				}
            });

            $('#btnShow').click(function () {
                var str = [];
                $.each($('#place li.' + settings.selectedSeatCss + ' a, #place li.'+ settings.selectingSeatCss + ' a'), function (index, value) {
                    str.push($(this).attr('title'));
                });
                alert(str.join(','));
            })

            $('#btnShowNew').click(function () {
                var str = [], item;
                $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
                    item = $(this).attr('title');                   
                    str.push(item);                   
                });
                alert(str.join(','));
            })
            
             $('#submit').click(function () {
            	 document.getElementById('miejsce').value = "";
            	 $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
            		 document.getElementById('miejsce').value += $(this).attr('title') + ",";                   
                 });
            	
            })
            
        });
    
    </script>


<jsp:include page="navtab.jsp"></jsp:include>


	<h2> Wybierz interesujace Cie miejsca:</h2>	
   
    <div id="holder"> 
        <ul  id="place">
        </ul>    
    </div>
     <div style="float:left;"> 
    <ul id="seatDescription">
        <li style="background-color: lightgreen;">Wolne</li>
        <li style="background-color: red;">Zajete</li>
        <li style="background-color: grey;">Zaznaczone</li>
    </ul>
    </div>
        <div style="clear:both;width:100%"> 
        <form:form method="POST" action="${pageContext.request.contextPath}	/bookt">      
 		 	  <input type="hidden" id="miejsce" name ="miejsce" value = ""/>
   			  <input type="hidden" id="seansid" name ="seansid" value ="${idseans}"/>
   			  <input type="submit"  id="submit" value="Rezerwuj!">
        </form:form>
    </div>