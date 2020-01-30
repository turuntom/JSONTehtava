package tomi.jsontehtava;

public class NaytettavaLuokka {

    private String title;
    private int userId;
    private int id;
    private String body;

    public NaytettavaLuokka(String title, int userId, int id, String body) {
        this.title = title;
        this.userId = userId;
        this.id = id;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
