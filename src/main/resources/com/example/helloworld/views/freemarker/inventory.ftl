<#-- @ftlvariable name="" type="com.example.helloworld.views.InventoryView" -->
<html>
<body>
<!-- calls getInventories().getFullName() and sanitizes it -->
${inventory.id?html}, ${inventory.employee?html}, ${inventory.inventory?html}, ${inventory.inventoryDescr?html}
</body>
</html>