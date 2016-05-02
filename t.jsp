<%@ taglib prefix="c" uri="coretag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

	<body>
	
			<c:forEach items="${menu}" var="entry">
				${entry.key} ==> ${entry.value}<br/>
			</c:forEach>	
		hellojghj${hello}s
	</body>
</html>