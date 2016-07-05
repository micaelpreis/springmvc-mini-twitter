<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <title>Mini Twitter :: Followers</title>
</head>
<body style="margin: 0px;">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">

    <h1 style="color: grey;">Followers</h1>

    <b>
      <br/>
      <a href="${pageContext.request.contextPath}/followers.xml">XML</a>
      &nbsp | &nbsp
      <a href="${pageContext.request.contextPath}/followers.json">JSON</a>
      <br/><br/>
    </b>

    <c:forEach var="user" items="${listFollowers}" varStatus="status">
      <p>${user.follower}</p>
    </c:forEach>
  </div>
</body>
</html>