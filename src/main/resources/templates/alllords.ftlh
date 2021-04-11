
<!DOCTYPE HTML>
<html>
<head>
    <title>Новая планетка</title>

</head>
<body>

    <a href="/web/">Main</a>

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