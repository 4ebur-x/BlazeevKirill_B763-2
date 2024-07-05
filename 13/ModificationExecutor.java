import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModificationExecutor {

    public void deleteMoviesOlderThan(int years) {
        String selectMoviesSql = "SELECT movie_id FROM movies WHERE release_date < DATE_SUB(CURDATE(), INTERVAL ? YEAR)";
        String deleteMovieActorsSql = "DELETE FROM movie_actors WHERE movie_id = ?";
        String deleteMovieDirectorsSql = "DELETE FROM movie_directors WHERE movie_id = ?";
        String deleteMoviesSql = "DELETE FROM movies WHERE movie_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectMoviesSql);
             PreparedStatement deleteMovieActorsStmt = conn.prepareStatement(deleteMovieActorsSql);
             PreparedStatement deleteMovieDirectorsStmt = conn.prepareStatement(deleteMovieDirectorsSql);
             PreparedStatement deleteMoviesStmt = conn.prepareStatement(deleteMoviesSql)
        ) {
            selectStmt.setInt(1, years);

            try (ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    int movieId = rs.getInt("movie_id");

                    // Удаляем связанные записи из movie_actors
                    deleteMovieActorsStmt.setInt(1, movieId);
                    deleteMovieActorsStmt.executeUpdate();

                    // Удаляем связанные записи из movie_directors
                    deleteMovieDirectorsStmt.setInt(1, movieId);
                    deleteMovieDirectorsStmt.executeUpdate();

                    // Удаляем запись из таблицы movies
                    deleteMoviesStmt.setInt(1, movieId);
                    deleteMoviesStmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}