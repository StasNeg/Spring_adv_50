<!DOCTYPE html>
<head>
    <h1>Server internal exception</h1>
</head>
<body>
    <div class="container" th:fragment="content">
        <div> ${errorMessage}</div>
        <div><a href="${Request.RequestObject.getContextPath()}/">Home</a> </div>
    </div>
</body>
</html>