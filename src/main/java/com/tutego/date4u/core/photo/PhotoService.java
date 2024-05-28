package com.tutego.date4u.core.photo;

import java.io.UncheckedIOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tutego.date4u.core.FileSystem;
import com.tutego.date4u.interfaces.ThumbnailRendering;

@Service
public class PhotoService {
    private final FileSystem fs;
    // @Autowired
    // @Qualifier("qualityThumbnailRenderer")
    @ThumbnailRendering(ThumbnailRendering.RenderingQuality.FAST)
    private final Thumbnail thumbnail;

    public PhotoService(FileSystem fs, Thumbnail thumbnail) {
        this.fs = fs;
        this.thumbnail = thumbnail;
    }

    public Optional<byte[]> download(String name) {
        try {
            return Optional.of(fs.load(name + ".jpeg"));
        } catch (UncheckedIOException e) {
            return Optional.empty();
        }
    }

    public String upload(byte[] imageBytes) {
        String imageName = UUID.randomUUID().toString();
        // First: store original image
        fs.store(imageName + ".jpg", imageBytes);
        // Second: store thumbnail
        byte[] thumbnailBytes = thumbnail.thumbnail(imageBytes);
        fs.store(imageName + "-thumb.jpg", thumbnailBytes);
        return imageName;
    }
}
