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
import java.util.Optional;
import java.util.Random;

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
        if(idList.size() == listMaxSize) {
            idList.removeFirst();
        }
        idList.add(photoPO.getId());
        logger.info("Retrieving photo with id=" + photoPO.getId() + ".");
        return new Photo(photoPO.getFilename(), photoPO.getDescription());
    }
}
