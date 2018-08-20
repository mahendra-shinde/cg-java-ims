In this demo, you use the ConfigDemo project to demonstrate the soccer league
sample web application and explain the following:

1. Use the index.html to demonsrate the how the admin/add_league.view
   link points to the servlet generated form.

2. Use the sl314.view.AddLeagueFormServlet to demonstrate how to implement
   the init method to initialize the servlet instance using servlet config
   parameters, and how to use the same servlet to render the error messages.

3. Use the web.xml to demonstrate how to define initialization parameters.

4. Use sl314.controller.AddLeagueServlet to demonstrate how to dispatch the
   error page back to the AddLeagueFormServlet.

Once you have deployed the application, you can access the web application by
opening a browser and accessing the following URL:

http://localhost:8080/soccer

