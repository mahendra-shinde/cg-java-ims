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


/**
 * This Data Access Object performs database operations on Player objects.
 */
class PlayerDAO {

  /**
   * This constructor creates a Player DAO object.
   * Keep this package-private, so no other classes
   * has access to these methods.
   */
  PlayerDAO() {
  }

  /**
   * This method inserts the Player into the database.
   */
  void insert(Player player) {

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

      // Get the next Player object ID
      int playerID = ObjectIdDAO.getNextObjectID(ObjectIdDAO.PLAYER, connection);

      // Add the object ID as the first field to be entered.
      insert_stmt.setInt(1, playerID);
      // Add data fields
      insert_stmt.setString(2, player.name);
      insert_stmt.setString(3, player.address);
      insert_stmt.setString(4, player.city);
      insert_stmt.setString(5, player.province);
      insert_stmt.setString(6, player.postalCode);

      // Perform the SQL INSERT
      insert_stmt.executeUpdate();

      // Set the player's object ID
      player.objectID = playerID;

    // Handle any SQL errors
    } catch (SQLException se) {
      throw new RuntimeException("A database error occured. " + se.getMessage());

    // Handle any JNDI errors
    } catch (NamingException ne) {
      throw new RuntimeException("A JNDI error occured. " + ne.getMessage());

    // Clean up JDBC resources
    } finally {
      if ( insert_stmt != null ) {
        try { insert_stmt.close(); } catch (SQLException sex) {}
      }
      if ( connection != null ) {
        try { connection.close(); }
        catch (Exception e) { e.printStackTrace(System.err); }
      }
    }
  }

  /**
   * The SQL query for a prepared statement to insert a Player object.
   */
  private static final String INSERT_STMT
    = "INSERT INTO Player (PID, name, address, city, province, postal_code) "
    + "VALUES (?, ?, ?, ?, ?, ?)";
}
