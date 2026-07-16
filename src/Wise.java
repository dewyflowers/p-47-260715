public class Wise{
    private final int id;
    private String content;
    private String author;

    public Wise(int id, String content, String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public void setContent(String content){
        this.content = content;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String toString(){
        return "명언: " + content + "\n" + "작가: " + author;
    }
}
