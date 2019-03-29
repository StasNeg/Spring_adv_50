<!DOCTYPE html>
<html lang="en">
<body>
<h2>uploading summary</h3>
        <h2>Users</h2>
        <ul>
          <#list model["user"] as item>
              <li>${item}</li>
          </#list>
        </ul>
        <h2>Events</h2>
        <ul>
            <#list model["event"] as item>
                <li>${item}</li>
            </#list>
        </ul>
        <div><a href="${Request.RequestObject.getContextPath()}/">Home</></div>
</body>
</html>