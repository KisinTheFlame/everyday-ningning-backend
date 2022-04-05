package tech.kisin.everydayningning.entity;

public class Photo {
    String filename;
    String description;

    public Photo() {
    }

    public Photo(String filename, String description) {
        this.filename = filename;
        this.description = description;
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
