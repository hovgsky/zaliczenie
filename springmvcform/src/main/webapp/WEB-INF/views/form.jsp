<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Konwerter Walut</title>
</head>
<body>
<h2>Konwerter walut PLN</h2>
<form action="form" method="post">
    Kwota w PLN: <input type="number" step="0.01" name="amount" value="${currencyForm.amount}" required/><br/><br/>
    Wybierz walutę:
    <select name="currency" required>
        <option value="USD" ${currencyForm.currency == 'USD' ? 'selected' : ''}>USD</option>
        <option value="WON" ${currencyForm.currency == 'WON' ? 'selected' : ''}>WON</option>
        <option value="PESOS" ${currencyForm.currency == 'PESOS' ? 'selected' : ''}>PESOS</option>
        <option value="YEN" ${currencyForm.currency == 'YEN' ? 'selected' : ''}>YEN</option>
    </select><br/><br/>
    <input type="submit" value="Przelicz"/>
</form>
</body>
</html>
