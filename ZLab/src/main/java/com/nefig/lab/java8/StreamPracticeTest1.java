package com.nefig.lab.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nefig.lab.java8.dto.Trader;
import com.nefig.lab.java8.dto.Transaction;

public class StreamPracticeTest1 {
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario", "Milan");
	Trader alan = new Trader("Alan", "Cambridge");
	Trader brian = new Trader("Brian", "Cambridge");
	
	List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000), 
			new Transaction(raoul, 2011, 400), 
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700), 
			new Transaction(alan, 2012, 950));

	public static void main(String[] args) {
		StreamPracticeTest1 obj = new StreamPracticeTest1();
		obj.find2011TransactionsAndSortByValueLowToHigh();
		obj.findUniqueCitiesWhereTraderWorked();
		obj.findTraderFromCambridgeSortedByName();
		obj.findTraderNamesSortedAlphabetically();
		obj.checkIfAnyTraderIsBasedInMilan();
		obj.printTransactionForTradersFromCambridge();
		obj.findHighestTransaction();
		obj.findSmallestTransaction();

	}

	private void findSmallestTransaction() {
		System.out.println("\nFind the transaction with the smallest value");
		
		Optional<Transaction> transaction = transactions.stream()
			.reduce((t1,t2) -> t1.getValue() > t2.getValue() ? t2 : t1);
		
		System.out.println(transaction);
		
	}

	private void findHighestTransaction() {
		System.out.println("\nWhat’s the highest value of all the transactions?");
		
		Optional<Integer> maxValue= transactions.stream()
			.map(Transaction::getValue)
			.reduce((i,j) -> i>j?i:j);		
		System.out.println(maxValue);
		
		System.out.println("  OR   ");
		

		Optional<Integer> maxValue1= transactions.stream()
			.map(Transaction::getValue)
			.reduce(Integer::max);		
		System.out.println(maxValue1);
		
		
		
	}

	private void printTransactionForTradersFromCambridge() {
		System.out.println("\nPrint all transactions’ values from the traders living in Cambridge");
		
		transactions.stream()
			.filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
			.forEach(t -> System.out.println(t));
		
	}

	private void checkIfAnyTraderIsBasedInMilan() {
		System.out.println("\nAre any traders based in Milan?");
		
		boolean areAnytraderInMilan = transactions.stream()
		.anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan"));
		System.out.println(areAnytraderInMilan);
		
	}

	private void findTraderNamesSortedAlphabetically() {
		System.out.println("\nReturn a string of all traders’ names sorted alphabetically.");
		
		String name = transactions.stream()
			.map(transaction -> transaction.getTrader().getName())
			.distinct()
			.sorted()
			.reduce("", (name1, name2) -> name1.concat(name1));
		System.out.println(name);
		
		System.out.println("  OR   ");
		
		String name1 = transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.joining());
		System.out.println(name1);
		
	}

	private void findTraderFromCambridgeSortedByName() {
		System.out.println("\nFind all traders from Cambridge and sort them by name.");	
		
		List<Trader> traders = transactions.stream()
			.map(Transaction::getTrader)
			.filter(trader -> trader.getCity().equalsIgnoreCase("cambridge"))
			.sorted(Comparator.comparing(Trader::getName))
			.collect(Collectors.toList());
		System.out.println(traders);
	}

	private void findUniqueCitiesWhereTraderWorked() {
		System.out.println("\nWhat are all the unique cities where the traders work?");
		
		List<String> cities  = transactions.stream().
				map(transaction -> transaction.getTrader().getCity())
				.distinct().collect(Collectors.toList());
		System.out.println(cities);
		
	}

	private void find2011TransactionsAndSortByValueLowToHigh() {
		System.out.println("\nFind all transactions in the year 2011 and sort them by value (small to high). ");
		
		List<Transaction> list = transactions.stream()
				.filter(transaction -> transaction.getYear() == 2011)
				.distinct()
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());		
		System.out.println(list);
		
		System.out.println("    OR   ");
		
		transactions.stream().filter(transaction -> transaction.getYear() == 2011)
		.sorted(Comparator.comparing(Transaction::getValue))
		.forEach(t -> System.out.println(t));
		
	}

}
