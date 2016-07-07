<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Mini Twitter :: New Tweet</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body style="margin: 0px;">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">
    <h1 style="color: grey;">Compose New Tweet</h1><br/>
    <table>
      <tr>
        <td><b>Name:</b></td>
        <td><textarea id="tweet" name="tweet" maxlength="140" rows="3" cols="50"/></textarea></td>
      </tr>
      <tr>
        <td></td>
        <td><span style="font-size: 10pt; color: grey;">* Maximum 140 characters</span></td>
      </tr>
      <tr>
        <td>
          <br/><input type="button" value="Tweet" style="margin-left: 10px;" onClick="tweet()">
        </td>
      </tr>
    </table>
  </div>
  <script>
    function tweet(tweet){
      var tweet = document.getElementById("tweet").value;
      $.post("${pageContext.request.contextPath}/tweet/create",{tweet:tweet,commandName:"tweetForm"}).always(function(data){
        alert(data.message);
        window.location = "${pageContext.request.contextPath}/index";
      });
    }
  </script>
</body>
</html>