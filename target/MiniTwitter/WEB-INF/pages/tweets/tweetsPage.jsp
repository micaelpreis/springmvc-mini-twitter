<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <title>Mini Twitter :: Tweets</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body style="margin: 0px;">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">

    <c:choose>
      <c:when test="${not empty username}">
        <h1 style="color: grey;">${username} Tweets</h1>
      </c:when>

      <c:otherwise>
        <h1 style="color: grey;">All Tweets</h1>
      </c:otherwise>
    </c:choose>

    <h3>Search tweets by user and keyword:</h3>

    <form id="search_form">
      <b>User:</b>
      <input type="text" id="username" value="${username}" placeholder="Insert username" />
      <b style="margin-left: 25px;">Keyword:</b>
      <input type="text" id="search" value="${search}" placeholder="Insert keyword"/>
      <input type="submit" value="Search" style="margin-left: 25px;"/>
    </form>

    <b>
      <br/>
      <a href="${pageContext.request.contextPath}/tweets<c:if test="${not empty username}">/${username}</c:if>.xml<c:if test="${not empty search}">?search=${search}</c:if>">XML</a>
      &nbsp | &nbsp
      <a href="${pageContext.request.contextPath}/tweets<c:if test="${not empty username}">/${username}</c:if>.json<c:if test="${not empty search}">?search=${search}</c:if>">JSON</a>
      <br/><br/>
    </b>

    <c:forEach var="tweet" items="${listTweets}" varStatus="status">
      <p><b>${tweet.user_username}:</b> ${tweet.tweet}
    </c:forEach>
  </div>

  <script type="text/javascript">
    $('#search_form').submit(function (e) {
      // Stop from submitting
      e.preventDefault();

      var username = $('#username').val();
      var search = $('#search').val();

      if(username == ""){
          window.location = "${pageContext.request.contextPath}/tweets/formatted?search=" + search;
      }
      else {
          window.location = "${pageContext.request.contextPath}/tweets/" + username + "/formatted?search=" + search;
      }
    });
  </script>
</body>
</html>