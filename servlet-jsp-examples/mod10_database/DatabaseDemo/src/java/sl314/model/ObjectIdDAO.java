package sl314.model;

// SQL imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * This Data Access utility class provides tools for allocating Object IDs.
 */
final class ObjectIdDAO {

  public static final String LEAGUE = "League";
  public static final String PLAYER = "Player";

  /**
   * Keeping the constructor private prevents the creation of instances.
   */
  private ObjectIdDAO() {
  }

  /**
   * This method inserts the League into the database.
   */
  public static int getNextObjectID(String objectClassName,
                                    Connection connection) {

    // JDBC variables
    PreparedStatement query_stmt = null;
    PreparedStatement incr_stmt = null;
    ResultSet result = null;
    int id;

    try {

      // Create SQL SELECT statement
      query_stmt = connection.prepareStatement(NEXT_ID_QUERY);
      query_stmt.setString(1, objectClassName);
      result = query_stmt.executeQuery();

      if ( result.next() ) {
        id = result.getInt("ID_number");
        incr_stmt = connection.prepareStatement(UPDATE_ID_CMD);
        incr_stmt.setInt(1, id + 1);
        incr_stmt.setString(2, objectClassName);
        incr_stmt.executeUpdate();

      } else {
        throw new RuntimeException("No ObjectID entry for class type: "
                                   + objectClassName);
      }

    // Handle any SQL errors
    } catch (SQLException se) {
      throw new RuntimeException("A database error occured. " + se.getMessage());

    // Clean up JDBC resources
    } finally {
      if ( result != null ) {
        try { result.close(); } catch (SQLException se) {}
      }
      if ( query_stmt != null ) {
        try { query_stmt.close(); } catch (SQLException se) {}
      }
      if ( incr_stmt != null ) {
        try { incr_stmt.close(); } catch (SQLException se) {}
      }
    }

    return id;
  }

  private static final String NEXT_ID_QUERY
    = "SELECT ID_number FROM ObjectIDs WHERE table_name=?";
  private static final String UPDATE_ID_CMD
    = "UPDATE ObjectIDs SET ID_number=? WHERE table_name=?";
}
