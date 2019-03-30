<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header>
	     <div id="headertop">
          <div id=leftcontent>
            <div class="ltep" id="fb"><a href="#"><span class="tepcolor">FB</span></a>
            		<ul>
            			<li class="fbmenu"><a href="#">Restaurant</a></li>
            			<li class="fbmenu"><a href="#">Banquet</a></li>
            			<li class="fbmenu"><a href="#">lounge</a></li>
            		
            		</ul></div>

            <div class="ltep" id="hr"><a href="#"><span class="tepcolor">HR</span></a>
            		<ul>
            			<li class="hrmenu"><a href="#">List</a></li>
            			<li class="hrmenu"><a href="#">Schedule</a></li>
            		</ul>
                   
            </div>
          </div>
           <div id="mark"><a href="/comp"><img alt="logo" style = "max-height : 100px;" src="<c:url value="/img/hotellogo.svg" />" width="100%"></a></div> 
           <div id=rightcontent>
                <!-- <div class="rtep" id="member"><a href="#"><span class="tepcolor">Member</span></a>
                	<ul>
                		<li class="membertmenu"><a href="#">Myschedule</a></li>
                		<li class="membertmenu"><a href="#">Mypage</a></li>
                		<li class="membertmenu"><a href="#">Works</a></li>
                	</ul>
                </div> -->
                   <div class="rtep" id="front"><a href="#"><span class="tepcolor">FRONT</span></a>
                    <ul>
                    	<li class="frontmenu"><a href="#">Reservation</a></li>
                    	<li class="frontmenu"><a href="#">Checkin</a></li>
                    	<li class="frontmenu"><a href="#">Checkout</a></li>
                    	<li class="frontmenu"><a href="#">Rooms</a></li>
                    	<li class="frontmenu"><a href="#">History</a></li>
                    	<li class="frontmenu"><a href="#">Lost</a></li>
                    </ul>
                  
            </div>
                <div class="rtep" id="logistics"><a href="#"><span class="tepcolor">Logistics</span></a>
                		<li class="logisticsmenu"><a href="/peregrine/comp/logistics/contract">Constract</a></li>
                		<li class="logisticsmenu"><a href="/peregrine/comp/logistics/distributor">Distributor</a></li>
                		<li class="logisticsmenu"><a href="/peregrine/comp/logistics/material">Material</a></li>
                		<li class="logisticsmenu"><a href="#">Termination</a></li>
                </div>
               
           </div>
    </div>
	</header>
