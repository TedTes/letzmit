package com.tutego.date4u.core;

import java.io.IOException;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

// @WebServlet
public class Statistic extends HttpServlet {
    // @Autowired …;
    @Override
    protected void service(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        resp.getWriter().write("stat web page test");
    }

}
