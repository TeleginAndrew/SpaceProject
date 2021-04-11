
<!DOCTYPE HTML>
<html>
<head>
    <title>TOP 10 young lords</title>

</head>
<body>
<a href="/web/">Main</a>
<h1>TOP 10 young lords</h1>
<div>
    <#list list_lords as lord>
        <table>
            <tr>ID: ${lord.id} </tr>
            <tr>Name: ${lord.name} </tr>
            <tr>Age: ${lord.age}</tr>
        </table>
    </#list>
</div>


</body>
</html>