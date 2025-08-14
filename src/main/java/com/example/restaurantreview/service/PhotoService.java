package com.example.restaurantreview.service;

import com.example.restaurantreview.domain.Photo;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    Photo upload(MultipartFile file, String caption) throws IOException;
    Page<Photo> list(int page, int size);
}
