package com.tutego.date4u.shell;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.tutego.date4u.core.photo.Photo;
import com.tutego.date4u.core.photo.PhotoService;
import com.tutego.date4u.core.photo.profile.Profile;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@ShellComponent
public class PhotoCommands {
    private final PhotoService photoService;

    public PhotoCommands(PhotoService photoService) {
        this.photoService = photoService;
    }

    @ShellMethod("Show photo")
    String showPhoto(String name) {// show-photo
        return photoService.download(name).map(bytes -> {
            try {
                var image = ImageIO.read(new ByteArrayInputStream(bytes));
                return "Width: " + image.getWidth()
                        + ", Height: " + image.getHeight();
            } catch (IOException e) {
                return "Unable to read image dimensions";
            }
        }).orElse("Image not found");

    }

    @ShellMethod("Upload photo") // upload-photo
    String uploadPhoto(String filename) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        return "Uploaded " + photoService.upload(bytes);
    }

    @Autowired
    Validator validator;

    @ShellMethod("Insert a new photo")
    String insertPhoto(Long id, long profile, String name,
            boolean isProfilePhoto, String created) {
        // Photo photo = new Photo(id, new Profile(), name,
        // isProfilePhoto,LocalDateTime.parse(created));
        Photo photo = new Photo();
        Set<ConstraintViolation<Photo>> violationSet = validator.validate(photo);
        // Insert photo into database if violationSet.isEmpty()
        return violationSet.isEmpty() ? "Photo inserted"
                : "Photo not inserted\n" + violationSet;
    }
}
