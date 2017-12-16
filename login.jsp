<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Simplicity V2</title>

  <link rel="stylesheet" type="text/css" href="adminresources/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="adminresources/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="adminresources/css/style1.css">
  <link rel="stylesheet" type="text/css" href="adminresources/css/responsive.css">
  <link rel="stylesheet" type="text/css" href="adminresources/css/animate.css">

  <!-- Google Fonts -->
  <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Lato:400,300,700,700italic,900,100' rel='stylesheet' type='text/css'>

  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->


</head>

<body class="login-page">
<form  action="verify.htm" method="get">
<section class="content login-page">

  <div class="content-liquid">
    <div class="container">

      <div class="row">

        <div class="login-page-container">

          <div class="boxed animated flipInY">
            <div class="inner">

              <div class="login-title text-center">
                <h4>Login to your account</h4>
                <h5>We're happy to see you return</h5>
              </div>

              <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" class="form-control" placeholder="Username" name="username" />
              </div>

              <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" placeholder="Password" name="password" />
              </div>

              <input type="submit" class="btn btn-lg btn-success" value="Login to your account" name="submit" id="submit" />

              <p class="footer">We respect your privacy.<br/>We hate spam as much as you do.</p>

            </div>
          </div>

        </div>

      </div>
      
    </div>
  </div>

</section>

<!-- Javascript -->
<script src="adminresources/js/jquery.min.js"></script>
<script src="adminresources/js/bootstrap.min.js"></script>
<script src="adminresources/js/jquery.flippy.min.js"></script>


<script type="text/javascript">
  jQuery(document).ready(function($){

    var min_height = jQuery(window).height();
    jQuery('div.login-page-container').css('min-height', min_height);
    jQuery('div.login-page-container').css('line-height', min_height + 'px');

    //$(".inner", ".boxed").fadeIn(500);
  });
</script>
</form>
</body>
</html>