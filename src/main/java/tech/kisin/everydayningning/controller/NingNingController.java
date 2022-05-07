package tech.kisin.everydayningning.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.kisin.everydayningning.dto.PhotoDTO;
import tech.kisin.everydayningning.service.NingNingService;
import tech.kisin.everydayningning.util.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Objects;

@RestController
public class NingNingController {
    private final NingNingService service;

    public NingNingController(NingNingService service) {
        this.service = service;
    }

    @PostMapping(value = "/get-random-photo")
    public PhotoDTO getRandomPhoto() {
        return service.getRandomPhoto();
    }

    @PostMapping(value = "/get-photo-list")
    public List<PhotoDTO> getPhotoList() {
        return service.getPhotoList();
    }

    @PostMapping(value = "/upload-photo")
    public boolean uploadPhoto(@RequestParam("file") MultipartFile multipartFile) {
        String path = "/resource/upload/";
        File directory = new File(path);
        String suffix = multipartFile.getOriginalFilename();
        String filename = StringUtils.getRandomString(32);
        if (directory.listFiles() != null) {
            boolean duplicated = true;
            while (duplicated) {
                filename = StringUtils.getRandomString(32) + suffix;
                duplicated = false;
                for (File file : Objects.requireNonNull(directory.listFiles())) {
                    if (file.getName().equals(filename)) {
                        duplicated = true;
                        break;
                    }
                }
            }
        }
        File file = new File(directory, filename);
        try {
            multipartFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
