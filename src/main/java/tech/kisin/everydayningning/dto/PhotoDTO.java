package tech.kisin.everydayningning.dto;

import java.io.Serializable;
import java.util.Objects;

public class PhotoDTO implements Serializable {
    private final String filename;
    private final String description;

    public PhotoDTO(String filename, String description) {
        this.filename = filename;
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoDTO entity = (PhotoDTO) o;
        return Objects.equals(this.filename, entity.filename) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "filename = " + filename + ", " +
                "description = " + description + ")";
    }
}
