<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<p>List of places</p>
<table>
    <thead>
    <tr>
        <th>Place: </th>
        <th>Description: </th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list places as place>
        <tr>
            <td>${place.name}</td>
            <td>${place.description}</td>
            <td><a href="/place/${place.id}">edit</a></td>
        </tr>

    </#list>
    </tbody>
</table>
</body>
</html>