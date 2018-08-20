package sl314.model;

// SQL imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
// JNDI imports
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
// Utility imports
import java.util.List;
import java.util.LinkedList;


/**
 * This Data Access Object performs database operations
 * on League objects.
 */
class LeagueDAO {

  /**
   * This constructor creates a League DAO object.
   * Keep this package-private, so no other classes
   * has access to these methods.
   */
  LeagueDAO() {
    // do nothing
  }

  /**
   * This method retrieves a unique League from the database.
   */
  League retrieve(int year, String season)
         throws ObjectNotFoundException {

    // JDBC variables
    DataSource ds = null;
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet results = null;
    int num_of_rows = 0;

    // Domain variables
    League league = null;

    try {

      // Retrieve the DataSource from JNDI
      Context ctx = new InitialContext();
      if ( ctx == null ) {
        throw new RuntimeException("JNDI Context could not be found.");
      }
      ds = (DataSource)ctx.lookup("java:comp/env/jdbc/leagueDB");
      if ( ds == null ) {
        throw new RuntimeException("DataSource could not be found.");
      }

      // Get a database connection
      connection = ds.getConnection();

      // Create SQL SELECT statement
      stmt = connection.prepareStatement(RETRIEVE_STMT);

      // Initialize statement and execute the query
      stmt.setInt(1, year);
      stmt.setString(2, season);
      results = stmt.executeQuery();

      // Iterator over the query results
      while ( results.next() ) {
        int objectID = results.getInt("LID");

        // We expect only one row to be returned
        num_of_rows++;
        if ( num_of_rows > 1 ) {
          throw new SQLException("Too many rows were returned.");
        }

        // Create and fill-in the League object
        league = new League(objectID,
                            results.getInt("year"),
                            results.getString("season"),
                            results.getString("title"));
      }

      if ( league != null ) {
        return league;
      } else {
        throw new ObjectNotFoundException();
      }

    // Handle any SQL errors
    } catch (SQLException se) {
      throw new RuntimeException("A database error occured. "
                                 + se.getMessage());

    // Handle any JNDI errors
    } catch (NamingException ne) {
      throw new RuntimeException("A JNDI error occured. "
                                 + ne.getMessage());

    // Clean up JDBC resources
    } finally {
      if ( results != null ) {
        try { results.close(); }
        catch (SQLException se) { se.printStackTrace(System.err); }
      }
      if ( stmt != null ) {
        try { stmt.close(); }
        catch (SQLException se) { se.printStackTrace(System.err); }
      }
      if ( connection != null ) {
        try { connection.close(); }
        catch (Exception e) { e.printStackTrace(System.err); }
      }
    } // END of try-catch-finally block
  } // END of the retrieve method

  /**
   * The SQL query for a prepared statement to retrieve a League by the
   * season and year fields.
   */
  private static final String RETRIEVE_STMT
    = "SELECT * FROM League WHERE \"year\"=? AND season=?";


  /**
   * This method retrieves a complete list of leagues from the database.
   */
  List retrieveAll() {

    // JDBC variables
    DataSource ds = null;
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet results = null;

    // Domain variables
    List leagueList = new LinkedList();
    League league = null;

    try {

      // Retrieve the DataSource from JNDI
      Context ctx = new InitialContext();
      if ( ctx == null ) {
        throw new RuntimeException("JNDI Context could not be found.");
      }
      ds = (DataSource)ctx.lookup("java:comp/env/jdbc/leagueDB");
      if ( ds == null ) {
        throw new RuntimeException("DataSource could not be found.");
      }

      // Get a database connection
      connection = ds.getConnection();

      // Create SQL SELECT statement
      stmt = connection.prepareStatement(RETRIEVE_ALL_STMT);

      // Execute the query
      results = stmt.executeQuery();

      // Iterator over the query results
      while ( results.next() ) {
        int objectID = results.getInt("LID");

        // Create and fill-in the League object
        league = new League(objectID,
                            results.getInt("year"),
                            results.getString("season"),
                            results.getString("title"));

        // Store it in the collection
        leagueList.add(league);
      }

      // Return the collection
      return leagueList;

    // Handle any SQL errors
    } catch (SQLException se) {
      throw new RuntimeException("A database error occured. "
                                 + se.getMessage());

    // Handle any JNDI errors
    } catch (NamingException ne) {
      throw new RuntimeException("A JNDI error occured. "
                                 + ne.getMessage());

    // Clean up JDBC resources
    } finally {
      if ( results != null ) {
        try { results.close(); }
        catch (SQLException se) { se.printStackTrace(System.err); }
      }
      if ( stmt != null ) {
        try { stmt.close(); }
        catch (SQLException se) { se.printStackTrace(System.err); }
      }
      if ( connection != null ) {
        try { connection.close(); }
        catch (Exception e) { e.printStackTrace(System.err); }
      }
    } // END of try-catch-finally block
  } // END of retrieveAll method

  /**
   * The SQL query for a prepared statement to retrieve
   * the complete list of leagues.
   */
  private static final String RETRIEVE_ALL_STMT
    = "SELECT * FROM League";


  /**
   * This method inserts the League into the database.
   */
  void insert(League league) {

    // JDBC variables
    DataSource ds = null;
    Connection connection = null;
    PreparedStatement insert_stmt = null;

    try {

      // Retrieve the DataSource from JNDI
      Context ctx = new InitialContext();
      if ( ctx == null ) {
        throw new RuntimeException("JNDI Context could not be found.");
      }
      ds = (DataSource)ctx.lookup("java:comp/env/jdbc/leagueDB");
      if ( ds == null ) {
        throw new RuntimeException("DataSource could not be found.");
      }

      // Get a database connection
      connection = ds.getConnection();

      // Create SQL INSERT statement
      insert_stmt = connection.prepareStatement(INSERT_STMT);

      // Get the next League object ID
      int leagueID = ObjectIdDAO.getNextObjectID(ObjectIdDAO.LEAGUE, connection);

      // Add the object ID as the firs tfield to be entered.
      insert_stmt.setInt(1, leagueID);
      // Add data fields
      insert_stmt.setInt(2, league.year);
      insert_stmt.setString(3, league.season);
      insert_stmt.setString(4, league.title);

      // Execute SQL INSERT statement
      insert_stmt.executeUpdate();

      // Set the league's object ID
      league.objectID = leagueID;

    // Handle any SQL errors
    } catch (SQLException se) {
      throw new RuntimeException("A database error occured. " + se.getMessage());

    // Handle any JNDI errors
    } catch (NamingException ne) {
      throw new RuntimeException("A JNDI error occured. " + ne.getMessage());

    // Clean up JDBC resources
    } finally {
      if ( insert_stmt != null ) {
        try { insert_stmt.close(); }
        catch (SQLException se) { se.printStackTrace(System.err); }
      }
      if ( connection != null ) {
        try { connection.close(); }
        catch (Exception e) { e.printStackTrace(System.err); }
      }
    }
  }

  /**
   * The SQL query for a prepared statement to inser ta League object.
   */
  private static final String INSERT_STMT
    = "INSERT INTO League (LID, \"year\", season, title) "
    + "VALUES (?, ?, ?, ?)";
}
