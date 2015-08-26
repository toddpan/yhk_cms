<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:url var="rootUrl" value="/"/>

<html lang="en" ng-app="usersApp">

<!DOCTYPE html>

<html class="no-js" lang="en">

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width" />
		<title>Hyperion</title>

		<!-- ////////////////////////////////// -->
		<!-- //      Stylesheets Files       // -->
		<!-- ////////////////////////////////// -->
		<link rel="stylesheet" href="${rootUrl}resources/css/base.css" id="camera-css" />
		<link rel="stylesheet" href="${rootUrl}resources/css/framework.css" />
		<link rel="stylesheet" href="${rootUrl}resources/css/style.css" />
		<link rel="stylesheet" href="${rootUrl}resources/css/noscript.css" media="screen,all" id="noscript" />

		<!-- ////////////////////////////////// -->
		<!-- //      Javascript Files        // -->
		<!-- ////////////////////////////////// -->
		<!--	<script src="js/jquery.min.js"></script>-->
		<script src="${rootUrl}resources/js/utils.js">
		</script>
		<script src="${rootUrl}resources/js/validation.js"></script>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	</head>

	<body>
		<!-- header start here -->
		<header>
			<div id="main-wrapper">

				<!-- top-social start here -->
				<div id="top-social"></div>
				<a class="trigger" href="#"></a>
				<div class="social-panel">
					<ul>
						<li>
							<a href="#">
								<img src="${rootUrl}resources/admin/layout4/img/socials/social10.gif" alt="" />
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${rootUrl}resources/admin/layout4/img/socials/social32.gif" alt="" />
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${rootUrl}resources/admin/layout4/img/socials/social9.gif" alt="" />
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${rootUrl}resources/admin/layout4/img/socials/social15.gif" alt="" />
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${rootUrl}resources/admin/layout4/img/socials/social25.gif" alt="" />
							</a>
						</li>
					</ul>
				</div>
			</div>

			<!-- top-social end here -->

			<!-- logo start here -->
			<div id="logo">
				<a href="index.html">
					<img src="${rootUrl}resources/admin/layout4/img/huimeilogo.jpg" alt="mainlogo" />
				</a>
			</div>
			<!-- logo end here -->

			<!-- mainmenu start here -->
			<nav id="mainmenu">
				<ul id="menu">
					<li><a href="${rootUrl}index">首页</a>

					</li>


					<li class="dropdown"><a href="prescription.html">处方和诊断</a>
						<ul>
							<li><a href=""><span>-</span> 王建国</a>
							</li>
							
						</ul>
					</li>
					<li class="dropdown"><a href="">知识库</a>
					</li>
					<li><a href="">医生交流</a>
					</li>
					<li class="dropdown" hidden="true"><a href="#">pages</a>
						<ul>
							
						</ul>
					</li>
				</ul>
			</nav>
			<!-- mainmenu end here -->

		</header>
		<!-- header end here -->

		<!-- pagetitle start here -->

		<!-- pagetitle end here -->

		<!-- breadcrumb start here -->

		<!-- breadcrumb end here -->

		<!-- maincontent start here -->
		<section id="content-wrapper">
			<div class="row">
				<div class="eight columns">
					<!-- blog post 1 -->

					<!--Begin sharing box-->

					<!-- Begin of Comment -->
					<div id="comment">
						<h5>基本信息</h5>
						<ol class="commentlist">
							<li>
								<div class="avatar">
									<img src="${rootUrl}resources/admin/layout4/img/sample-images/testi-people4.png" alt="" />
								</div>

								<div class="comment-text">
									<h5>${user.userRealname}</h5>
									<div class="four columns">
										<ul class="disc">
											<li>性别：${user.gender}</li>
											<li>年龄：${user.age}</li>
											<li>职业：${user.profession}</li>
											<li>婚姻：${user.marritalStatus}</li>
											<li>地址：${user.mailingAddress}</li>
										</ul>
									</div>
									<div class="four columns">
										<ul class="disc">
											<li>病案No：${user.diseaseNo}</li>
											<li>保险：${userVisitSummary.orderBy}</li>
											<li>药物过敏：
												${drugAllergies}
											</li>
											<li>环境过敏：${envAllergies}</li>
											<li>电话：${user.mobile}</li>
										</ul>
									</div>
									<div class="four columns">
										<ul class="disc">
											<li>就诊次数：${userClinicHistory.sumCount}</li>
											<li>饮食习惯：${userHabit.nutritionHabit}</li>
											<li>运动习惯：${userHabit.sportHabit}</li>
											<li>已诊断疾病：${diseases}</li>
										</ul>
									</div>

								</div>

							</li>
							<br />
							<br />
							<br />

							<div class="twelve columns" id="contextPanel">
								<h5>关键指标</h5>
								<table id="indicatorPanel">
									<c:forEach var="obj" items="${importanceExamItems}" varStatus="status"></c:forEach>
									<tr>
										<td>
											<label>${obj.viewName}</label>
											<input type="text" class="edit" value="${obj.examinationValue} "

												   style="color: red;"/>
										</td>

									<c:if test="${ status.index==4}">
									</tr>
									<tr>
										</c:if>

							</table>
							<a href="" class="button medium gray">保存</a>
