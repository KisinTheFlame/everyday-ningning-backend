package tech.kisin.everydayningning.entity;

public class Music {
    private String filename;
    private int frequency;

    public Music(String filename, int frequency) {
        this.filename = filename;
        this.frequency = frequency;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
