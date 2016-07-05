<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Mini Twitter :: New Tweet</title>
</head>
<body style="margin: 0px;">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">
    <h1 style="color: grey;">Compose New Tweet</h1><br/>

    <form:form action="/tweet/create" method="post" modelAttribute="tweet">
      <table>
        <tr>
          <td><b>Name:</b></td>
          <td><form:textarea path="tweet" maxlength="140" rows="3" cols="50"/></td>
        </tr>
        <tr>
          <td></td>
          <td><span style="font-size: 10pt; color: grey;">* Maximum 140 characters</span></td>
        </tr>
        <tr>
          <td>
            <br/><input type="submit" value="Tweet">
          </td>
        </tr>
      </table>
    </form:form>
  </div>
</body>
</html>