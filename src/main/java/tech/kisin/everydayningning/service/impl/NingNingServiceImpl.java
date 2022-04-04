package tech.kisin.everydayningning.service.impl;

import org.springframework.stereotype.Service;
import tech.kisin.everydayningning.dao.PhotoRepository;
import tech.kisin.everydayningning.dataobject.Photo;
import tech.kisin.everydayningning.dto.PhotoDTO;
import tech.kisin.everydayningning.po.PhotoPO;
import tech.kisin.everydayningning.service.NingNingService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class NingNingServiceImpl implements NingNingService {

    private final Random random = new Random();
    private final PhotoRepository photoRepository;

    public NingNingServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public PhotoDTO getRandomPhoto() {
        List<PhotoPO> list = photoRepository.findAll();
        PhotoPO photoPO = list.get(random.nextInt(list.size()));
        Photo photo = new Photo(
                photoPO.getFilename(),
                photoPO.getDescription()
        );
        return new PhotoDTO(photo.getFilename(), photo.getDescription());
    }
}
