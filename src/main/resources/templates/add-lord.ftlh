
<!DOCTYPE HTML>
<html>
<head>
    <title>Новый правитель</title>

</head>
<body>
<a href="/web/">Main</a>
<div>
    Добавить нового правителя :
    <form action="/web/lord/add" method="post">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" >
        <br>

        <label for="age"> Age :  </label>
        <input type="text" id="age" name="age" >

        <input type="submit" value="Create">
    </form>
</div>


</body>
</html>