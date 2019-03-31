<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header>
             <div id="headertop">
              <div id=leftcontent>
                <div class="ltep" id="room"><a href="#"><span class="tepcolor">Room</span></a>
                        <ul>
                            <li class="roommenu"><a href="#">Introduce</a></li>
                            <li class="roommenu"><a href="#">Reservation</a></li>
                        
                        </ul></div>
                <div class="ltep" id="restaurant"><a href="#"><span class="tepcolor">Restaurant</span></a>
                        <ul>
                                <li class="Restaurantmenu"><a href="#">Introduce</a></li>
                                <li class="Restaurantmenu"><a href="/peregrine/restaurant/reservation/cusinfo">Reservation</a></li>
                        </ul>
                      
                </div>
              
              </div>
               <div id="mark"><img alt="logo" style = "max-height : 100px;" src="<c:url value="/img/hotellogo.svg" />" width="100%" onclick="location.href='/peregrine/main'"></div> 
               <div id=rightcontent>
                    <div class="rtep" id="banquet"><a href="#"><span class="tepcolor">Banquet</span></a>
                        <ul>
                            <li class="banquetmenu"><a href="#">Introduce</a></li>
                            
                        </ul>
                       
                </div>
                
                
                
                
                <div class="rtep" id="About"><a href="#"><span class="tepcolor">About Us</span></a>
                        <ul>
                            <li class="Aboutmenu"><a href="#">Introduce</a></li>
                            <li class="Aboutmenu"><a href="#">way to come</a></li>
                        </ul>
                    </div>
                   
                   
               </div>
        </div>
        </header>