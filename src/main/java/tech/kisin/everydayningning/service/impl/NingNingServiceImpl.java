package tech.kisin.everydayningning.service.impl;

import org.springframework.stereotype.Service;
import tech.kisin.everydayningning.dao.PhotoRepository;
import tech.kisin.everydayningning.dataobject.Photo;
import tech.kisin.everydayningning.dto.PhotoDTO;
import tech.kisin.everydayningning.po.PhotoPO;
import tech.kisin.everydayningning.service.NingNingService;
import tech.kisin.everydayningning.service.PhotoService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class NingNingServiceImpl implements NingNingService {

    private final Random random = new Random();

    private final PhotoService photoService;

    public NingNingServiceImpl(PhotoService photoService) {
        this.photoService = photoService;
    }

    @Override
    public PhotoDTO getRandomPhoto() {
        Photo photo = photoService.getRandomPhoto();
        return new PhotoDTO(photo.getFilename(), photo.getDescription());
    }
}
