package org.fkit.hellotest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
	
	public static int score = 100;

	public static void main(String[] args) {
//		new Thread(()-> {System.out.println("Lambda EL");}).start();
//		
//		Square s = (int x)-> {return x+x;};
//		System.out.println(s.calculate(5));
		
		Employee[] staff = new Employee[4];
		staff[0] = new Employee("Tom", 10000.01);
		staff[1] = new Employee("Jack", 20000.01);
		staff[2] = new Employee("Teddy", 8000.01);
		staff[3] = new Manager("Boss", 300);
		
		
		Arrays.sort(staff);
		for(Employee e : staff) {
			System.out.println(e.toString());
		}
		System.out.println(staff[0].num);
		
		Map<Long, Long> map = new HashMap<Long, Long>();
		map.put(1L, 1234L);
		
		System.out.println(map.get(1L));
		
		Square s = new Square() {

			@Override
			public int calculate(int x) {
				return x-100;
			}
			
		};
		
		int count = 1000;
		printNumber((int y)-> {score -= 10; return y+score;});
		score -= 10;
		System.out.println("score: " + score);
		printNumber(s);
		
		s = Square::calculate2;
		printNumber(s);
		
		printSquare(a -> a.COUNT > 10, b -> b.printDef(100), a -> a.calculate(100), x -> x-1, 100);
		printSquare(a -> a.COUNT > 101, null, null, null, 100);
		
		System.out.println("alg: " + lengthOfLongestSubstring("abcabcaa"));
	}
	
	public static void printNumber(Square s) {
		System.out.println("Lambda test: " + s.calculate(200));
//		Square.printNum(888);
//		s.printDef(999);
	}
	
	public static void printSquare(Predicate<Square> p, Consumer<Square> c, Function<Square, Integer> f, Square s, int x) {
		if(p.test(s)) {
			System.out.println("Predicate " + f.apply(s));
			c.accept(s);
		} else {
			System.out.println("Predicate returned false");
		}
	}
	
	private void testLambda(int x) {
//		x = 100;
		Consumer<Integer> c = (y) -> System.out.println(x+1);
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int len = s.length();
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        while(start < len && end < len) {
            String c = s.substring(end, end+1);
            if(map.keySet().contains(c)) {
                int index = map.get(c).intValue();
                String key = null;
                while(start <= index) {
                    key = s.substring(start, start+1);
                    map.remove(key);
                    start++;
                }
            } 
            map.put(c, new Integer(end));
            max = (max < map.size()) ? map.size() : max;
            end++;
        }
        return max;
    }
	
}
