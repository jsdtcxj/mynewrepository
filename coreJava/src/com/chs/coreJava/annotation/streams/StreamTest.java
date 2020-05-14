package com.chs.coreJava.annotation.streams;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1","a2","b1","b2","c1","c2");
		myList.stream()//a sequential stream
			//.parallelStream() a parallel stream, 大数据量时使用，例如排序
			.sorted((a, b)-> b.compareTo(a))//修改排序规则
			.filter(a->a.startsWith("a"))
			.forEach(System.out::println);
		
		//of :  create a stream from a bunch of object reference
		Stream.of("a1","a2","b1","b2","c1","c2")
			.map(a->{
				System.out.println("map : " + a);
				return a.toUpperCase();
			})
			.anyMatch(a->{
				System.out.println("AnyMatch : " + a);
				return a.startsWith("B");
			});//只要match上，就会停止执行
		
		//Streams cannot be reused. 
		//As soon as you call any terminal operation the stream is closed:
		//The example of reuse stream, just create a Supplier
		Supplier<Stream<String>> streamSupplier = 
				()-> Stream.of("a1","a2","b1","b2","c1","c2")
						.filter(a->a.startsWith("a"));
		System.out.println(streamSupplier.get().anyMatch(a->a.indexOf("a")>= 0));
		System.out.println(streamSupplier.get().noneMatch(a->a.indexOf("a")>= 0));
		
		//collect 
		//transform elements to result sets, e.g.: List/Set/Map
		List<Person> persons = 
				Arrays.asList(new Person(18, "Max"),
							  new Person(23, "Peter"),
							  new Person(12, "David"));
		List<Person> filtered = 
				 persons.stream()
				 		.filter(p->p.name.startsWith("P"))
				 		.collect(Collectors.toList());
		System.out.println(filtered);
		
		Map<Integer, List<Person>> personByAge = 
				persons.stream()
					   .collect(Collectors.groupingBy(p->p.age));
		System.out.println(personByAge);
		
		//map: convert an object to something else
		persons.stream()
			   .map(p->p.name)
			   .forEach(System.out::println);
		
		//flatmap: works on elements whose type is arrary/set/list, 
		//convert it to Object instead of Collections
		//then the method of stream can be applied
		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		Stream<String[]> stream = Arrays.stream(data);
		stream.flatMap(x -> Arrays.stream(x))
			  .forEach(System.out::println);
		
		//reduce: combine elements of a stream and produces a single value
		System.out.println(Stream.of(1,2,3,4,5,6,7,8,9,10)
								 .reduce(0, (a,b)->a+b));
		System.out.println(Stream.of("Hello", "world", "!")
				 				 .reduce("", (a,b)-> a.join(" ", b)));  
		
		//new common method
		Map<Integer, String> map = new HashMap<>();
		map.putIfAbsent(123, "456");//if key not found, insert it. Otherwise return existing.
		map.computeIfAbsent(124, val->"val"+val);//not found, run "val"+val; otherwise nothing
		map.computeIfPresent(123, (key,val)->val+key);//existed, run val+key; otherwise nothing.
//		map.remove(123, "456123");// value existed, remove 123, otherwise onthing.
		map.merge(123, "val", (val,newVal)->val+"_"+newVal);//existed, run the function
		map.forEach((key,value)-> System.out.println(value));
		
		//Date API
		LocalDate localDate = LocalDate.parse("2015-02-20").plusDays(1);
		System.out.println(localDate.getDayOfWeek());
		System.out.println(localDate);
		
		LocalTime sixThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
		System.out.println(sixThirty);
		
		LocalDateTime localDateTime = LocalDateTime.parse("2015-02-20T06:30:00");
		System.out.println(localDateTime);
		
		ZoneId zoneId = ZoneId.of("Europe/Paris");
		//Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		//ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		System.out.println(zonedDateTime);
		
		//Period & Duration
		LocalDate initialDate = LocalDate.parse("2007-05-10");
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));
		int five = Period.between(initialDate, finalDate).getDays();
		System.out.println(five);
		
		LocalTime initialTime = LocalTime.of(6, 30, 0);
		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
		long thirty = Duration.between(initialTime, finalTime).getSeconds();
		System.out.println(thirty);
	}

}
