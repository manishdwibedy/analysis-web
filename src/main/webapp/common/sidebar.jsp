<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%
	String pageName = request.getParameter("page");
	String showIndex="", showData="";
	
	if (pageName.equalsIgnoreCase("index"))		
		showIndex = "active";
	else if (pageName.equalsIgnoreCase("data"))
		showData = "active";
	
%>
	<%= request.getParameter("page") %>
	<%= showIndex %>

	<ul class="sidebar-menu">

		<li class="header">MAIN NAVIGATION - 1.0.2</li>
		<li class="<%= showIndex %>">
			<a href="../index.jsp"> <i class="fa fa-dashboard"></i> <span>Dashboard</span></a>
		</li>

		<li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Materials</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i>Add a material</a></li>
            <li><a href="ViewMaterials.jsp"><i class="fa fa-circle-o"></i>View Materials</a></li>
            <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i>Update materials</a></li>
            <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i>Delete materials</a></li>
          </ul>
        </li>
	</ul>


</body>
</html>