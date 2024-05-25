package com.tutego.date4u;

// import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.unit.DataSize;

import com.tutego.date4u.core.FileSystem;

import java.util.Arrays;

import org.slf4j.*;

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
		// Date4uApplication test = new Date4uApplication();

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

		// test.logData();
	}

	// public static void run(String[] args) {
	// Date4uApplication test = new Date4uApplication();
	// test.logData();
	// // SpringApplication.run(Date4uApplication.class, args);
	// SpringApplication app = new SpringApplication(Date4uApplication.class);
	// app.setHeadless(false);
	// app.setBannerMode(Banner.Mode.OFF);
	// }

	// private void logData() {
	// log.debug("Debug Level Log");
	// log.info("Info Level Log");
	// log.error("Log with arguments {}, {} und {}", 1, "2", 3.0);
	// log.info("Log with arguments {}, {} and {}", 1, "2", 3.0);
	// }

}