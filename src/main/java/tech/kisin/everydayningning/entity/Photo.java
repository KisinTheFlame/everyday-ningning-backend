package tech.kisin.everydayningning.entity;

public class Photo {
    private String filename;
    private String description;
    private int frequency;

    public Photo() {
    }

    public Photo(String filename, String description, int frequency) {
        this.filename = filename;
        this.description = description;
        this.frequency = frequency;
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
