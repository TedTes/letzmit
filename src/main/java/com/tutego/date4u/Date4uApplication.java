package com.tutego.date4u;

// import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
// import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
// import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.unit.DataSize;

import com.tutego.date4u.core.FileSystem;

import java.util.Arrays;
import java.util.Locale;

import org.slf4j.*;

@ConfigurationPropertiesScan
@SpringBootApplication
public class Date4uApplication {
	// private String args[];

	// Date4uApplication(String[] args) {
	// this.args = args;
	// }

	// Date4uApplication() {
	// }

	private Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		Date4uApplication test = new Date4uApplication();

		// new SpringApplicationBuilder(Date4uApplication.class).headless(false)
		// .bannerMode(Banner.Mode.OFF).logStartupInfo(false).run(args);
		//

		// SpringApplication.run(Date4uApplication.class, args);
		// SpringApplication app = new SpringApplication(Date4uApplication.class);
		// app.setHeadless(false);

		// app.setBannerMode(Banner.Mode.OFF);

		ApplicationContext ctx = SpringApplication.run(Date4uApplication.class,
				args);

		FileSystem fs = ctx.getBean(FileSystem.class);
		System.out.println(DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + "GB");
		Arrays.stream(ctx.getBeanDefinitionNames()).sorted()
				.forEach(System.out::println);

		test.logData();
	}

	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	Locale lang = LocaleContextHolder.getLocale();
	String msg1 = messageSource.getMessage("shell.fs.path-exist", new Object[] { "c:/test" }, lang);
	String msg2 = messageSource.getMessage("shell.fs.path-not-exist", new Object[] { "c:/test" }, lang);

	// messageSource.@setBasename("messages/shell/fscommands");
	// messageSource.setDefaultEncoding("UTF-8");
	// messageSource.setUseCodeAsDefaultMessage(true);
	// public static void run(String[] args) {
	// Date4uApplication test = new Date4uApplication();
	// test.logData();
	// // SpringApplication.run(Date4uApplication.class, args);
	// SpringApplication app = new SpringApplication(Date4uApplication.class);
	// app.setHeadless(false);
	// app.setBannerMode(Banner.Mode.OFF);
	// }

	private void logData() {
		log.debug("Debug Level Log");
		log.trace("TRACE Level Log");
		log.info("Info Level Log");
		log.error("Log with arguments are {}, {} und {}", 1, "2", 3.0);
		log.info("Log with arguments {}, {} and {}", 1, "2", 3.0);
	}

}