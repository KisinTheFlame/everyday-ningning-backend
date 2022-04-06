package tech.kisin.everydayningning.po;

public class MusicPO {
    private final long id;
    private String filename;
    private String description;

    public MusicPO(long id, String filename, String description) {
        this.id = id;
        this.filename = filename;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
