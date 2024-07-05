import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryExecutor {

    public List<String> getMoviesForCurrentAndPreviousYear() {
        String sql = "SELECT title FROM movies WHERE YEAR(release_date) IN (YEAR(CURDATE()), YEAR(CURDATE()) - 1)";
        List<String> movies = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                movies.add(rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public List<String> getActorsByMovie(String movieTitle) {
        String sql = "SELECT a.full_name FROM actors a JOIN movie_actors ma ON a.actor_id = ma.actor_id JOIN movies m ON ma.movie_id = m.movie_id WHERE m.title = ?";
        List<String> actors = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, movieTitle);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    actors.add(rs.getString("full_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public List<String> getActorsInAtLeastNMovies(int n) {
        String sql = "SELECT a.full_name FROM actors a JOIN movie_actors ma ON a.actor_id = ma.actor_id GROUP BY a.full_name HAVING COUNT(ma.movie_id) >= ?";
        List<String> actors = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, n);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    actors.add(rs.getString("full_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public List<String> getActorsWhoAreDirectors() {
        String sql = "SELECT DISTINCT a.full_name FROM actors a JOIN movie_directors md ON a.actor_id = md.director_id";
        List<String> actors = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                actors.add(rs.getString("full_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }
}