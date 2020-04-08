package com.example.bunnylist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.bunnylist.repositories.BunnyRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BunnylistApplicationTests {

	@Test
	void contextLoads() {
	}

	@BeforeAll
	static void dataSet(){
	}

	@Test
	void bunnyServiceTest() {
		
	}

	@Test
	void mainTest() {
		// Auto Boxing.
		long num = 1;
		Long numLong = Long.valueOf(1);
		
		assertEquals(numLong, sayHi(num));

	}

	public static Long sayHi(Long number) {
		return number;
	}

}
