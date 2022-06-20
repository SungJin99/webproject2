var xhr = new XMLHttpRequest();
var selectDoctor;
var selectDate;
var selectTime=[];
var clicked=0;
var maxPeopleOfDate=60;
var maxPeopleOfTime=2;
var date = new Date();
function setDoctor(doctor){
	doctor = doctor;
}
function nextYear(){
	console.log(year);
	var year= document.getElementById('year').innerHTML;
	var month=document.getElementById('month').innerHTML;
	year*=1;
	year+=1;
	console.log(year+"nextyear");
	if(year<=2050){
		clearDateAndButton();
		var doctor=selectDoctor;
		showDate(selectDoctor,month,year);
		document.getElementById('year').innerHTML=year;
	}else{
		year=2050;
		alert('마지막년도 입니다');
	}
}
function beforeYear(){
	console.log(year);
	var year=document.getElementById('year').innerHTML;
	var month=document.getElementById('month').innerHTML;
	year*=1;
	year-=1;
	console.log(year+"beforeYear");
	if(year>= date.getFullYear()){
		clearDateAndButton();
		var doctor=selectDoctor;
		showDate(selectDoctor,month,year);
		document.getElementById('year').innerHTML=year;
	}else{
		alert('처음년도 입니다');
	}
}
function nextMonth(){
console.log(month);
var month=document.getElementById('month').innerHTML;
month*=1;
month+=1;
console.log(month+"nextMonth");
if(month<=12){
	clearDateAndButton();
	var year = document.getElementById('year').innerHTML;
	var doctor=selectDoctor;
	showDate(selectDoctor,month,year);
	document.getElementById('month').innerHTML=month;
}else{
	alert('마지막월 입니다');
	}
}
function beforeMonth(){
	console.log(month);
	var month=document.getElementById('month').innerHTML;
	month*=1;
	month-=1;
	console.log(month+"nextMonth");
	if(year>date.getFullYear()&&month>=1){
		clearDateAndButton();
		var year=document.getElementById('year').innerHTML;
		showDate(selectDoctor,month,year);
		document.getElementById('month').innerHTML;
	}
	else if(month>date.getMonth()){
		clearDateAndButton();
		var year = document.getElementById('year').innerHTML;
		showDate(selectDoctor,month,year);
		document.getElementById('month').innerHTML;
	}else{
		month=date.getMonth();
		alert('마지막월 입니다');
	}
}
function showMonth(doctor){
	document.getElementById('month').innerHTML=date.getMonth()+1;
	document.getElementById('year').innerHTML=date.getFullYear();
	var month=document.getElementById('month').innerHTML;
	var year=document.getElementById('year').innerHTML;
	selectDoctor=doctor;
	clearDateAndButton();
	document.getElementById('dayArea').innerHTML=("<th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th><th>일</th>");
	showDate(doctor,month,year);
}
function showDate(doctor,month,year){
	doctor=doctor;
	console.log(doctor);
	console.log(month+'showDate');
	let date=JSON.stringify({
		"doctor":doctor,
		"month":month,
		"year":year
	});
	xhr.open('POST','/getDateBySeat',true);
	xhr.setRequestHeader("Content-Type",'application/json');
	xhr.withCredentials = true;
	xhr.send(data);
	xhr.onload=function(){
		if(xhr.status==200){
			var result=JSON.parse(xhr.response);
			var dates=result.dates;
			console.log(dates);
			$('#dateArea').empty();
			$('#nextButton').append("<input type = 'button' value='다음달' onclick='nextMonth()'>");
			$('#beforeButton').append("<input type = 'button' value='이전달' onclick='beforeMonth()'>");
			$('#nextButton2').append("<input type = 'button' value='다음년도' onclick='nextYear()'>");
			$('#beforeButton2').append("<input type = 'button' value='이전년도' onclick='beforeYear()'>");
			var num = 1;
			for(var i = 1; i < dates.length; i++){
				if(dates[i][2]==100){
					$('#dateArea'+num).append("<td><input type= 'button' id = 'date' onclick='getTime("+dates[i][0]+")'value='"+dates[i][0]+"'disabled></td>");
				}
				else{
					$('#dateArea'+num).append("<td><input type= 'button' id = 'date' onclick='getTime("+dates[i][0]+")'value='"+dates[i][0]+"'></td>");
				}
				if(i%7==0){
					num+=1;
				}
			}
		}else{
			alert('통신 실패');
		}
	}
}
function getTime(date){
	console.log(selectDoctor+'getTime');
	console.log(date+'getTime');
	console.log(document.getElementById('month').innerHTML+"gettime");
	selectDate=date;
	let date=JSON.stringify({
		"seat":selectSeat,
		"date":selectDate,
		"month":document.getElementById('month').innerHTML,
		"year":document.getElementById('year').innerHTML
	});
	xhr.open('POST','/getTimeByDate',true);
	xhr.setRequestHeader("Content-Type",'application/json');
	xhr.withCredentials = true;
	xhr.send(data);
	xhr.onload=function(){
		if(xhr.status==200){
			$('#timeArea').empty();
			$('#insertOrCancle').empty();
			var result=JSON.parse(xhr.response);
			var times=result.times;
			for(var i = 0; i < times.length; i++){
				if(times[i][2]==100){
					console.log('시간이 지났거나 예약이 다참');
					$('#timeArea').append("<input type = 'checkbox' name = 'time' value'"+times[i][0]+"'disabled>"+times[i][0]+'시~'+time[i][0]+'시'+times[i][1]+"/"+maxPeopleOfTime+"&nbsp;");
				}
				else{
					$('#timeArea').append("<input type = 'checkbox' name = 'time' value'"+times[i][0]+"'>"+times[i][0]+'시~'+time[i][0]+'시'+times[i][1]+"/"+maxPeopleOfTime+"&nbsp;");
				}
				if(i>=3 && i%3==0){
					$('#timeArea').append('<br>');
				}
			}
			$('#insertOrCancle').append("<input type = 'button' onclick='buy()' value = '예약하기'>");
		}else{
			alert('통신 실패');
		}
	}
			
}
/*!
* Start Bootstrap - Creative v7.0.6 (https://startbootstrap.com/theme/creative)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-creative/blob/master/LICENSE)
*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 74,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

    // Activate SimpleLightbox plugin for portfolio items
    new SimpleLightbox({
        elements: '#portfolio a.portfolio-box'
    });

});

    (function($) {
    "use strict";

    // Add active state to sidbar nav links
    var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
        $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
            if (this.href === path) {
                $(this).addClass("active");
            }
        });

    // Toggle the side navigation
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });
})(jQuery);
