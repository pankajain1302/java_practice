package algosec;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

public class NumberToWords {
	private HashMap<Integer, String> map_ones = new HashMap<>();
	private HashMap<Integer, String> map_tens = new HashMap<>();
	LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
		
	{
		map_ones.put(1, "one");
		map_ones.put(2, "two");
		map_ones.put(3, "three");
		map_ones.put(4, "four");
		map_ones.put(5, "five");
		map_ones.put(6, "six");
		map_ones.put(7, "seven");
		map_ones.put(8, "eight");
		map_ones.put(9, "nine");
		
		map_tens.put(10, "ten");
		map_tens.put(11, "eleven");
		map_tens.put(12, "twelve");
		map_tens.put(13, "thirteen");
		map_tens.put(14, "fourteen");
		map_tens.put(15, "fifteen");
		map_tens.put(16, "sixteen");
		map_tens.put(17, "seventeen");
		map_tens.put(18, "eighteen");
		map_tens.put(19, "nineten");
		map_tens.put(20, "twenty");
		map_tens.put(30, "thirty");
		map_tens.put(40, "fourty");
		map_tens.put(50, "fifty");
		map_tens.put(60, "sixty");
		map_tens.put(70, "seventy");
		map_tens.put(80, "eighty");
		map_tens.put(90, "ninety");
		
		//queue.add("");
		queue.add(" thousands ");
		queue.add(" millions ");
		queue.add(" bilions ");
		queue.add(" trillions ");
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		NumberToWords foo = new NumberToWords();
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		String output = foo.convertNumberToWord(input, "");
		System.out.println(input+" corresponds to : "+ output);
	}
	
	public String convertNumberToWord (Integer number, String postFixExpression) throws InterruptedException {
		
		if(number == 0) {
			return "";
		}
		String output = postFixExpression;
		
		int num_3 = number % 1000;
		
		if (num_3 < 10) {
			output = map_ones.get(num_3%10)/*+" "+output+" "*/; 
		} else if(map_tens.containsKey(num_3%100)) {
			if(num_3 >= 100) {
				output = map_ones.get(num_3) + " hundred "+map_tens.get(num_3 % 100)/*+" "+output+" "*/;
			} else {
				output = map_tens.get(num_3%100)/*+" "+output+" "*/;
			}
		} else if (num_3 >= 100){
			output = map_ones.get(num_3/100)+" hundred "+ ((num_3%100)/10 !=0 ? map_tens.get(((num_3/10)%10)*10)+" ":"")+map_ones.get(num_3%10)/*+" "+output+" "*/;
		} else {
			output = map_tens.get(((num_3/10)%10)*10)+" "+map_ones.get(num_3%10)/*+" "+output+" "*/;
		}
		
		String appender = queue.take();
		output = convertNumberToWord(number/1000,appender) + output + postFixExpression;
		
		return output;
	}
	
}
