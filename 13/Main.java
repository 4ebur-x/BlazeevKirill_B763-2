import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueryExecutor queryExecutor = new QueryExecutor();
        ModificationExecutor modificationExecutor = new ModificationExecutor();

        System.out.println("Фильмы, вышедшие на экран в текущем и прошлом году:");
        List<String> recentMovies = queryExecutor.getMoviesForCurrentAndPreviousYear();
        for (String movie : recentMovies) {
            System.out.println(movie);
        }
        String movieTitle = "Oppenheimer";
        System.out.println("\nАктеры, снимавшиеся в фильме '" + movieTitle + "':");
        List<String> actorsByMovie = queryExecutor.getActorsByMovie(movieTitle);
        for (String actor : actorsByMovie) {
            System.out.println(actor);
        }
        int minMovies = 2;
        System.out.println("\nАктеры, снимавшиеся как минимум в " + minMovies + " фильмах:");
        List<String> actorsInAtLeastNMovies = queryExecutor.getActorsInAtLeastNMovies(minMovies);
        for (String actor : actorsInAtLeastNMovies) {
            System.out.println(actor);
        }
        System.out.println("\nАктеры, которые были режиссерами хотя бы одного из фильмов:");
        List<String> actorsWhoAreDirectors = queryExecutor.getActorsWhoAreDirectors();
        for (String actor : actorsWhoAreDirectors) {
            System.out.println(actor);
        }
        int years = 10;
        modificationExecutor.deleteMoviesOlderThan(years);
        System.out.println("\nФильмы, вышедшие более " + years + " лет назад, были удалены.");
    }
}