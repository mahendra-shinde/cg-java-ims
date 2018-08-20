In this demo, you use the ModelDemo project to demonstrate the soccer league
sample web application and explain the following:

1. Use the sl314.util.InitializeModelProperties to demnstrate how to implement
   a context listener.

2. use the web.xml to demonstrate the deployment settings of the context
   listener, including context class and parameters.

NOTE: Pay attention to the dataDirectory parameter value, it is platform
dependent.

3. Use the sl314.model.LeagueService to demonstrate a simple
   implementation of a service component for the business logic.

4. Use sl314.controller.AddLeagueServlet to demonstrate how to use the service
   component.

5. use the sl314.model.RegisterService to demonstrate the service facade.

Once you have deployed the application, you can access the web application by
opening a browser and accessing the following URL:

http://localhost:8080/soccer

