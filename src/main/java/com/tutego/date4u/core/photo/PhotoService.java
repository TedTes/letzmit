package com.tutego.date4u.core.photo;

import java.io.UncheckedIOException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tutego.date4u.core.FileSystem;
import com.tutego.date4u.interfaces.ThumbnailRendering;

import jakarta.validation.Valid;

@Service
@Validated
@CacheConfig(cacheNames = "date4u.jsonhotprofiles")
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

    RetryTemplate retryTemplate = new RetryTemplate();
    // retryTemplate.execute(context->
    // {

    // return "result";
    // });

    @Cacheable("date4u.filesystem.file")
    public Optional<byte[]> download(String name) {
        try {
            return Optional.of(fs.load(name + ".jpeg"));
        } catch (UncheckedIOException e) {
            return Optional.empty();
        }
    }

    @Cacheable(cacheNames = "date4u.filesystem.file", keyGenerator = "photoNameKeyGenerator")
    // @Cacheable(cacheNames = "date4u.filesystem.file", key = "#photo.name")
    public Optional<byte[]> download(@Valid Photo photo) {
        return download(photo.getName());
    }

    public String upload(byte[] imageBytes) {
        Future<byte[]> thumbnailBytes = thumbnail.thumbnail(imageBytes);
        String imageName = UUID.randomUUID().toString();
        // First: store original image
        fs.store(imageName + ".jpg", imageBytes);
        // Second: store thumbnail
        fs.store(imageName + "-thumb.jpg", thumbnailBytes);
        return imageName;
        // try {

        // fs.store(imageName + "-thumb.jpg", thumbnailBytes);
        // return imageName;
        // } catch (InterruptedException | ExecutionException e) {
        // throw new IllegalStateException(e);
        // }
    }

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor myThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // Executor.…
        executor.initialize();
        return executor;
    }

    @Bean("concurrentTaskExecutor")
    public TaskExecutor myConcurrentTaskExecutor() {
        return new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3));
    }

    @Async("threadPoolTaskExecutor")
    public void abc() {
    }

    @Async("concurrentTaskExecutor")
    public void xyz() {
    }
}
