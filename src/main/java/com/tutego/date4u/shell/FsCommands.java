package com.tutego.date4u.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

import com.tutego.date4u.Date4uProperties;
import com.tutego.date4u.core.FileSystem;
import com.tutego.date4u.infrastructure.TutegoConfigurationProperties;

@ShellComponent
public class FsCommands {
    // private final FileSystem fs;
    // private FileSystem fs;

    @Autowired
    private FileSystem fs;
    @Autowired
    private Environment env;
    // @Value("${getMinimumFreeDiskSpace()}")
    private long minimumFreeDiskSpace;

    @Autowired
    TutegoConfigurationProperties props;

    Date4uProperties date4uProperties;

    FsCommands(FileSystem fs, Date4uProperties date4uProperties) {
        this.fs = fs;
        this.date4uProperties = date4uProperties;
    }

    @ShellMethod("Display required free disk space")
    public String freeDiskSpace() {
        System.out.println(props.getHomepage());
        System.out.println(props.getNumberOfSeminars());

        String size = DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + "GB";
        return size;
    }

    @ShellMethod("Display required free disk space")
    public long minimumFreeDiskSpace() {
        return date4uProperties.getFilesystem().getMinimumFreeDiskSpace();
        // return minimumFreeDiskSpace;
    }

    //
    @Autowired
    public void setFileSystem(FileSystem fs) {
        this.fs = fs;
    }

    @ShellMethod("Display user home")
    public String userHome() {
        return env.getProperty("user.home");
    }
}
