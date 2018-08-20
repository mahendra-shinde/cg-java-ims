package sl314.model;

import java.util.List;

/**
 * This object performs a variety of league services, like retrieving
 * a league object from the database, or creating a new league object.
 */
public class LeagueService {

  /**
   * The internal Data Access Object used for database CRUD operations.
   */
  private LeagueDAO leagueDataAccess;

  /**
   * This constructor creates a League Service object.
   */
  public LeagueService() {
    leagueDataAccess = new LeagueDAO();
  }

  /**
   * This method returns a complete set of leagues.
   */
  public List getAllLeagues() {
    return leagueDataAccess.retrieveAll();
  }

  /**
   * This method finds the specified League object in the database.
   */
  public League getLeague(int year, String season)
        throws ObjectNotFoundException {

    return leagueDataAccess.retrieve(year, season);
  }

  /**
   * This class adds a new League object to the database.
   */
  public League createLeague(int year, String season, String title) {

    // Create the league object
    League league = new League(-1, year, season, title);

    // Perform the DB transaction
    leagueDataAccess.insert(league);

    return league;
  }
}
