<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<body>
	
		
		<c:forEach var="${applicationScope['hello']}" var="item">
			${item}
		</c:forEach>
		hellofsdf
	</body>
</html>