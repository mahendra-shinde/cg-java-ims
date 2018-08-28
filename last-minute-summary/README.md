### Core java 
*   Primitive Types : int,char,float,double,long,byte,short,boolean
*   Collections : Maps for Key-Value, List for Ordered collections
*   Java code is platform independent, no recompilation required
*   Functional interfaces require SINGLE ABSTRACT method
*   Threads share memory inside JVM
*   Runnable is interface used for defining task (for thread)
*   Almost databases support JDBC
*   Oracle connection string is 
    jdbc:oracle:thin:@localhost:1521/xe
*   For DML Queries, use PreparedStatement

## Servlets
*   Servlet may contain both doGet and doPost
*   To read parameter values, use method:
    request.getParameter("name")
*   To create a user defined servlet, use base class "HttpServlet"
*   Annotation for mapping URL to servlet is @WebServlet
*   For Shopping cart, use Session instead of cookies
*   Session ID is stored in client but session is stored on server
*   If HTML form uses method=post then in next servlet, override doPost method
*   JSP pages are HTML with embedded Java code
*   In JSP, java code is written inside special tag:
        <% .. %>
*   JSP do not need doGet and doPost methods.

## Hibernate
*   Hibernate internally uses JDBC and JDBC drivers
*   hibernate DEFAULT configuration file is "hibernate.cfg.xml"
*   Every call to session.save() or session.update() must be called with transaction.

## Spring
*   Benefits of Spring:
    lightweight, Support Testing, Open source
*   Both Setter and Constructor injection can be used for injecting object eg. Address can be injected in Person object using both Setter and Constructor injection.
*   A Large and complex project should use "Inversion of control" for mapping dependencies.

## MVC
*   MVC Stands for Model-View-Controller
*   In MVC, Views are User Interface (UI) components which can be updated with no effect on other components
*   JSF is MVC Based framework which focuses more on UI Components

## JavaScript
*   Javascript is loosely typed, there no data types required
*   To build responsive web applications one should use javascript with jquery.
