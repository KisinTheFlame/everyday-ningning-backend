package tech.kisin.everydayningning.po;

public class PhotoPO {
    private Long id;
    private String filename;
    private String description;

    public PhotoPO(Long id, String filename, String description) {
        this.id = id;
        this.filename = filename;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
