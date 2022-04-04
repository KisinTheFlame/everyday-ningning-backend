package tech.kisin.everydayningning.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String filename;
    String description;

    public Photo() {
    }

    public Photo(Long id, String filename, String description) {
        this.id = id;
        this.filename = filename;
        this.description = description;
    }

    public Long getId() {
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
