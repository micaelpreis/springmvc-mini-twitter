<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <title>Mini Twitter :: Following</title>
</head>
<body style="margin: 0px;">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">

    <h1 style="color: grey;">Following</h1>

    <b>
      <br/>
      <a href="${pageContext.request.contextPath}/following.xml">XML</a>
      &nbsp | &nbsp
      <a href="${pageContext.request.contextPath}/following.json">JSON</a>
      <br/><br/>
    </b>

    <c:forEach var="user" items="${listFollowing}" varStatus="status">
      <p>${user.user_followed}</p>
    </c:forEach>
  </div>
</body>
</html>