	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



	<header>
	     <div id="headertop">
	   <div id="infobar"><div id="infobox"> <c:if test="${loginfo ne null }"> <a href="/peregrine/comp/member/mypage">${loginfo.empName}</a>님 환영합니다  <a href="/peregrine/comp/member/logout">[로그아웃]</a></c:if>
	  <c:if test="${loginfo eq null }"> <a href="/peregrine/comp/member/login" id="loginbox">로그인</a>  <a href="/peregrine/comp/member/signup" id="loginbox">[직원등록]</a></c:if></div></div>
          <div id=leftcontent>
            <div class="ltep" id="fb"><a href="#"><span class="tepcolor">FB</span></a>
            		<ul id="fbnav">
            			<li class="fbmenu navmenu"><a href="/peregrine/comp/fb/restaurant/order">Restaurant</a></li> 
            			<li class="fbmenu navmenu"><a href="/peregrine/comp/fb/banquet/list">Banquet</a></li>
            			<li class="fbmenu navmenu"><a href="#">lounge</a></li>
            		
            		</ul></div>
						
            <div class="ltep" id="hr"><a href="#"><span class="tepcolor">HR</span></a>
            		<ul id="hrnav">
            			<li class="hrmenu navmenu"><a href="#">List</a></li>
            			<li class="hrmenu navmenu"><a href="#">Schedule</a></li>
            		</ul>
                   
            </div>
          </div>
           <div id="mark"><a href="/peregrine/comp"><img alt="logo" style = "max-height : 100px;" src="<c:url value="/img/hotellogo.svg" />" width="100%"></a></div> 
           <div id=rightcontent>
                <!-- <div class="rtep" id="member"><a href="#"><span class="tepcolor">Member</span></a>
                	<ul>
                		<li class="membertmenu"><a href="#">Myschedule</a></li>
                		<li class="membertmenu"><a href="#">Mypage</a></li>
                		<li class="membertmenu"><a href="#">Works</a></li>
                	</ul>
                </div> -->
                   <div class="rtep" id="front"><a href="/peregrine/comp/front"><span class="tepcolor">FRONT</span></a>
                    <div>
                    <ul>
                    	<li class="frontmenu navmenu"><a href="#">Reservation</a></li>
                    	<li class="frontmenu navmenu"><a href="/peregrine/comp/front/checkin">Checkin</a></li>
                    	<li class="frontmenu navmenu"><a href="/peregrine/comp/front/checkout">Checkout</a></li>
                    	<li class="frontmenu navmenu"><a href="/peregrine/comp/front/rooms">Rooms</a></li>
                    	<li class="frontmenu navmenu"><a href="#">History</a></li>
                    	<li class="frontmenu navmenu"><a href="/peregrine/comp/front/lost">Lost</a></li>
                    </ul>
                    </div>
            </div>
                <div class="rtep" id="logistics"><a href="/peregrine/comp/logistics"><span class="tepcolor">Logistics</span></a>
                	<ul id="logisticsnav">
                		<li class="logisticsmenu navmenu"><a href="/peregrine/comp/logistics/contract">Constract</a></li>
                		<li class="logisticsmenu navmenu"><a href="/peregrine/comp/logistics/distributor">Distributor</a></li>
                		<li class="logisticsmenu navmenu"><a href="/peregrine/comp/logistics/material">Material</a></li>
                		<li class="logisticsmenu navmenu"><a href="#">Termination</a></li>
                	</ul>
                </div>
               
           </div>
    </div>
	</header>
