package tech.kisin.everydayningning.service;

import tech.kisin.everydayningning.entity.Photo;

import java.util.List;

public interface PhotoService {
    Photo getRandomPhoto();

    List<Photo> getPhotoList();
}
