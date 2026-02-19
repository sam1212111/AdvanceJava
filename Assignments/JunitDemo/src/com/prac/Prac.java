package com.prac;

import java.util.*;
import java.io.*;

class Prac{
	public static void main(String []argh)
	{
        Map<String,Integer> hs = new HashMap<>();
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
			if(!hs.containsKey(name)){
               hs.put(name, phone); 
            }
		}
		while(in.hasNextLine())
		{
			String s=in.nextLine();
            if(hs.containsKey(s)){
                System.out.println(s+" = "+hs.get(s));
            }else{
                System.out.println("Not found");
            }
            
		}
        
        
	}
}



