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
 * This object performs a variety of league registration services.
 * It acts a Facade into the business logic of registering a Player for
 * a League.
 */
public class RegisterService {

  /**
   * This constructor creates a Registration Service object.
   */
  public RegisterService() {
  }

  /**
   * This method finds the specified League object.
   */
  public League getLeague(int year, String season)
         throws ObjectNotFoundException {

    // Delegate to the league service
    LeagueService leagueSvc = new LeagueService();
    return leagueSvc.getLeague(year, season);
  }

  public Player getPlayer(String name) {
    return new Player(name);
  }

  public void register(League league, Player player, String division) {

    // Store the player object into the database
    PlayerDAO playerDataAccess = new PlayerDAO();
    playerDataAccess.insert(player);

    // Record the registration
    insertRegistration(league, player, division);
  }

  private void insertRegistration(League league, Player player, String division) {

    // JDBC variables
    DataSource ds = null;
    Connection connection = null;
    PreparedStatement stmt = null;

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

      // Record the registration in the database
      stmt = connection.prepareStatement(INSERT_REGISTRATION_STMT);
      stmt.setInt(1, league.objectID);
      stmt.setInt(2, player.objectID);
      stmt.setString(3, division);
      stmt.executeUpdate();

    // Handle any SQL errors
    } catch (SQLException se) {
      throw new RuntimeException("A database error occured. " + se.getMessage());

    // Handle any JNDI errors
    } catch (NamingException ne) {
      throw new RuntimeException("A JNDI error occured. " + ne.getMessage());

    // Clean up JDBC resources
    } finally {
      if ( stmt != null ) {
        try { stmt.close(); }
        catch (SQLException se) { se.printStackTrace(System.err); }
      }
      if ( connection != null ) {
        try { connection.close(); }
        catch (Exception e) { e.printStackTrace(System.err); }
      }
    }
  }

  /**
   * The SQL prepared statement to insert a Registration record.
   */
  private static final String INSERT_REGISTRATION_STMT
    = "INSERT INTO Registration (LID, PID, division)"
    + " VALUES (?, ?, ?)";
}
