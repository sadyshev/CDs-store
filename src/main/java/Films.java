public class Films extends Disk {

    public Genre genre;

    @Override
    public int getValue() {
        return 0;
    }

    public enum Genre {
        western,
        detective,
        comedy,
        thriller,
    }

    public String filmCompany;
    public String nameFilms;
    public String release;

    public Films(Genre genre, String filmCompany, String nameFilms, String release, int value) {
        this.genre = genre;
        this.filmCompany = filmCompany;
        this.nameFilms = nameFilms;
        this.release = release;
        this.value=value;
    }


}
