public class Games extends Disk{

    public Genre genre;

    @Override
    public int getValue() {
        return 0;
    }

    public enum Genre {
        action,
        arcade,
        simulator,
        strategy,
    }

    public String publisher;
    public String nameGames;
    public String release;

    public Games(Genre genre, String publisher, String nameGames, String release, int value) {
        this.genre = genre;
        this.publisher = publisher;
        this.nameGames = nameGames;
        this.release = release;
        this.value=value;
    }
}
