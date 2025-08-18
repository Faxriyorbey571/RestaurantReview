package com.example.restaurantreview.service.impl;

import com.example.restaurantreview.domain.Photo;
import com.example.restaurantreview.repository.PhotoRepository;
import com.example.restaurantreview.service.PhotoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository repository;

    public PhotoServiceImpl(PhotoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Photo upload(MultipartFile file, String caption) throws IOException {
        if (file.getSize() > 2 * 1024 * 1024) {
            throw new RuntimeException("Fayl hajmi 2MB dan katta bo'lishi mumkin emas");
        }
        String uploadDir = "uploads";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();
        String filePath = uploadDir + "/" + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        Photo photo = new Photo();
        photo.setFilename(file.getOriginalFilename());
        photo.setCaption(caption);
        photo.setUploadTime(LocalDateTime.now());
        return repository.save(photo);
    }

    @Override
    public Page<Photo> list(int page, int size) {
        return repository.findAll(PageRequest.of(page - 1, size));
    }
}
