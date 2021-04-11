
<!DOCTYPE HTML>
<html>
<head>
    <title>Новая планетка</title>

</head>
<body>
<a href="/web/">Main</a>
<div>
<#list list_planet as planet>
<table>
    <tr>ID: ${planet.id} </tr>
    <tr>Name: ${planet.name}</tr>
    <#if planet.lord?? >
    <tr>  Lord: ${planet.lord.name}</tr>
    </#if>
    <form action="planets/${planet.id}" method="post">
        <button class="btn btn-primary" type="submit">Уничтожить Планету</button>
    </form>
</table>
</#list>
</div>


</body>
</html>