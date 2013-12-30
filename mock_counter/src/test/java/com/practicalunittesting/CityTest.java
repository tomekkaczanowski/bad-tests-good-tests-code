package com.practicalunittesting;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class CityTest {

	private static final double NUMBER_OF_PEOPLE = 1.2345d;

	@Test
	public void shouldRecognizeDistrict() {
		//given
		District district = mock(District.class);
		District anotherDistrict = mock(District.class);

		//when
		City city = new City(district, NUMBER_OF_PEOPLE);

		//then
		assertThat(city.isLocatedIn(district)).isTrue();
		assertThat(city.isLocatedIn(anotherDistrict)).isFalse();
	}

	@Test
	public void shouldRecognizeItsDistrict() {
		//given
		District district = mock(District.class);

		//when
		City city = new City(district, NUMBER_OF_PEOPLE);

		//then
		assertThat(city.isLocatedIn(district)).isTrue();
	}

	@Test
	public void shouldRecognizeDifferentDistrict() {
		//given
		District district = mock(District.class);
		District anotherDistrict = mock(District.class);

		//when
		City city = new City(district, NUMBER_OF_PEOPLE);

		//then
		assertThat(city.isLocatedIn(anotherDistrict)).isFalse();
	}
}
