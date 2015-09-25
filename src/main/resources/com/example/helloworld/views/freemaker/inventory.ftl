<#-- @ftlvariable name="" type="com.example.views.PersonView" -->
<html>
<body>
<!-- calls getPerson().getFullName() and sanitizes it -->
<h1>Hello, ${inventory.employee?html}!</h1>
</body>
</html>