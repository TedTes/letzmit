package com.tutego.date4u.core;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.io.IOException;
import java.io.UncheckedIOException;

@Service
public class FileSystem {
    private Path root = Paths.get(System.getProperty("user.home")).resolve("fs");

    public FileSystem() {
        this(Paths.get(System.getProperty("user.home"))
                .resolve("fs").toAbsolutePath().normalize());
        try {
            if (!Files.isDirectory(root))
                Files.createDirectory(root);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    FileSystem(Path root) {
        this.root = root;
    }

    public long getFreeDiskSpace() {
        return root.toFile().getFreeSpace();
    }

    public byte[] load(String filename) {
        try {
            return Files.readAllBytes(resolve(filename));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void store(String filename, byte[] bytes) {
        try {
            Files.write(resolve(filename), bytes);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void store(String filename, Future<byte[]> bytes) {
        // try {
        // Files.write(resolve(filename), bytes);
        // } catch (IOException e) {
        // throw new UncheckedIOException(e);
        // }
    }

    private Path resolve(String filename) {
        Path path = root.resolve(filename).toAbsolutePath().normalize();
        if (!path.startsWith(root))
            throw new SecurityException("Access to " + path + " denied");
        return path;
    }
}
