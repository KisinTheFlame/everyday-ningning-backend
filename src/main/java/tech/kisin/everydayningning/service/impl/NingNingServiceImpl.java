package tech.kisin.everydayningning.service.impl;

import org.springframework.stereotype.Service;
import tech.kisin.everydayningning.dao.PhotoRepository;
import tech.kisin.everydayningning.dataobject.Photo;
import tech.kisin.everydayningning.dto.PhotoDTO;
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
        List<Photo> list = photoRepository.findAll();
        Photo photo = list.get(random.nextInt(list.size()));
        return new PhotoDTO(photo.getFilename(), photo.getDescription());
    }

    @Override
    public byte[] ningningRandom() {
        List<Photo> list = photoRepository.findAll();
        Photo photo = list.get(random.nextInt(list.size()));
        try (FileInputStream inputStream = new FileInputStream("/resource/ning/" + photo.getFilename());) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
