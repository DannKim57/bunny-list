package com.example.bunnylist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.CarrotType;
import com.example.bunnylist.repositories.BunnyRepository;
import com.example.bunnylist.repositories.CarrotRepository;
import com.example.bunnylist.services.BunnyService;
import com.example.bunnylist.services.CarrotService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BunnylistApplicationTests {

	@Autowired
	BunnyRepository bunnyRepository;
	@Autowired
	CarrotRepository carrotRepository;

	@Test
	void repositoryTest() {
		List<Bunny> bunnyList = bunnyRepository.findByTitle("Amy");
		Bunny bunny1 = new Bunny();
		// for (int i = 0; i < bunnyList.size(); i++) {
		// 	if (!bunnyList.isEmpty()) {
		// 		// assertNull(bunnyList.get(i));
		// 		bunny1 = bunnyList.get(i);
		// 	}
		// }
		assertEquals(5, bunnyList.get(0).getId(), "bunny Id");
	}

	@Test
	void carrotRepositoryTest() {
		List<CarrotType> carrotList = carrotRepository.findCarrotTypes();
		assertEquals("cat", carrotList.get(1).getName(), "what is the name?");
	}


}
