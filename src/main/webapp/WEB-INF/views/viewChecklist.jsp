<%@page pageEncoding="utf-8" %>

<!DOCTYPE html>
<!--
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.4
Version: 4.0.2
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8"/>
	<title>Metronic | Form Stuff - Form Layouts</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<meta content="" name="description"/>
	<meta content="" name="author"/>
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
	<link href="${rootUrl}resources/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="${rootUrl}resources/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
	<link href="${rootUrl}resources/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${rootUrl}resources/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
	<link href="${rootUrl}resources/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link rel="stylesheet" type="text/css" href="${rootUrl}/resources/global/plugins/select2/select2.css"/>
	<!-- END PAGE LEVEL SCRIPTS -->
	<!-- BEGIN THEME STYLES -->
	<link href="${rootUrl}resources/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css"/>
	<link href="${rootUrl}resources/global/css/plugins.css" rel="stylesheet" type="text/css"/>
	<link href="${rootUrl}resources/admin/layout4/css/layout.css" rel="stylesheet" type="text/css"/>
	<link id="style_color" href="${rootUrl}/resources/admin/layout4/css/themes/light.css" rel="stylesheet" type="text/css"/>
	<link href="${rootUrl}resources/admin/layout4/css/custom.css" rel="stylesheet" type="text/css"/>
	<!-- END THEME STYLES -->
	<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-sidebar-closed-hide-logo ">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="#">
				<img src="${rootUrl}/resources/admin/layout4/img/logo-light.png" alt="logo" class="logo-default"/>
			</a>
			<div class="menu-toggler sidebar-toggler">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN PAGE ACTIONS -->
		<!-- DOC: Remove "hide" class to enable the page header actions -->
		<div class="page-actions">
			<div class="btn-group">
				<button type="button" class="btn red-haze btn-sm dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<span class="hidden-sm hidden-xs">Actions&nbsp;</span><i class="fa fa-angle-down"></i>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li>
						<a href="javascript:;">
							<i class="icon-docs"></i> New Post </a>
					</li>
					<li>
						<a href="javascript:;">
							<i class="icon-tag"></i> New Comment </a>
					</li>
					<li>
						<a href="javascript:;">
							<i class="icon-share"></i> Share </a>
					</li>
					<li class="divider">
					</li>
					<li>
						<a href="javascript:;">
							<i class="icon-flag"></i> Comments <span class="badge badge-success">4</span>
						</a>
					</li>
					<li>
						<a href="javascript:;">
							<i class="icon-users"></i> Feedbacks <span class="badge badge-danger">2</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- END PAGE ACTIONS -->
		<!-- BEGIN PAGE TOP -->
		<div class="page-top">
			<!-- BEGIN HEADER SEARCH BOX -->
			<!-- DOC: Apply "search-form-expanded" right after the "search-form" class to have half expanded search box -->
			<form class="search-form" action="extra_search.html" method="GET">
				<div class="input-group">
					<input type="text" class="form-control input-sm" placeholder="Search..." name="query">
					<span class="input-group-btn">
					<a href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></a>
					</span>
				</div>
			</form>
			<!-- END HEADER SEARCH BOX -->
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<li class="separator hide">
					</li>
					<!-- BEGIN NOTIFICATION DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-notification dropdown-dark" id="header_notification_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
							<i class="icon-bell"></i>
						<span class="badge badge-success">
						7 </span>
						</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3><span class="bold">12 pending</span> notifications</h3>
								<a href="extra_profile.html">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
									<li>
										<a href="javascript:;">
											<span class="time">just now</span>
										<span class="details">
										<span class="label label-sm label-icon label-success">
										<i class="fa fa-plus"></i>
										</span>
										New user registered. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span class="time">3 mins</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Server #12 overloaded. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span class="time">10 mins</span>
										<span class="details">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
										Server #2 not responding. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span class="time">14 hrs</span>
										<span class="details">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
										Application error. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span class="time">2 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Database overloaded 68%. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span class="time">3 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										A user IP blocked. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span class="time">4 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
										Storage Server #4 not responding dfdfdfd. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span class="time">5 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
										System Error. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
											<span class="time">9 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Storage server failed. </span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END NOTIFICATION DROPDOWN -->
					<li class="separator hide">
					</li>
					<!-- BEGIN INBOX DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-inbox dropdown-dark" id="header_inbox_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
							<i class="icon-envelope-open"></i>
						<span class="badge badge-danger">
						4 </span>
						</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3>You have <span class="bold">7 New</span> Messages</h3>
								<a href="inbox.html">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="${rootUrl}/resources/admin/layout3/img/avatar2.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Lisa Wong </span>
										<span class="time">Just Now </span>
										</span>
										<span class="message">
										Vivamus sed auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="${rootUrl}/resources/admin/layout3/img/avatar3.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Richard Doe </span>
										<span class="time">16 mins </span>
										</span>
										<span class="message">
										Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="${rootUrl}/resources/admin/layout3/img/avatar1.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Bob Nilson </span>
										<span class="time">2 hrs </span>
										</span>
										<span class="message">
										Vivamus sed nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="${rootUrl}/resources/admin/layout3/img/avatar2.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Lisa Wong </span>
										<span class="time">40 mins </span>
										</span>
										<span class="message">
										Vivamus sed auctor 40% nibh congue nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox.html?a=view">
										<span class="photo">
										<img src="${rootUrl}/resources/admin/layout3/img/avatar3.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Richard Doe </span>
										<span class="time">46 mins </span>
										</span>
										<span class="message">
										Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END INBOX DROPDOWN -->
					<li class="separator hide">
					</li>
					<!-- BEGIN TODO DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-extended dropdown-tasks dropdown-dark" id="header_task_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
							<i class="icon-calendar"></i>
						<span class="badge badge-primary">
						3 </span>
						</a>
						<ul class="dropdown-menu extended tasks">
							<li class="external">
								<h3>You have <span class="bold">12 pending</span> tasks</h3>
								<a href="page_todo.html">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">New release v1.2 </span>
										<span class="percent">30%</span>
										</span>
										<span class="progress">
										<span style="width: 40%;" class="progress-bar progress-bar-success" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">40% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Application deployment</span>
										<span class="percent">65%</span>
										</span>
										<span class="progress">
										<span style="width: 65%;" class="progress-bar progress-bar-danger" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">65% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Mobile app release</span>
										<span class="percent">98%</span>
										</span>
										<span class="progress">
										<span style="width: 98%;" class="progress-bar progress-bar-success" aria-valuenow="98" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">98% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Database migration</span>
										<span class="percent">10%</span>
										</span>
										<span class="progress">
										<span style="width: 10%;" class="progress-bar progress-bar-warning" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">10% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Web server upgrade</span>
										<span class="percent">58%</span>
										</span>
										<span class="progress">
										<span style="width: 58%;" class="progress-bar progress-bar-info" aria-valuenow="58" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">58% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Mobile development</span>
										<span class="percent">85%</span>
										</span>
										<span class="progress">
										<span style="width: 85%;" class="progress-bar progress-bar-success" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">85% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">New UI release</span>
										<span class="percent">38%</span>
										</span>
										<span class="progress progress-striped">
										<span style="width: 38%;" class="progress-bar progress-bar-important" aria-valuenow="18" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">38% Complete</span></span>
										</span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END TODO DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-user dropdown-dark">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<span class="username username-hide-on-mobile">
						Nick </span>
							<!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
							<img alt="" class="img-circle" src="${rootUrl}/resources/admin/layout4/img/avatar9.jpg"/>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="extra_profile.html">
									<i class="icon-user"></i> My Profile </a>
							</li>
							<li>
								<a href="page_calendar.html">
									<i class="icon-calendar"></i> My Calendar </a>
							</li>
							<li>
								<a href="inbox.html">
									<i class="icon-envelope-open"></i> My Inbox <span class="badge badge-danger">
								3 </span>
								</a>
							</li>
							<li>
								<a href="page_todo.html">
									<i class="icon-rocket"></i> My Tasks <span class="badge badge-success">
								7 </span>
								</a>
							</li>
							<li class="divider">
							</li>
							<li>
								<a href="extra_lock.html">
									<i class="icon-lock"></i> Lock Screen </a>
							</li>
							<li>
								<a href="login.html">
									<i class="icon-key"></i> Log Out </a>
							</li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							<h4 class="modal-title">Modal title</h4>
						</div>
						<div class="modal-body">
							Widget settings form goes here
						</div>
						<div class="modal-footer">
							<button type="button" class="btn blue">Save changes</button>
							<button type="button" class="btn default" data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE HEADER-->
			<!-- BEGIN PAGE HEAD -->
			<div class="page-head">
				<!-- BEGIN PAGE TITLE -->
				<div class="page-title">
					<h1>Basic Datatables <small>basic datatable samples</small></h1>
				</div>
				<!-- END PAGE TITLE -->
				<!-- BEGIN PAGE TOOLBAR -->
				<div class="page-toolbar">
					<!-- BEGIN THEME PANEL -->
					<div class="btn-group btn-theme-panel">
						<a href="javascript:;" class="btn dropdown-toggle" data-toggle="dropdown">
							<i class="icon-settings"></i>
						</a>
						<div class="dropdown-menu theme-panel pull-right dropdown-custom hold-on-click">
							<div class="row">
								<div class="col-md-4 col-sm-4 col-xs-12">
									<h3>THEME</h3>
									<ul class="theme-colors">
										<li class="theme-color theme-color-default active" data-theme="default">
											<span class="theme-color-view"></span>
											<span class="theme-color-name">Dark Header</span>
										</li>
										<li class="theme-color theme-color-light" data-theme="light">
											<span class="theme-color-view"></span>
											<span class="theme-color-name">Light Header</span>
										</li>
									</ul>
								</div>
								<div class="col-md-8 col-sm-8 col-xs-12 seperator">
									<h3>LAYOUT</h3>
									<ul class="theme-settings">
										<li>
											Theme Style
											<select class="layout-style-option form-control input-small input-sm">
												<option value="square" selected="selected">Square corners</option>
												<option value="rounded">Rounded corners</option>
											</select>
										</li>
										<li>
											Layout
											<select class="layout-option form-control input-small input-sm">
												<option value="fluid" selected="selected">Fluid</option>
												<option value="boxed">Boxed</option>
											</select>
										</li>
										<li>
											Header
											<select class="page-header-option form-control input-small input-sm">
												<option value="fixed" selected="selected">Fixed</option>
												<option value="default">Default</option>
											</select>
										</li>
										<li>
											Top Dropdowns
											<select class="page-header-top-dropdown-style-option form-control input-small input-sm">
												<option value="light">Light</option>
												<option value="dark" selected="selected">Dark</option>
											</select>
										</li>
										<li>
											Sidebar Mode
											<select class="sidebar-option form-control input-small input-sm">
												<option value="fixed">Fixed</option>
												<option value="default" selected="selected">Default</option>
											</select>
										</li>
										<li>
											Sidebar Menu
											<select class="sidebar-menu-option form-control input-small input-sm">
												<option value="accordion" selected="selected">Accordion</option>
												<option value="hover">Hover</option>
											</select>
										</li>
										<li>
											Sidebar Position
											<select class="sidebar-pos-option form-control input-small input-sm">
												<option value="left" selected="selected">Left</option>
												<option value="right">Right</option>
											</select>
										</li>
										<li>
											Footer
											<select class="page-footer-option form-control input-small input-sm">
												<option value="fixed">Fixed</option>
												<option value="default" selected="selected">Default</option>
											</select>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- END THEME PANEL -->
				</div>
				<!-- END PAGE TOOLBAR -->
			</div>
			<!-- END PAGE HEAD -->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li>
					<a href="index.html">Home</a>
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<a href="#">Data Tables</a>
					<i class="fa fa-circle"></i>
				</li>
				<li>
					<a href="#">Basic Datatables</a>
				</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-6">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet box red">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>Simple Table
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-hover">
									<thead>
									<tr>
										<th>
											#
										</th>
										<th>
											First Name
										</th>
										<th>
											Last Name
										</th>
										<th>
											Username
										</th>
										<th>
											Status
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>
											1
										</td>
										<td>
											Mark
										</td>
										<td>
											Otto
										</td>
										<td>
											makr124
										</td>
										<td>
										<span class="label label-sm label-success">
										Approved </span>
										</td>
									</tr>
									<tr>
										<td>
											2
										</td>
										<td>
											Jacob
										</td>
										<td>
											Nilson
										</td>
										<td>
											jac123
										</td>
										<td>
										<span class="label label-sm label-info">
										Pending </span>
										</td>
									</tr>
									<tr>
										<td>
											3
										</td>
										<td>
											Larry
										</td>
										<td>
											Cooper
										</td>
										<td>
											lar
										</td>
										<td>
										<span class="label label-sm label-warning">
										Suspended </span>
										</td>
									</tr>
									<tr>
										<td>
											4
										</td>
										<td>
											Sandy
										</td>
										<td>
											Lim
										</td>
										<td>
											sanlim
										</td>
										<td>
										<span class="label label-sm label-danger">
										Blocked </span>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
				<div class="col-md-6">
					<!-- BEGIN BORDERED TABLE PORTLET-->
					<div class="portlet box yellow">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-coffee"></i>Bordered Table
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-bordered table-hover">
									<thead>
									<tr>
										<th>
											#
										</th>
										<th>
											First Name
										</th>
										<th>
											Last Name
										</th>
										<th>
											Username
										</th>
										<th>
											Status
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td rowspan="2">
											1
										</td>
										<td>
											Mark
										</td>
										<td>
											Otto
										</td>
										<td>
											makr124
										</td>
										<td>
										<span class="label label-sm label-success">
										Approved </span>
										</td>
									</tr>
									<tr>
										<td>
											Jacob
										</td>
										<td>
											Nilson
										</td>
										<td>
											jac123
										</td>
										<td>
										<span class="label label-sm label-info">
										Pending </span>
										</td>
									</tr>
									<tr>
										<td>
											2
										</td>
										<td>
											Larry
										</td>
										<td>
											Cooper
										</td>
										<td>
											lar
										</td>
										<td>
										<span class="label label-sm label-warning">
										Suspended </span>
										</td>
									</tr>
									<tr>
										<td>
											3
										</td>
										<td>
											Sandy
										</td>
										<td>
											Lim
										</td>
										<td>
											sanlim
										</td>
										<td>
										<span class="label label-sm label-danger">
										Blocked </span>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END BORDERED TABLE PORTLET-->
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet box purple">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-comments"></i>Striped Table
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-striped table-hover">
									<thead>
									<tr>
										<th>
											#
										</th>
										<th>
											First Name
										</th>
										<th>
											Last Name
										</th>
										<th>
											Username
										</th>
										<th>
											Status
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>
											1
										</td>
										<td>
											Mark
										</td>
										<td>
											Otto
										</td>
										<td>
											makr124
										</td>
										<td>
										<span class="label label-sm label-success">
										Approved </span>
										</td>
									</tr>
									<tr>
										<td>
											2
										</td>
										<td>
											Jacob
										</td>
										<td>
											Nilson
										</td>
										<td>
											jac123
										</td>
										<td>
										<span class="label label-sm label-info">
										Pending </span>
										</td>
									</tr>
									<tr>
										<td>
											3
										</td>
										<td>
											Larry
										</td>
										<td>
											Cooper
										</td>
										<td>
											lar
										</td>
										<td>
										<span class="label label-sm label-warning">
										Suspended </span>
										</td>
									</tr>
									<tr>
										<td>
											4
										</td>
										<td>
											Sandy
										</td>
										<td>
											Lim
										</td>
										<td>
											sanlim
										</td>
										<td>
										<span class="label label-sm label-danger">
										Blocked </span>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
				<div class="col-md-6">
					<!-- BEGIN CONDENSED TABLE PORTLET-->
					<div class="portlet box green">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-picture"></i>Condensed Table
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-condensed table-hover">
									<thead>
									<tr>
										<th>
											#
										</th>
										<th>
											First Name
										</th>
										<th>
											Last Name
										</th>
										<th>
											Username
										</th>
										<th>
											Status
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>
											1
										</td>
										<td>
											Mark
										</td>
										<td>
											Otto
										</td>
										<td>
											makr124
										</td>
										<td>
										<span class="label label-sm label-success">
										Approved </span>
										</td>
									</tr>
									<tr>
										<td>
											2
										</td>
										<td>
											Jacob
										</td>
										<td>
											Nilson
										</td>
										<td>
											jac123
										</td>
										<td>
										<span class="label label-sm label-info">
										Pending </span>
										</td>
									</tr>
									<tr>
										<td>
											3
										</td>
										<td>
											Larry
										</td>
										<td>
											Cooper
										</td>
										<td>
											lar
										</td>
										<td>
										<span class="label label-sm label-warning">
										Suspended </span>
										</td>
									</tr>
									<tr>
										<td>
											4
										</td>
										<td>
											Sandy
										</td>
										<td>
											Lim
										</td>
										<td>
											sanlim
										</td>
										<td>
										<span class="label label-sm label-danger">
										Blocked </span>
										</td>
									</tr>
									<tr>
										<td>
											5
										</td>
										<td>
											Sandy
										</td>
										<td>
											Lim
										</td>
										<td>
											sanlim
										</td>
										<td>
										<span class="label label-sm label-danger">
										Blocked </span>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END CONDENSED TABLE PORTLET-->
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-comments"></i>Contextual Rows
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-bordered table-hover">
									<thead>
									<tr>
										<th>
											#
										</th>
										<th>
											Class Name
										</th>
										<th>
											Column
										</th>
										<th>
											Column
										</th>
										<th>
											Column
										</th>
									</tr>
									</thead>
									<tbody>
									<tr class="active">
										<td>
											1
										</td>
										<td>
											active
										</td>
										<td>
											Column heading
										</td>
										<td>
											Column heading
										</td>
										<td>
											Column heading
										</td>
									</tr>
									<tr class="success">
										<td>
											2
										</td>
										<td>
											success
										</td>
										<td>
											Column heading
										</td>
										<td>
											Column heading
										</td>
										<td>
											Column heading
										</td>
									</tr>
									<tr class="warning">
										<td>
											3
										</td>
										<td>
											warning
										</td>
										<td>
											Column heading
										</td>
										<td>
											Column heading
										</td>
										<td>
											Column heading
										</td>
									</tr>
									<tr class="danger">
										<td>
											4
										</td>
										<td>
											danger
										</td>
										<td>
											Column heading
										</td>
										<td>
											Column heading
										</td>
										<td>
											Column heading
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
				<div class="col-md-6">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet box red">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-comments"></i>Contextual Columns
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-bordered table-hover">
									<thead>
									<tr>
										<th>
											#
										</th>
										<th>
											Column
										</th>
										<th>
											Column
										</th>
										<th>
											Column
										</th>
										<th>
											Column
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>
											1
										</td>
										<td class="active">
											active
										</td>
										<td class="success">
											success
										</td>
										<td class="warning">
											warning
										</td>
										<td class="danger">
											danger
										</td>
									</tr>
									<tr>
										<td>
											2
										</td>
										<td class="active">
											active
										</td>
										<td class="success">
											success
										</td>
										<td class="warning">
											warning
										</td>
										<td class="danger">
											danger
										</td>
									</tr>
									<tr>
										<td>
											3
										</td>
										<td class="active">
											active
										</td>
										<td class="success">
											success
										</td>
										<td class="warning">
											warning
										</td>
										<td class="danger">
											danger
										</td>
									</tr>
									<tr>
										<td>
											4
										</td>
										<td class="active">
											active
										</td>
										<td class="success">
											success
										</td>
										<td class="warning">
											warning
										</td>
										<td class="danger">
											danger
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-bell-o"></i>Advance Table
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-striped table-bordered table-advance table-hover">
									<thead>
									<tr>
										<th>
											<i class="fa fa-briefcase"></i> Company
										</th>
										<th class="hidden-xs">
											<i class="fa fa-user"></i> Contact
										</th>
										<th>
											<i class="fa fa-shopping-cart"></i> Total
										</th>
										<th>
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td class="highlight">
											<div class="success">
											</div>
											<a href="javascript:;">
												RedBull </a>
										</td>
										<td class="hidden-xs">
											Mike Nilson
										</td>
										<td>
											2560.60$
										</td>
										<td>
											<a href="javascript:;" class="btn default btn-xs purple">
												<i class="fa fa-edit"></i> Edit </a>
										</td>
									</tr>
									<tr>
										<td class="highlight">
											<div class="info">
											</div>
											<a href="javascript:;">
												Google </a>
										</td>
										<td class="hidden-xs">
											Adam Larson
										</td>
										<td>
											560.60$
										</td>
										<td>
											<a href="javascript:;" class="btn default btn-xs black">
												<i class="fa fa-trash-o"></i> Delete </a>
										</td>
									</tr>
									<tr>
										<td class="highlight">
											<div class="success">
											</div>
											<a href="javascript:;">
												Apple </a>
										</td>
										<td class="hidden-xs">
											Daniel Kim
										</td>
										<td>
											3460.60$
										</td>
										<td>
											<a href="javascript:;" class="btn default btn-xs purple">
												<i class="fa fa-edit"></i> Edit </a>
										</td>
									</tr>
									<tr>
										<td class="highlight">
											<div class="warning">
											</div>
											<a href="javascript:;">
												Microsoft </a>
										</td>
										<td class="hidden-xs">
											Nick
										</td>
										<td>
											2560.60$
										</td>
										<td>
											<a href="javascript:;" class="btn default btn-xs blue">
												<i class="fa fa-share"></i> Share </a>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
				<div class="col-md-6">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-shopping-cart"></i>Advance Table
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="javascript:;" class="reload">
								</a>
								<a href="javascript:;" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-striped table-bordered table-advance table-hover">
									<thead>
									<tr>
										<th>
											<i class="fa fa-briefcase"></i> From
										</th>
										<th class="hidden-xs">
											<i class="fa fa-question"></i> Descrition
										</th>
										<th>
											<i class="fa fa-bookmark"></i> Total
										</th>
										<th>
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>
											<a href="javascript:;">
												Pixel Ltd </a>
										</td>
										<td class="hidden-xs">
											Server hardware purchase
										</td>
										<td>
											52560.10$ <span class="label label-sm label-success label-mini">
										Paid </span>
										</td>
										<td>
											<a href="javascript:;" class="btn default btn-xs green-stripe">
												View </a>
										</td>
									</tr>
									<tr>
										<td>
											<a href="javascript:;">
												Smart House </a>
										</td>
										<td class="hidden-xs">
											Office furniture purchase
										</td>
										<td>
											5760.00$ <span class="label label-sm label-warning label-mini">
										Pending </span>
										</td>
										<td>
											<a href="javascript:;" class="btn default btn-xs blue-stripe">
												View </a>
										</td>
									</tr>
									<tr>
										<td>
											<a href="javascript:;">
												FoodMaster Ltd </a>
										</td>
										<td class="hidden-xs">
											Company Anual Dinner Catering
										</td>
										<td>
											12400.00$ <span class="label label-sm label-success label-mini">
										Paid </span>
										</td>
										<td>
											<a href="javascript:;" class="btn default btn-xs blue-stripe">
												View </a>
										</td>
									</tr>
									<tr>
										<td>
											<a href="javascript:;">
												WaterPure Ltd </a>
										</td>
										<td class="hidden-xs">
											Payment for Jan 2013
										</td>
										<td>
											610.50$ <span class="label label-sm label-danger label-mini">
										Overdue </span>
										</td>
										<td>
											<a href="javascript:;" class="btn default btn-xs red-stripe">
												View </a>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
	<div class="page-footer-inner">
		2014 &copy; Metronic by keenthemes. <a href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes" title="Purchase Metronic just for 27$ and get lifetime updates for free" target="_blank">Purchase Metronic!</a>
	</div>
	<div class="scroll-to-top">
		<i class="icon-arrow-up"></i>
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${rootUrl}resources/global/plugins/respond.min.js"></script>
<script src="${rootUrl}resources/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${rootUrl}resources/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${rootUrl}resources/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${rootUrl}resources/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${rootUrl}resources/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${rootUrl}resources/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${rootUrl}resources/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${rootUrl}resources/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${rootUrl}resources/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${rootUrl}resources/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${rootUrl}resources/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="${rootUrl}resources/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${rootUrl}resources/admin/layout4/scripts/layout.js" type="text/javascript"></script>
<script src="${rootUrl}resources/admin/layout4/scripts/demo.js" type="text/javascript"></script>
<script>
	jQuery(document).ready(function() {
		// initiate layout and plugins
		Metronic.init(); // init metronic core components
		Layout.init(); // init current layout
		Demo.init(); // init demo features
	});
</script>
</body>
<!-- END BODY -->
</html>