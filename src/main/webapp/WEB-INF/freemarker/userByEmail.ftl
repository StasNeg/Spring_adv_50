<!DOCTYPE html>
<html lang="en">
<body>
    <fieldset>
        <div><legend>Name :${user.name}</legend></div>
        <div><legend>Email :${user.email}</legend></div>
        <div><legend>Birth Day :${user.birthday}</legend></div>
    </fieldset>
    <div><a href="${Request.RequestObject.getContextPath()}/">Home</></div>
</body>
</html>