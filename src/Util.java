

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;



public class Util {
	public static BufferedReader readFile(String src)throws Exception
	{
//		return new BufferedReader(new FileReader(new File(src)));
		return new BufferedReader(new InputStreamReader(new FileInputStream(new File(src)), "UTF-8"));
	}
	
	public static PrintWriter writeFile(String dst)throws Exception
	{
		return new PrintWriter(new FileWriter(dst));
	}
	
	public static boolean saveArrayList(ArrayList<String> list,String dst)throws Exception
	{
		PrintWriter pt=writeFile(dst);
		int i=0;
		while(i<list.size())
		{
			pt.println(list.get(i));
			i++;
		}
		pt.close();
		return true;
	}
	
	public static ArrayList<String> readToArrayList(String src)throws Exception
	{
		BufferedReader br=readFile(src);
		ArrayList<String> list=new ArrayList<>();
		String line="";
		while((line=br.readLine())!=null)
		{
			list.add(line.trim());
		}
		br.close();
		return list;
	}
	
	public static HashMap<String,Integer> readToHashMap(String src)throws Exception
	{
		BufferedReader br=readFile(src);
		HashMap<String,Integer> map=new HashMap<>();
		String line="";
		while((line=br.readLine())!=null)
		{
			map.put(line, 0);
		}
		br.close();
		return map;
	}
	
	
	//数组归一化
	public static double[] normalize(double data[])
	{
		double max=0;
		double min=data[0];
		for(double d:data)
		{
			if (max<d) {
				max=d;
			}
			if (min>d) {
				min=d;
			}
		}
		double grap=max-min;
		double result[]=new double[data.length];
		for(int i=0;i<result.length;i++)
		{
			result[i]=(data[i]-min)/grap;
		}
		return result;
	}
	public static ArrayList<Double> normalize(ArrayList<Double> data)
	{
		double max=0;
		double min=data.get(0);
		for(double d:data)
		{
			if (max<d) {
				max=d;
			}
			if (min>d) {
				min=d;
			}
		}
		double grap=max-min;
		ArrayList<Double> result=new ArrayList<>();
		for(int i=0;i<data.size();i++)
		{
			result.add((data.get(i)-min)/grap);
		}
		return result;
	}
	public static void main(String[] args) {
		for(int i=0;i<65;i++)
		{
			System.out.print("x"+i+",");
		}
	}
}
