<#-- @ftlvariable name="" type="com.example.helloworld.views.InventoriesView" -->
<html>
<body>
<!-- calls getInventories().getFullName() and sanitizes it -->
<table border=1>
    <th>id</th>
    <th>name</th>
    <th>invid</th>
    <th>invdescr</th>
<#list inventories as inventory>
<tr>
    <td>${inventory.id?html}
    <td>${inventory.employee?html}
    <td>${inventory.inventory?html}
<td>${inventory.inventoryDescr?html}

</#list>
</table>
</body>
</html>