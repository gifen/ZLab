package com.nefig.lab.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.nefig.lab.java8.dto.Dish;

public class StreamTest {

	List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	public static void main(String[] args) {
		StreamTest obj = new StreamTest();
		System.out.println(obj.getHighCaloriesDishNames());
		System.out.println(obj.getThreeHighCaloriesDishNames());
		System.out.println("-----------Debugging------------");
		System.out.println(obj.getThreeHighCaloriesDishNamesDebug());
		System.out.println("-----------Debugging End------------");
		System.out.println(obj.getSquareOfNumbers());

	}

	private List<Integer> getSquareOfNumbers() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		return numbers.stream().map(number -> number * number).collect(Collectors.toList());
		
	}

	private List<String> getHighCaloriesDishNames() {
		return menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).collect(Collectors.toList());

	}

	private List<String> getThreeHighCaloriesDishNames() {
		return menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3)
				.collect(Collectors.toList());

	}

	private List<String> getThreeHighCaloriesDishNamesDebug() {
		return menu.stream().filter(dish -> {

			System.out.println("filtering - " + dish.getName());
			return dish.getCalories() > 540;
		}).map(dish -> {

			System.out.println("mapping - " + dish.getName());
			return dish.getName();
		}).limit(3)
		.collect(Collectors.toList());

	}

}
