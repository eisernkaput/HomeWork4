package Entities;

public class Book extends Entity {

    private String title;

    private Author author;

    private int pageCount;

    public Book(String id, String title, Author author, int pageCount) {
        super(id);
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return this.getId() + "." + this.getTitle() + "," + this.getAuthor() + "," + this.getPageCount() + ";";
    }
}
