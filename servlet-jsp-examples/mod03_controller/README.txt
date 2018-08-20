In this demo, you use the ControllerDemo project to demonstrate the soccer
league sample web application and explain the following:

1. Use the add_league.html to demonsrate the creation of the HTMl form.

2. Use the sl314.controller.AddLeagueServlet to demonstrate a simple
   implementation of a controller, including the input validation, and
   executing business logic, and request dispatch.

3. Use the web.xml to demonstrate the servlet configuration.

4. Use sl314.view.SuccessServlet to demonstrate how to retrieve an attribute
   from the request scope.

5. Use sl314.view.ErrorPageServlet to demonstrate how to manually render
   validation errors.

Once you have deployed the application, you can access the web application by
opening a browser and accessing the following URL:

http://localhost:8080/soccer

Just like the exercise, when you click add league, the league is not added
to the list yet. This part will be implemented in future exercises.