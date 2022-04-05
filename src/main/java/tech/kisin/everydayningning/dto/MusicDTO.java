package tech.kisin.everydayningning.dto;

public class MusicDTO {
    private final String filename;
    private final int frequency;

    public MusicDTO(String filename, int frequency) {
        this.filename = filename;
        this.frequency = frequency;
    }

    public String getFilename() {
        return filename;
    }

    public int getFrequency() {
        return frequency;
    }
}
