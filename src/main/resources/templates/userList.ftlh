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
<p>List of users</p>

<table id="userList">
    <thead>
    <tr>
        <th>Email: </th>
        <th>Role: </th>
        <th></th>
    </tr>
    </thead>
</table>
<script>
    async function getUser() {
        let response = await fetch("/manager");
        return await response.text();
    }
    const target = document.getElementById("userList");
    getUser().then(
        (result)=> {
            console.log(result);
            target.innerHTML = result;
        });
</script>
</body>
</html>