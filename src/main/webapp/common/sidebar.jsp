<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%
	String pageName = request.getParameter("page");
	String showIndex="", showMaterial ="", showLabour = "", showHire = "", showCarriage = "", showConstant = "";
	String showViewMaterials="", showUpdateMaterials = "";
	String showViewLabours = "", showUpdateLabours = "";
	String showViewHires = "", showUpdateHires = "";
	String showViewCarriage = "", showUpdateCarriages = "";
	String showViewConstants = "", showUpdateConstants = "";
	
	if (pageName.equalsIgnoreCase("index"))		
	{
		showIndex = "active";
	}
	else if (pageName.equalsIgnoreCase("viewmaterials"))
	{
		showMaterial = "active";
		showViewMaterials = "active";
	}
	else if (pageName.equalsIgnoreCase("updatematerials"))
	{
		showMaterial = "active";
		showUpdateMaterials = "active";
	}
	else if (pageName.equalsIgnoreCase("viewlabours"))
	{
		showLabour = "active";
		showViewLabours = "active";
	}
	else if (pageName.equalsIgnoreCase("updatelabours"))
	{
		showLabour = "active";
		showUpdateLabours = "active";
	}
	else if (pageName.equalsIgnoreCase("viewhires"))
	{
		showHire = "active";
		showViewHires = "active";
	}
	else if (pageName.equalsIgnoreCase("updatehires"))
	{
		showHire = "active";
		showUpdateHires = "active";
	}
	else if (pageName.equalsIgnoreCase("viewcarriages"))
	{
		showCarriage = "active";
		showViewCarriage = "active";
	}
	else if (pageName.equalsIgnoreCase("updatecarriages"))
	{
		showCarriage = "active";
		showUpdateCarriages = "active";
	}
	else if (pageName.equalsIgnoreCase("viewconstants"))
	{
		showConstant = "active";
		showViewConstants = "active";
	}
	else if (pageName.equalsIgnoreCase("updateconstants"))
	{
		showConstant = "active";
		showUpdateConstants = "active";
	}
	
	
%>
	<%= request.getParameter("page") %>
	<%= showUpdateMaterials %>

	<ul class="sidebar-menu">

		<li class="header">MAIN NAVIGATION - 1.0.2</li>
		<li class="<%= showIndex %>">
			<a href="./index.jsp"> <i class="fa fa-dashboard"></i> <span>Dashboard</span></a>
		</li>

		<li class="treeview <%= showMaterial %>">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Materials</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>Add a material</a></li>
            <li class="<%= showViewMaterials %>"><a href="./ViewMaterials.jsp"><i class="fa fa-circle-o"></i>View Materials</a></li>
            <li class="<%= showUpdateMaterials %>"><a href="./UpdateMaterials.jsp"><i class="fa fa-circle-o"></i>Update materials</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Delete materials</a></li>
          </ul>
        </li>
        
        <li class="treeview <%= showLabour %>">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Labour</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>Add Labour</a></li>
            <li class="<%= showViewLabours %>"><a href="./ViewLabours.jsp"><i class="fa fa-circle-o"></i>View Labours</a></li>
            <li class="<%= showUpdateLabours %>"><a href="./UpdateLabours.jsp"><i class="fa fa-circle-o"></i>Update Labours</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Delete Labours</a></li>
          </ul>
        </li>
        
        <li class="treeview <%= showHire %>">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Hire</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>Add Hire</a></li>
            <li class="<%= showViewHires %>"><a href="./ViewHires.jsp"><i class="fa fa-circle-o"></i>View Hires</a></li>
            <li class="<%= showUpdateHires %>"><a href="./UpdateHires.jsp"><i class="fa fa-circle-o"></i>Update Hires</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Delete Hires</a></li>
          </ul>
        </li>
        
        <li class="treeview <%= showCarriage %>">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Carriage</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>Add Carriage</a></li>
            <li class="<%= showViewCarriage %>"><a href="./ViewCarriages.jsp"><i class="fa fa-circle-o"></i>View Carriages</a></li>
            <li class="<%= showUpdateCarriages %>"><a href="./UpdateCarriages.jsp"><i class="fa fa-circle-o"></i>Update Carriages</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Delete Carriages</a></li>
          </ul>
        </li>
        
        <li class="treeview <%= showConstant %>">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Constant</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>Add Constant</a></li>
            <li class="<%= showViewConstants %>"><a href="./ViewConstants.jsp"><i class="fa fa-circle-o"></i>View Constants</a></li>
            <li class="<%= showUpdateConstants %>"><a href="./UpdateConstants.jsp"><i class="fa fa-circle-o"></i>Update Constants</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Delete Constants</a></li>
          </ul>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Item</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>Add Item</a></li>
            <li><a href="./ViewItems.jsp"><i class="fa fa-circle-o"></i>View Items</a></li>
            <li><a href="./UpdateItems.jsp"><i class="fa fa-circle-o"></i>Update Items</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Delete Items</a></li>
          </ul>
        </li>
	</ul>


</body>
</html>