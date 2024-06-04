package com.tutego.date4u;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

// @SpringBootTest( properties = {"spring.shell.interactive.enabled=false"} )
// @SpringBootTest( properties = "spring.shell.interactive.enabled=false" )
// @SpringBootTest( value = "spring.shell.interactive.enabled=false" )
@SpringBootTest("spring.shell.interactive.enabled=false")

// second option;
// @SpringBootTest
// @TestPropertySource(locations = "classpath:test.properties")
// // @TestPropertySource( "classpath:test.properties" )
// @TestPropertySource(properties = "spring.shell.interactive.enabled=false")
class Date4uApplicationTests {

	@Test
	void contextLoads() {
	}

}
