package com.magalister.categoryservice;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.magalister.categoryservice.controller.CategoryRepository;
import com.magalister.categoryservice.model.Category;
import com.magalister.categoryservice.model.enums.CategoryType;

/**
 * Service main class.
 * 
 * @author Carlos Feitosa (carlos.feitosa.nt@gmail.com)
 * @since 2019-08-25
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CategoryServiceApplication {

	Logger log = LoggerFactory.getLogger(CategoryServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CategoryServiceApplication.class, args);
	}

	/**
	 * Service init.
	 * 
	 * @param repository
	 * 
	 * @return application arguments
	 */
	@Bean
	ApplicationRunner init(CategoryRepository repository) {

		return args -> {
			List<Category> list = new ArrayList<>();

			list.add(new Category("Salário", CategoryType.CREDIT));

			Category shows = new Category("Shows", CategoryType.CREDIT);
			list.add(shows);

			list.add(new Category("Show Academia da Berlinda", CategoryType.CREDIT, shows, "Academia da Berlinda"));

			Category casa = new Category("Casa", CategoryType.DEBIT);
			list.add(casa);

			Category educacao = new Category("Educação", CategoryType.DEBIT, casa);
			list.add(educacao);

			list.add(new Category("Educação Anselmo", CategoryType.DEBIT, educacao));
			list.add(new Category("Educação Helga", CategoryType.DEBIT, educacao));

			list.add(new Category("Saúde", CategoryType.DEBIT, casa));

			for (Category category : list) {
				repository.save(category, true);
			}

			log.info("*** [init] CATEGORIES LIST ***");

			repository.findAll().forEach(category -> {
				log.info(category.toString());
			});
		};
	}
}
