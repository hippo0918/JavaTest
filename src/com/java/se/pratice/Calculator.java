package com.java.se.pratice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Calculator {

	public static void main(String[] args) {
		/*
		 *统计此字符串出现的字母的个数 
		 * */
		StringBuffer sb = new StringBuffer();
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		sb.append("aaabbbsdfjsljfljljcvzjxclvkjuiuroutiknkfhkfhjhfdkgjhsdfjdlsfisdjfisdfn,znvc,niwehhehhflkghfkjgbhjkcbvkjznckjvbxzcjkvbzkljdjshsdlkjhflkjhdafjlkahalihuewriuyiufhcfgjkhbckjvbnz,mvcnbm,zvjbkahgkuhdakfj");
		calculate(sb.toString());
		
		/*
		 *定义一个Student类，属性：name,classNumber,score
		 *现将若干Student放入到List ，并分别统计出每个班的总分和平均分，并打印出来
		 * */
		List<Student> list = new ArrayList<Student>();
		Student s = new Student("a",100,"计算机10-2");
		s = new Student("a",100,"计算机10-2");
		list.add(s);
		s = new Student("a",33,"计算机10-2");
		list.add(s);
		s = new Student("a",100,"计算机10-2");
		list.add(s);
		s = new Student("a",44,"计算机10-2");
		list.add(s);
		s = new Student("a",100,"计算机10-2");
		list.add(s);
		s = new Student("a",100,"计算机10-2");
		list.add(s);
		s = new Student("a",77,"计算机10-2");
		list.add(s);
		s = new Student("a",100,"计算机10-2");
		list.add(s);
		s = new Student("a",67,"计算机10-2");
		list.add(s);
		s = new Student("b",90,"计算机10-1");
		list.add(s);
		s = new Student("b",90,"计算机10-1");
		list.add(s);
		s = new Student("b",90,"计算机10-1");
		list.add(s);
		s = new Student("b",90,"计算机10-1");
		list.add(s);
		s = new Student("b",34,"计算机10-1");
		list.add(s);
		s = new Student("b",90,"计算机10-1");
		list.add(s);
		s = new Student("b",89,"计算机10-1");
		list.add(s);
		s = new Student("b",56,"计算机10-1");
		list.add(s);
		s = new Student("b",90,"计算机10-1");
		list.add(s);
		s = new Student("b",90,"计算机10-1");
		list.add(s);
		s = new Student("c",80,"计算机10-3");
		list.add(s);
		s = new Student("c",80,"计算机10-3");
		list.add(s);
		s = new Student("c",80,"计算机10-3");
		list.add(s);
		s = new Student("c",65,"计算机10-3");
		list.add(s);
		s = new Student("c",80,"计算机10-3");
		list.add(s);
		s = new Student("c",60,"计算机10-3");
		list.add(s);
		s = new Student("c",80,"计算机10-3");
		list.add(s);
		s = new Student("c",70,"计算机10-3");
		list.add(s);
		s = new Student("c",80,"计算机10-3");
		list.add(s);
		s = new Student("c",80,"计算机10-3");
		list.add(s);
		s = new Student("d",80,"计算机10-4");
		list.add(s);
		calculate(list);
	
		
	}
	
	public static void calculate(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++) {
			Integer count = 0;
			Character c = str.charAt(i);
			if((count = map.get(c)) == null || (count = map.get(c)).intValue() == 0) {
				map.put(c, 1);
			} else {
				count = count + 1;
				map.put(c, count);
			}
		}
		System.out.println(map);
	}
	
	public static void calculate(List<Student> students) {
		Map<String, Float> classNumberScoreMapping = new HashMap<String, Float>();
		Map<String, Integer> classNumberStudnetMapping = new HashMap<String, Integer>();
		for(Student student : students) {
			Float score = null;
			if((score = classNumberScoreMapping.get(student.getClassNumber())) == null || (score = classNumberScoreMapping.get(student.getClassNumber())).floatValue() == 0) {
				classNumberScoreMapping.put(student.getClassNumber(), student.getScore());
				classNumberStudnetMapping.put(student.getClassNumber(), 1);
			} else {
				score = score + student.getScore();
				classNumberScoreMapping.put(student.getClassNumber(), score);
				classNumberStudnetMapping.put(student.getClassNumber(), classNumberStudnetMapping.get(student.getClassNumber()).intValue() + 1);
			}
		}
		Set<Entry<String, Float>> entrySet = classNumberScoreMapping.entrySet();
		for(Entry<String, Float> classNumberScore : entrySet) {
			String classNumber = classNumberScore.getKey();
			int studnetsCount = classNumberStudnetMapping.get(classNumber);
			float studentsScore = classNumberScore.getValue().floatValue();
			System.out.println("班级：" + classNumber + ";总分：" + studentsScore + ";平均分：" + (studentsScore/studnetsCount));
		}
 	}
}
