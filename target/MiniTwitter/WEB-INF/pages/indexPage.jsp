<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head>
  <title>MiniTwitter :: Index</title>
</head>
<body style="margin: 0px;">
  <jsp:include page="_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">
    <h1 style="color: grey;">Index</h1>

    <c:if test="${not empty notice}">
      ${notice}
    </c:if>

    <br/>
    <h3><a href="${pageContext.request.contextPath}/tweet/new" style="text-decoration:none; color: black;">Compose New Tweet</a></h3>
    <br/>
    <h3><a href="${pageContext.request.contextPath}/tweets/formatted" style="text-decoration:none; color: black;">Read Tweets</a></h3>
    <br/>
    <h3><a href="${pageContext.request.contextPath}/following/formatted" style="text-decoration:none; color: black;">List Users I Follow</a></h3>
    <br/>
    <h3><a href="${pageContext.request.contextPath}/followers/formatted" style="text-decoration:none; color: black;">List My Followers</a></h3>
    <br/>
    <h3><a href="${pageContext.request.contextPath}/users" style="text-decoration:none; color: black;">Follow / Unfollow Users</a></h3>
  </div>
</body>
</html>
