public class Music extends Disk{

    public Genre genre;

    @Override
    public int getValue() {
        return value;
    }

    public enum Genre {
        blues,
        jazz,
        pop,
        rock,
    }

    public String executor;
    public String nameTitle;
    public String releaseAlbums;

    public Music(Genre genre, String executor, String nameTitle, String releaseAlbums, int value) {
        this.genre = genre;
        this.executor = executor;
        this.nameTitle = nameTitle;
        this.releaseAlbums = releaseAlbums;
        this.value=value;
    }
}
