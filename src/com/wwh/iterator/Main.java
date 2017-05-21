package com.wwh.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ������ģʽ�ṩ��һ�ַ���˳����ʾۺ϶����еĸ���Ԫ�أ����ֲ���¶���ڲ��ı�ʾ��
 */
public class Main {

	public static void main(String[] args) {
		String[] array=new String[]{"a","b","c"};
		for(String s:array){
			System.out.println(s);
		}
		List< String> list=new ArrayList<>();
		list.add("d");list.add("e");list.add("f");
		for(String s:list){
			System.out.println(s);
		}
		Map<Integer, String> map=new HashMap<>();
		map.put(1, "g");map.put(1, "h");map.put(1, "i");
		for(String s:map.values()){
			System.out.println(s);
		}
	}
}
