package com.tutego.date4u.shell;

import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.*;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModelBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.Table;
import com.tutego.date4u.core.photo.profile.Profile;

import jakarta.persistence.EntityManager;
import static java.util.Objects.isNull;

import java.util.Optional;

@ShellComponent
public class EntityManagerCommands {
    private final EntityManager em;

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
}