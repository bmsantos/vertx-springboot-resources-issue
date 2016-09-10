<#macro myLayout title="Layout example">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

<div class="container">

    <#if (flash.error)??>
        <div class="alert alert-danger">
        ${flash.error}
        </div>
    </#if>

    <#if (flash.success)??>
        <div class="alert alert-success">
        ${flash.success}
        </div>
    </#if>

    <#nested/>

</div> <!-- /container -->
</body>
</html>
</#macro>