package tech.kisin.everydayningning.po;

public class MusicPO {
    private final long id;
    private String filename;
    private int frequency;

    public MusicPO(long id, String filename, int frequency) {
        this.id = id;
        this.filename = filename;
        this.frequency = frequency;
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
