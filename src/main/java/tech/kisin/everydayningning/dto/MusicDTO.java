package tech.kisin.everydayningning.dto;

public class MusicDTO {
    private final String filename;
    private final String description;

    public MusicDTO(String filename, String description) {
        this.filename = filename;
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public String getDescription() {
        return description;
    }
}
