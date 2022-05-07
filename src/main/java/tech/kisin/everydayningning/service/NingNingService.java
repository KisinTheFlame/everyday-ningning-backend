package tech.kisin.everydayningning.service;

import tech.kisin.everydayningning.dto.PhotoDTO;

import java.util.List;

public interface NingNingService {
    PhotoDTO getRandomPhoto();

    List<PhotoDTO> getPhotoList();
}
