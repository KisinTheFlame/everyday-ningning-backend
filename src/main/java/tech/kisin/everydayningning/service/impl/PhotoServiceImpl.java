package tech.kisin.everydayningning.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import tech.kisin.everydayningning.dao.PhotoRepository;
import tech.kisin.everydayningning.entity.Photo;
import tech.kisin.everydayningning.po.PhotoPO;
import tech.kisin.everydayningning.service.PhotoService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final Logger logger = LoggerFactory.getLogger(PhotoServiceImpl.class);
    private final int listMaxSize;
    private final Random random = new Random();
    private final LinkedList<Long> idList = new LinkedList<>();
    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(Environment environment, PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
        listMaxSize = Optional
                .ofNullable(environment.getProperty("ningning.least-non-duplicated-size", Integer.class))
                .orElse(100);
        logger.info("Least non duplicated size is set with " + listMaxSize + ".");
    }

    @Override
    public Photo getRandomPhoto() {
        int count = photoRepository.count();
        long index = random.nextInt(count);
        PhotoPO photoPO = photoRepository.findByIndex(index);
        while (idList.contains(photoPO.getId())) {
            index = random.nextInt(count);
            photoPO = photoRepository.findByIndex(index);
        }
        if (idList.size() == listMaxSize) {
            idList.removeFirst();
        }
        idList.add(photoPO.getId());
        photoRepository.countUpFrequency(photoPO.getId());
        logger.info("Retrieving photo with id=" + photoPO.getId() + ".");
        return new Photo(photoPO.getFilename(), photoPO.getDescription(), photoPO.getFrequency() + 1);
    }

    @Override
    public List<Photo> getPhotoList() {
        return photoRepository
                .getAll()
                .stream()
                .map(photoPO -> new Photo(photoPO.getFilename(), photoPO.getDescription(), photoPO.getFrequency()))
                .collect(Collectors.toList());
    }
}
