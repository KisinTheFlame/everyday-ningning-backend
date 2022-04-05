package tech.kisin.everydayningning.dto;

public class PhotoDTO {
    private final String filename;
    private final String description;
    private final int frequency;

    public PhotoDTO(String filename, String description, int frequency) {
        this.filename = filename;
        this.description = description;
        this.frequency = frequency;
    }

    public String getFilename() {
        return filename;
    }

    public String getDescription() {
        return description;
    }

    public int getFrequency() {
        return frequency;
    }
}
