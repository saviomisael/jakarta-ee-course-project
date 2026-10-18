<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Feedback Page</title>
  </head>
  <body>
    <h1>Submit Your Feedback</h1>

    <form action="feedbackServlet" method="POST">
        <textarea rows="5" name="feedbackParam"></textarea>
        <!-- If the submit button is a <button> or <input type="submit"> and has a name attribute, the form data set will include an entry for its name and value. Source: https://developer.mozilla.org/en-US/docs/Glossary/Submit_button -->
        <button type="submit">Submit Feedback</button>
    </form>
  </body>
</html>