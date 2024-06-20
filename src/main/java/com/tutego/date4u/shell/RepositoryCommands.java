package com.tutego.date4u.shell;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Lazy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.tutego.date4u.core.photo.profile.Profile;
import com.tutego.date4u.interfaces.ProfileRepository;

@ShellComponent
public class RepositoryCommands {
    @Autowired
    private ProfileRepository profiles;
    // QProfile profile = QProfile.profile;
    private static final int PAGE_SIZE = 10;
    // private final ProfileRepository profiles;
    private Lazy<Page<Profile>> currentPage;

    public RepositoryCommands(ProfileRepository profiles) {
        this.profiles = profiles;
        currentPage = Lazy.of(() -> profiles.findAll(PageRequest.ofSize(PAGE_SIZE)));
    }

    @ShellMethod("Display all profiles")
    public List<Profile> list() {
        return currentPage.get().getContent();
    }

    @ShellMethod("Set current page to previous page, display the current page")
    List<Profile> pp() {
        currentPage = currentPage.map(
                page -> profiles.findAll(page.previousOrFirstPageable()));
        return list();
    }

    @ShellMethod("Set current page to next page, display the current page")
    List<Profile> np() {
        currentPage = currentPage.map(
                page -> profiles.findAll(page.nextOrLastPageable()));
        return list();
    }

    // @ShellMethod("Display all profiles")
    // public void list() {
    // profiles.findAll().forEach(System.out::println);
    // }

    @ShellMethod("random")
    public Optional<Profile> random() {
        Profile generate = new Profile(
                "JuicyJenelyn",
                LocalDate.now().minusYears(22),
                12,
                Profile.FEE,
                null,
                "",
                LocalDateTime.now().minusDays(12));
        profiles.save(generate);
        return profiles.findById(generate.getId());
    }

    @ShellMethod("update")
    public Optional<Profile> update() {
        Optional<Profile> maybeProfile = profiles.findById(1L);
        maybeProfile.ifPresent(profile -> {
            System.out.println(profile);
            profile.setNickname("King" + profile.getNickname() + "theGreat");
            profiles.save(profile);
        });
        return profiles.findById(1L);
    }

    // @ShellMethod("Display profiles with mane length between a given min and max
    // value")
    // public void profilesBetween(short min, short max) {
    // profiles.findAll(QProfile.profile.manelength.between(min, max))
    // .forEach(System.out::println);
    // }

    // DERIVED QUERIES METHOD STRUCTURE
    // Optional<Profile> findFirstByOrderByManelengthDesc();
    // List<Profile> findByOrderByManelengthDesc();
    // List<Profile> findByManelengthGreaterThan( short min );
    // List<Profile> findFirst10ByOrderByLastseenDesc();
}