</div>
						</ol>
					</div>
 
 <div class="eight columns" id="monitor" >            
           <h5>实验室检查</h5> <ul >
  <li class="square" id="GLU">一周血糖监测谱</li> 
   </ul >
   </div><div class="table-green">
   <table class="table" id="GLUResult">
                          <thead>
                              <tr>
                              	<th>日期</th>
                                <th>早餐前</th>
                                <th>早餐后</th>
                                <th>睡觉前</th>
                                <th>运动前</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                              	<td>7.20</td>
                                <td>4.5</td>
                                <td>6.5</td>
                                <td id="highGL" style="color: red;">15.5</td>
                                <td>7</td>
                              </tr>  
                               <tr class="odd">
                              	<td >7.21</td>
                                <td>4.5</td>
                                <td>6.5</td>
                                <td>7.5</td>
                                <td>7</td>
                              </tr> 
                               <tr>
                              	<td>7.22</td>
                                <td>4.5</td>
                                <td>6.5</td>
                                <td>7.5</td>
                                <td>7</td>
                              </tr> 
                               <tr class="odd">
                              	<td>7.23</td>
                                <td>4.5</td>
                                <td>6.5</td>
                                <td>7.5</td>
                                <td>7</td>
                              </tr> 
                               <tr>
                              	<td>7.24</td>
                                <td>4.5</td>
                                <td>6.5</td>
                                <td>7.5</td>
                                <td>7</td>
                              </tr> 
                                    <tr class="odd">
                              	<td>7.25</td>
                                <td>4.5</td>
                                <td>6.5</td>
                                <td>7.5</td>
                                <td>7</td>
                              </tr> 
                               <tr>
                              	<td>7.26</td>
                                <td>4.5</td>
                                <td>6.5</td>
                                <td>7.5</td>
                                <td>7</td>
                              </tr> 
                          </tbody>
                        </table>
  </div>
  
  
  
	  <div class="eight columns" id="labTab">            
           <h5>实验室检查</h5><div class="info">点击查看结果</div>
            <ul >
                <li class="square" id="bloodfat">血脂四项</li>  
           <li class="square" id="a1c">糖化血红蛋白</li>
          <li class="square" id="bp">血压</li>
          <li class="square" id="glucose">血糖</li> 
          
           </ul >
        </div>
        <div id="labShow" class="table-green">
        	<div id="labShowChild"></div>
        </div>
					<!-- Begin of Comment Form -->
					 <div class="table-green" id="labResult">
                       <!-- <h5>血脂四项</h5>-->
                        <table class="table" id="bloodfatResult">
                          <thead>
                              <tr>
                                <th>检查项</th>
                                <th>2015.02</th>
                                <th>2014.10</th>
                                <th>2014.04</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                                <td>TC</td>
                                <td>2.96</td>
                                <td>3.50</td>
                                <td>5.31</td>
                              </tr>
                              <tr class="odd">
                                <td>TG</td>
                                <td>1.42</td>
                                <td>2.12</td>
                                <td>1.58</td>
                              </tr>
                              <tr>
                                <td>HDL</td>
                                <td>0.91</td>
                                <td>1.20</td>
                                <td>1.17</td>
                              </tr>   
                               <tr class="odd">
                                <td>LDL</td>
                                <td>2.57</td>
                                <td>1.70</td>
                                <td>3.29</td>
                              </tr> 
                          </tbody>
                        </table>
                   
                    
                   
                       <!-- <h5>糖化血红蛋白</h5>-->
                        <table class="table" id="a1cResult">
                          <thead>
                              <tr>
                                <th>检查项</th>
                                <th>2015.02</th>
                                <th>2014.10</th>
                                <th>2014.04</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                                <td>A1C</td>
                                <td>7</td>
                                <td>7.2</td>
                                <td>7.5</td>
                              </tr>                             
                          </tbody>
                        </table>
                   
                       <!-- <h5>glucose</h5>-->
                        <table class="table" id="glucoseResult">
                          <thead>
                              <tr>
                                <th>检查项</th>
                                <th>2015.02</th>
                                <th>2014.10</th>
                                <th>2014.04</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                                <td>血糖</td>
                                <td>5.10</td>
                                <td>7.46</td>
                                <td>8.43</td>
                              </tr>                             
                          </tbody>
                        </table>
                   
                       <!-- <h5>glucose</h5>-->
                        <table class="table" id="bpResult">
                          <thead>
                              <tr>
                                <th>检查项</th>
                                <th>2015.02</th>
                                <th>2014.10</th>
                                <th>2014.04</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                                <td>BP</td>
                                <td>111/78</td>
                                <td>150/95</td>
                                <td>180/100</td>
                              </tr>                             
                          </tbody>
                        </table>
                             
           
                       <!-- <h5>血脂四项</h5>-->
                       
                             
        </div>
				</div>


 

				
			<div class="four columns">		
				<aside>
					 <div class="testi-container">                        	
                        <div class="testi-text">
                        	<h6>就诊历史</h6>
                           <ul >
                           	<li><strong>2012.8 上感，支气管炎 </strong>  </li>
                           	<li >医师：李时珍</li>
                           		<li >血常规, C反应蛋白</li>  <li>    泰诺</li>
                           	<li ><strong>2013.8 腹泻</strong></li>
                           	<li>医师：李时珍</li>
                           		<li>血常规, 尿便常规</li>  <li> 左氧氟沙星，整肠生</li>
                           </ul>
                            
                        </div>
                        
                        <div class="clear"></div>                                                                     
                    </div>
                     <div class="testi-container">                        	
                        <div class="testi-text">
                        	<h6>既往史</h6>
                           <ul>
                           	<li>2012.10 糖尿病</li>
                           	<li>2013.11 甲亢</li>
                           </ul>
                            
                        </div>
                        
                        <div class="clear"></div>                                                                     
                    </div>
						 <div class="testi-container">                        	
                        <div class="testi-text">
                        	<h6>家族史</h6>
                           <ul>
                           	<li>父 糖尿病</li>
                           	<li>母 高血压</li>
                           </ul>
                            
                        </div>
                        
                        <div class="clear"></div>                                                                     
                    </div>
                    <div class="testi-container">                        	
                        <div class="testi-text">
                        	<h6>用药情况</h6>
                           <ul>
                           	<li><strong>2015.1-2015.7 </strong></li>
                           	<li>二甲双胍 50mg 1日3次</li>
                           	<li>胰岛素 20mg 1日1次</li>
                           	<li><strong>2014.7-2014.12 </strong></li>
                           	<li>二甲双胍 50mg 1日3次</li>
                           </ul>                            
                        </div>                        
                        <div class="clear"></div>                                                                     
                    </div>
				</aside>				
			

							</div>
					</div>
		</section>
		<!-- maincontent end here -->

		<!-- footer start here -->
		<footer>
			<div class="row">
				<div class="three columns mobile-two">
					<img src="${rootUrl}resources/admin/layout4/img/huimeilogo.jpg" alt="" class="img-left" />
					<p class="copyright-text">&copy; Copyright &copy; 2013.Company name All rights reserved.<a target="_blank" href="http://www.mycodes.net/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a> - More Templates <a href="http://www.mycodes.net/" target="_blank" title="源码之家">源码之家</a>
					</p>
				</div>
				<div class="three columns mobile-two">
					<h5>地址</h5>
					<ul>
						<li class="address-icon">中城写字楼
							<br />300室
							<br />海淀区花园路25号</li>
						<li class="phone-icon">Phone : +621 55566671</li>
						<li class="email-icon">Email : info@huimeitimes.com</li>
					</ul>
				</div>
				<div class="three columns mobile-two">
					<h5>Company</h5>
					<ul>
						<li><a href="#">关于惠每</a>
						</li>
						<li><a href="#">Career</a>
						</li>
						<li><a href="#">Press &amp; Media</a>
						</li>
						<li><a href="#">Environmental Impact</a>
						</li>
						<li><a href="#">Affiliate Program</a>
						</li>
						<li><a href="#">Privacy Policy</a>
						</li>
					</ul>
				</div>
				<div class="three columns mobile-two">
					<h5>Flickr</h5>
					<ul id="flck-thumb" class="thumbs">
						<li class="no-image"></li>
					</ul>

					<!-- Noscript Notification when your Javascript not active -->
					<div id="flickr-noscript">
						<p>Can't load Flickr feed, please activate your javascript first...</p>
					</div>
					<!-- End of Noscript Notification when your Javascript not active -->
				</div>
			</div>
		</footer>

	</body>

</html>