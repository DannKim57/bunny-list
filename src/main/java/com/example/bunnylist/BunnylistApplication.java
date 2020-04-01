package com.example.bunnylist;

import com.example.bunnylist.config.BunnyListConfig;
import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.services.BunnyService;
import com.example.bunnylist.services.CarrotService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BunnylistApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(BunnyListConfig.class);
		ctx.refresh();

		Bunny bunny1 = new Bunny("123", "bunny1");
		Bunny bunny2 = new Bunny("234", "bunny2");

		BunnyService bunnyService = ctx.getBean(BunnyService.class);
		bunnyService.addBunny(bunny1);
		bunnyService.addBunny(bunny2);
		

		Carrot carrot1 = new Carrot();
		carrot1.setId("789"); carrot1.setFeatures("Buy some sugar");
		CarrotService carrotService = ctx.getBean(CarrotService.class);
		carrotService.addCarrot(carrot1);

		System.out.println("Bunny 1 : " + bunnyService.getBunny("123"));
		System.out.println("Carrot 1 : " + carrotService.getCarrot("789"));

		// SpringApplication.run(BunnylistApplication.class, args);
	}
 
}
