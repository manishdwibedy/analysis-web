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
          <jsp:param name="page" value="data" />
          </jsp:include>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
		<!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Header
            <small>xyz</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 1</a></li>
            <li><a href="#">2</a></li>
            <li class="active">3</li>
          </ol>
        </section>
        
        <!-- Main content -->
        <section class="content">
        
        <div class='row'><div class='col-md-12'><div class='row'><div class='col-md-1'>5.28</div><div class='col-md-11'>Providing and fixing in position 12 mm thick bitumen impregnated fibre board conforming to IS: 1838,</div></div><br/><hr class='item'><div class='row'><div class='col-md-1'>Code</div><div class='col-md-7'>Description</div><div class='col-md-1'>Unit</div><div class='col-md-1'>Quantity</div><div class='col-md-1'>Rate</div><div class='col-md-1'>Amount</div></div><hr class='item'><br/><div class='row'><div class='col-md-1'>00314</div><div class='col-md-7'>Bitumen hot sealing compound : grade A</div><div class='col-md-1'>kilogram</div><div class='col-md-1'><span class='inputQuantity' id='314'>31.50</span></div><div class='col-md-1'> <span class='inputPrice' id='314'>28.00</span></div><div class='col-md-1'><span class='pull-right inputAmount' id='314'>882.00</span></div></div><div class='row'><div class='col-md-1'>00316</div><div class='col-md-7'>Bitumen solution primer of approved quality</div><div class='col-md-1'>litre</div><div class='col-md-1'><span class='inputQuantity' id='316'>1.25</span></div><div class='col-md-1'> <span class='inputPrice' id='316'>50.00</span></div><div class='col-md-1'><span class='pull-right inputAmount' id='316'>62.50</span></div></div><div class='row'><div class='col-md-1'>00339</div><div class='col-md-7'>Flame retardant face insulating, Impregnated fibre board 12 mm thick</div><div class='col-md-1'>sqm</div><div class='col-md-1'><span class='inputQuantity' id='339'>7.50</span></div><div class='col-md-1'> <span class='inputPrice' id='339'>350.00</span></div><div class='col-md-1'><span class='pull-right inputAmount' id='339'>2,625.00</span></div></div><div class='row'><div class='col-md-1'>09999</div><div class='col-md-7'>Sundries</div><div class='col-md-1'>L.S.</div><div class='col-md-1'><span class='inputQuantity' id='9999'>53.82</span></div><div class='col-md-1'> <span class='inputPrice' id='9999'>1.78</span></div><div class='col-md-1'><span class='pull-right inputAmount' id='9999'>95.80</span></div></div><div class='row'><div class='col-md-1'>00114</div><div class='col-md-7'>Beldar</div><div class='col-md-1'>day</div><div class='col-md-1'><span class='inputQuantity' id='114'>0.25</span></div><div class='col-md-1'> <span class='inputPrice' id='114'>329.00</span></div><div class='col-md-1'><span class='pull-right inputAmount' id='114'>82.25</span></div></div><div class='row'><div class='col-md-1'>00123</div><div class='col-md-7'>Mason (brick layer) 1 st class</div><div class='col-md-1'>day</div><div class='col-md-1'><span class='inputQuantity' id='123'>0.12</span></div><div class='col-md-1'> <span class='inputPrice' id='123'>435.00</span></div><div class='col-md-1'><span class='pull-right inputAmount' id='123'>52.20</span></div></div><div class='row'><div class='col-md-1'>00124</div><div class='col-md-7'>Mason (brick layer) 2nd class</div><div class='col-md-1'>day</div><div class='col-md-1'><span class='inputQuantity' id='124'>0.12</span></div><div class='col-md-1'> <span class='inputPrice' id='124'>399.00</span></div><div class='col-md-1'><span class='pull-right inputAmount' id='124'>47.88</span></div></div><div class='row'><div class='col-md-8'><span class='pull-right'>Total</span></div><div class='col-md-4'><span class='pull-right'>Rs. 3,847.63</span></div></div><div class='row'><div class='col-md-8'><span class='pull-right'>Adding for CPOH @ 15.0%</span></div><div class='col-md-4'><span class='pull-right'>Rs. 577.14</span></div></div><div class='row'><div class='col-md-8'><span class='pull-right'>Total </span></div><div class='col-md-4'><span class='pull-right'>Rs. 4,424.77</span></div></div><div class='row'><div class='col-md-8'><span class='pull-right'>Adding for Water @ 1.0%</span></div><div class='col-md-4'><span class='pull-right'>Rs. 44.25</span></div></div><div class='row'><div class='col-md-8'><span class='pull-right'>Total </span></div><div class='col-md-4'><span class='pull-right'>Rs. 4,469.02</span></div></div><div class='row'><div class='col-md-8'><span class='pull-right'>Cost for 1.0 cm</span></div><div class='col-md-4'><span class='pull-right'>Rs. 4,469.02</span></div></div></div></div>
        
        </section>
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
    <!-- page script -->
    <script type="text/javascript">
      $(function () {
        
        var table = $('#example1').dataTable({
        	"bPaginate": true,
            "bLengthChange": false,
            "bFilter": false,
            "bSort": false,
            "bInfo": true,
        	'bAutoWidth': false,
        	"ajax": "./json.txt"
        	});
      });
    </script>

  </body>
</html>
