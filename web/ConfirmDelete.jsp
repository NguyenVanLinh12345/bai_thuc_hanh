<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style/main.css">
    <title>Confirm Delete</title>
</head>

<body>
    <h1>Are you sure you want to delete this products</h1>

    <span class="description">Product Code:</span>
    <span>${code}</span>
    <span name="code">${requestScope.code}</span>
    <br>

    <span class="description">Product Description:</span>
    <span>${description}</span>
    <br>

    <span class="description">Product Price:</span>
    <span>${price}</span>
    <br>

    <div class="delete_choose">
        <a class="button" href="Delete?code=${code}">Yes</a>
        <a class="button" href="Delete?code=no">No</a>
    </div>
</body>

</html>