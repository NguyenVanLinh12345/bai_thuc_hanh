<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style/main.css">
    <title>Products</title>
</head>

<body>
    <h1>Products</h1>
    <table>
        <tr>
            <td>Code</td>
            <td>Description</td>
            <td>Price</td>
        </tr>
        <c:forEach var="item" items="${danhSach}">
            <tr>
            <td>${item.code}</td>
            <td>${item.description}</td>
            <td>${item.price}</td>
            <td><a href="DeleteOrEdit?code=${item.code}&type=edit">Edit</a></td>
            <td><a href="DeleteOrEdit?code=${item.code}&type=delete">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
    <a class="button" href="./Product.jsp">Add Product</a>
</body>

</html>