<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style/main.css">
    <title>Product</title>
</head>
<body>
    <h1>Product</h1>
    <p>You must enter a description for the product</p>
    <form action="AddProduct">
         <label class="description" for="code">Product Code:</label>
         <input name="code" type="text" id="code" value="${code}" required>
         <br>
        
         <label class="description" for="description">Product description:</label>
         <input name="description" type="text" value="${description}" id="description" required>
         <br>

         <label class="description" for="price">Product Price</label>
         <input name="price" type="text" id="price" value="${price}" required>
         <c:if test="${errorPrice != null}">
             <p class="text_red">${errorPrice}</p>
         </c:if>
         <br>
         <br>
         <input type="submit" value="Update Product">
         <a class="button" href="ShowProducts">View Products</a>
    </form>
    
</body>
</html>