<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Data Tables</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- DATA TABLES -->
    <link href="plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- include javascript and css files for the EditableGrid library -->
	<script src="./js/editablegrid.js"></script>
	<!-- [DO NOT DEPLOY] --> <script src="./js/editablegrid_renderers.js" ></script>
	<!-- [DO NOT DEPLOY] --> <script src="./js/editablegrid_editors.js" ></script>
	<!-- [DO NOT DEPLOY] --> <script src="./js/editablegrid_validators.js" ></script>
	<!-- [DO NOT DEPLOY] --> <script src="./js/editablegrid_utils.js" ></script>
	<!-- [DO NOT DEPLOY] --> <script src="./js/editablegrid_charts.js" ></script>
	<link rel="stylesheet" href="./css/editablegrid.css" type="text/css" media="screen">

	<!-- include javascript and css files for jQuery, needed for the datepicker and autocomplete extensions -->
	<script src="./js/extensions/jquery/jquery-1.6.4.min.js" ></script>
	<script src="./js/extensions/jquery/jquery-ui-1.8.16.custom.min.js" ></script>
	<link rel="stylesheet" href="./js/extensions/jquery/jquery-ui-1.8.16.custom.css" type="text/css" media="screen">
	
	
   	<script src="./js/demo.js" ></script>
	<link rel="stylesheet" type="text/css" href="./css/demo.css" media="screen"/>
	
	<link rel="stylesheet" type="text/css" href="./css/style.css" media="screen"/>
	<script type="text/javascript">
		$(document).ready( function () {	
			$(document.body).addClass('loading');
		});
	
		window.onload = function() { 
			//editableGrid.onloadJSON("grid.json");
 			editableGrid.onloadJSON("./GetHires?mode=view"); 
 			editableGrid.firstPage();
		} 
		
	</script>
  </head>
  <body class="skin-blue sidebar-mini">
    <div class="wrapper">
      
      <header class="main-header">
        <!-- Logo -->
        
        <jsp:include page="./common/header.jsp" />
        
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <jsp:include page="./common/topbar.jsp" />
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
       <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          
          <jsp:include page="./common/sidebar_user.jsp" />
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search..."/>
              <span class="input-group-btn">
                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          
          
          <jsp:include page="./common/sidebar.jsp">
          	<jsp:param name="page" value="viewhires" />
          </jsp:include>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            View Hires
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Hires</a></li>
            <li class="active">View All Hires</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            
            <div id="message" style="display:none"></div>

			<!--  Number of rows per page and bars in chart -->
			<div id="pagecontrol">
				<label for="pagecontrol">Rows per page: </label>
				<select id="pagesize" name="pagesize">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>
					<option value="50">50</option>
				</select>
			</div>
		
			<!-- Grid filter -->
			<label for="filter">Filter :</label>
			<input type="text" id="filter"/>
		
			<!-- Grid contents -->
			<div id="tablecontent"></div>
			
			<!-- Paginator control -->
			<div id="paginator"></div>
            
            
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <footer class="main-footer">
        <jsp:include page="./common/footer.jsp" />
      </footer>
      
      <!-- Control Sidebar -->      
      <aside class="control-sidebar control-sidebar-dark">                
        <jsp:include page="./common/controlbar.jsp" />
      </aside>
      </aside><!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
      <div class='control-sidebar-bg'></div>
    </div><!-- ./wrapper -->

	
	
	
    <!-- jQuery 2.1.4 -->
    <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- DATA TABES SCRIPT -->
    <script src="plugins/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <!-- SlimScroll -->
    <script src="plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="dist/js/demo.js" type="text/javascript"></script>


  </body>
</html>
