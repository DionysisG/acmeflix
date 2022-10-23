package com.acmeflix.app.bootstrap;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.acmeflix.app.base.BaseComponent;
import com.acmeflix.app.domain.*;
import com.acmeflix.app.service.*;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class jpaRunner extends BaseComponent implements CommandLineRunner {
	private final SubscriptionPlanService subscriptionPlanService;
	private final AccountService accountService;
	private final GenreService genreService;
	private final ContentService contentService;
	private final EpisodeService episodeService;

	@Override
	public void run(final String... args) throws Exception {

		List<SubscriptionPlan> subscriptionPlans = subscriptionPlanService.createAll(
			SubscriptionPlan.builder()
					.description("Basic")
					.simultaneousWatch((short) 1)
					.maxProfiles((short) 1)
					.price(7.99)
					.available(true)
				.build(),

			SubscriptionPlan.builder()
					.description("Standard")
					.simultaneousWatch((short) 2)
					.maxProfiles((short) 5)
					.price(10.99)
					.available(true)
				.build(),

			SubscriptionPlan.builder()
					.description("Premium")
					.simultaneousWatch((short) 4)
					.maxProfiles((short) 5)
					.price(13.99)
					.available(true)
				.build()
		);

		subscriptionPlans.forEach(subscriptionPlanService::create);


		List<Account> accounts = accountService.createAll(
			Account.builder()
				.email("dionysis.gonatas@openbet.com")
				.firstname("Dionysis")
				.lastname("Gonatas")
				.address("Kifisias 37")
				.registerDate(new Date())
				.active(true)
				.subscriptionPlan(subscriptionPlans.get(0))
			.build()
		);

		accounts.forEach(accountService::create);


		List<Genre> genres = genreService.createAll(
			Genre.builder().description("Drama").build(),
			Genre.builder().description("Action").build(),
			Genre.builder().description("Crime").build(),
			Genre.builder().description("Thriller").build(),
			Genre.builder().description("Sci-Fi").build(),
			Genre.builder().description("Comedy").build()
		);

		genres.forEach(genreService::create);


		List<Content> contents = contentService.createAll(
			Content.builder()
				.contentType(ContentType.MOVIE)
				.title("Pulp Fiction")
				.director("Quentin Tarantino")
				.mainCast("John Travolta, Uma Thurman, Samuel L. Jackson")
				.genre(Set.of(genres.get(0), genres.get(2)))
				.releaseDate(new Date(1994, 10, 14))
			.build(),

			Content.builder()
				.contentType(ContentType.MOVIE)
				.title("The Dark Knight")
				.director("Christopher Nolan")
				.mainCast("Christian Bale, Heath Ledger, Aaron Eckhart")
				.genre(Set.of(genres.get(0), genres.get(1), genres.get(2), genres.get(3)))
				.releaseDate(new Date(2008, 06, 18))
			.build(),

			Content.builder()
				.contentType(ContentType.SERIES)
				.title("The Wire")
				.director("David Simon")
				.mainCast("Dominic West, Lance Reddick, Sonja Sohn")
				.genre(Set.of(genres.get(2), genres.get(0), genres.get(3)))
				.releaseDate(new Date(2002, 06, 2))
			.build()
		);

		contents.forEach(contentService::create);


		List<Episode> episodes = episodeService.createAll(
			Episode.builder()
				.content(contents.get(2))
				.title("Middle Ground")
				.seasonNum((short) 3)
				.episodeNum((short) 11)
			.build(),

			Episode.builder()
				.content(contents.get(2))
				.title("-30-")
				.seasonNum((short) 5)
				.episodeNum((short) 10)
			.build()
		);

		episodes.forEach(episodeService::create);
	}
}
