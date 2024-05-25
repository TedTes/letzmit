package com.tutego.date4u.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

import com.tutego.date4u.core.FileSystem;

@ShellComponent
public class FsCommands {
    // private final FileSystem fs;
    // private FileSystem fs;

    @Autowired
    private FileSystem fs;

    FsCommands(FileSystem fs) {
        this.fs = fs;
    }

    @ShellMethod("Display required free disk space")
    public String freeDiskSpace() {
        String size = DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + "GB";
        return size;
    }

    @Autowired
    public void setFileSystem(FileSystem fs) {
        this.fs = fs;
    }
}
