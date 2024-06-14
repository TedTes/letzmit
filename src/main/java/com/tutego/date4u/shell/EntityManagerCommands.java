package com.tutego.date4u.shell;

import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.*;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModelBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.shell.table.TableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.Table;

import com.tutego.date4u.core.photo.Photo;
import com.tutego.date4u.core.photo.profile.Profile;
import java.util.List;
import jakarta.persistence.EntityManager;
import static java.util.Objects.isNull;

import java.time.LocalDateTime;
import java.util.Optional;

@ShellComponent
public class EntityManagerCommands {
    private final EntityManager em;
    private final static int PAGE_SIZE = 10;

    public EntityManagerCommands(EntityManager em) {
        this.em = em;
    }

    @ShellMethod("Display profile")
    public String findprofile(long id) {

        // LoggerFactory.getLogger(getClass()).info("{}", em);
        // return isNull(em) ? "null" : em.getClass().getName();
        return Optional.ofNullable(em.find(Profile.class, id))
                .map(this::formatProfileAsTable)
                .orElse("Unknown profile for ID " + id);

    }

    private String formatProfileAsTable(Profile p) {
        TableModel tableModel = new TableModelBuilder<String>()
                .addRow().addValue("ID").addValue("" + p.getId())
                .addRow().addValue("Mane length").addValue("" + p.getManelength())
                .addRow().addValue("Nickname").addValue(p.getNickname())
                .addRow().addValue("Birthdate").addValue(p.getBirthdate().toString())
                .build();
        Table table = new TableBuilder(tableModel)
                .addFullBorder(BorderStyle.fancy_light).build();
        return table.render(100);
    }

    @ShellMethod("Display profiles for a given page")
    public List<Profile> page(int page) {
        return em.createQuery("SELECT p FROM Profile p", Profile.class)
                .setFirstResult(page * PAGE_SIZE)
                .setMaxResults(PAGE_SIZE)
                .getResultList();
    }

    @ShellMethod("Display latest seen profiles")
    public List<Profile> lastseen() {
        return em.createQuery("SELECT p FROM Profile p WHERE p.lastseen > :lastseen",
                Profile.class)
                .setParameter("lastseen", LocalDateTime.now().minusMonths(6))
                .getResultList();
    }

    @Transactional
    @ShellMethod("Set mane length of a given profile")
    public void updateManelength(long id, int manelength) {
        Optional.ofNullable(em.find(Profile.class, id))
                .ifPresent(p -> p.setManelength(manelength));
    }

    @ShellMethod("Display all photos of a given profile by ID")
    public void photos(long id) {
        Optional.ofNullable(em.find(Profile.class, id))
                .ifPresent(profile -> {
                    for (Photo photo : profile.getPhotos())
                        System.out.println(photo.getName());
                });
    }
}