<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${requestScope.quizQuestion.question}
        <form method="POST" action="quizServlet">
            <input type="radio" name="answer" value="true" required>Agree<br>
            <input type="radio" name="answer" value="false">Disagree<br>
            <input type="submit" name="submit" value="Next">
        </form>
        <form method="POST" action="landingServlet">
            <input type="submit" name="submit" value="Start Over">
        </form>
    </body>
</html>
