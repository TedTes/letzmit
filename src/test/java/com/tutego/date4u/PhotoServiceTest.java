package com.tutego.date4u;

import java.time.LocalDateTime;
import java.util.Base64;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutego.date4u.core.FileSystem;
import com.tutego.date4u.core.photo.AwtBicubicThumbnail;
import com.tutego.date4u.core.photo.Photo;
import com.tutego.date4u.core.photo.PhotoService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.*;
import com.tutego.date4u.core.photo.Photo;
// @SpringBootTest

@ExtendWith(MockitoExtension.class)
class PhotoServiceTest {
    // private static final byte[] MINIMAL_JPG = Base64.getDecoder().decode(
    // "/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAP////////////////////////////////////"
    // + "//////////////////////////////////////////////////wgALCAABAAEBAREA/8QA"
    // + "FBABAAAAAAAAAAAAAAAAAAAAAP/aAAgBAQABPxA="); // https://git.io/J9GXr

    private static final byte[] MINIMAL_JPG = {};
    @Mock
    FileSystem fileSystem;
    @Spy
    AwtBicubicThumbnail thumbnail;
    @InjectMocks
    PhotoService photoService;

    // @BeforeEach
    // void setupFileSystem() {
    // given(fileSystem.getFreeDiskSpace()).willReturn(1L);
    // given(fileSystem.load(anyString())).willReturn(MINIMAL_JPG);
    // }

    @Nested
    class Validator {

        @Test
        void photo_is_valid() {

            // Photo photo = new Photo(1L, new Profile(), "fillmorespic", false,
            // LocalDateTime.MIN);
            Photo photo = new Photo();
            assertThatCode(() -> photoService.download(photo)).doesNotThrowAnyException();
        }

        @Test
        void photo_has_invalid_created_date() {
            LocalDateTime future = LocalDateTime.of(2500, 1, 1, 0, 0, 0);
            // Photo photo = new Photo(1L, new Profile(), "fillmorespic", false, future);
            Photo photo = new Photo();

            assertThatThrownBy(() -> photoService.download(photo))
                    .isInstanceOf(ConstraintViolationException.class)
                    .extracting(
                            throwable -> ((ConstraintViolationException) throwable).getConstraintViolations(),
                            as(InstanceOfAssertFactories.collection(ConstraintViolation.class)))
                    .hasSize(1)
                    .first(InstanceOfAssertFactories.type(ConstraintViolation.class))
                    .satisfies(vio -> {
                        assertThat(vio.getRootBeanClass()).isSameAs(PhotoService.class);
                        assertThat(vio.getLeafBean()).isExactlyInstanceOf(Photo.class);
                        assertThat(vio.getPropertyPath()).hasToString("download.photo.created");
                        assertThat(vio.getInvalidValue()).isEqualTo(future);
                        // assertThat( vio.getMessage() ).isEqualTo( … );
                    });
        }
    }

    private static class DummyFileSystem extends FileSystem {
        @Override
        public long getFreeDiskSpace() {
            return 1;
        }

        @Override
        public byte[] load(String filename) {
            return MINIMAL_JPG;
        }

        @Override
        public void store(String filename, byte[] bytes) {
        }
    }

    @Test
    void successful_photo_upload() {
        FileSystem fileSystem = mock(FileSystem.class);
        given(fileSystem.getFreeDiskSpace()).willReturn(1L);
        given(fileSystem.load(anyString())).willReturn(MINIMAL_JPG);
        // given
        /// FileSystem fs = new DummyFileSystem();
        PhotoService photoService = new PhotoService(fileSystem, new AwtBicubicThumbnail());
        // when
        // String imageName = photoService.upload(MINIMAL_JPG);
        // then
        // assertThat(imageName).isNotEmpty();
        // verify(fileSystem, times(2)).store(anyString(),
        // any(byte[].class));
        // verify(thumbnail).thumbnail(any(byte[].class));
    }
}
