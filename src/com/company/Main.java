package com.company;
import java.io.*;
import java.io.File;
import java.io.PrintWriter;

public class Main {

	private static boolean isDigit(String s)  {
		for(int i = 0; i < s.length(); ++i){
			if((int)s.charAt(i) < 48 || (int)s.charAt(i) > 57){
				return false;
			}
		}
		return true;
	}
	private static boolean isChart(String s) {
		for(int i = 0; i < s.length(); ++i){
			if((int)s.charAt(i) < 48 || ((int)s.charAt(i) > 57 && (int)s.charAt(i) < 65)||
					(int)s.charAt(i) > 90){
				return false;
			}
		}
		return true;
	}
	private static boolean isChart2(String s) {
		for(int i = 0; i < s.length(); ++i){
			if((int)s.charAt(i) < 65 || (int)s.charAt(i) > 90){
				return false;
			}
		}
		return true;
	}
	private static boolean isChartAndDigit(String s) {
		for(int i = 0; i < 2; ++i){
			if((int)s.charAt(i) < 65 || (int)s.charAt(i) > 90){
				return false;
			}
		}
		for(int i = 2; i < 12; ++i){
			if((int)s.charAt(i) < 48 || (int)s.charAt(i) > 57){
				return false;
			}
		}
		return true;
	}
    public static void main(String[] args) {
		int error = 0;
	   String file = "C:\\Users\\Сурэн\\Downloads\\output1.csv";
	   BufferedReader reader = null;
	   String line = "";

	   try{
	       reader = new BufferedReader(new FileReader(file));
	       while((line = reader.readLine()) != null){
	           String[] row = line.split(",");
	           int position = 1;
	           for(String index : row){
	           		switch (position){
						case 1:
							if((index.length() < 8 || index.length() > 13) || index.charAt(0) == '0' || !(isDigit(index))){
								error++;
								System.out.printf("!");
							}
							break;
						case 2:
							if(index.length() != 10 || !(isChart(index))){
								error++;
								System.out.printf("!");
							}
							break;
						case 3:
							if(index.length() != 12 || !(isChartAndDigit(index))){
								error++;
								System.out.printf("!");
							}
							break;
						case 4:
							if(index.length() < 1 || index.length() > 6 || !isChart2(index)){
								error++;
								System.out.printf("!");
							}
							break;
						case 5:
							if(!isDigit(index) || Integer.parseInt(index) < 1 || Integer.parseInt(index) > 100000){
								error++;
								System.out.printf("!");
							}
							break;
						case 6:

							break;
						case 7:
							break;
						case 8:
							break;
						case 9:
							break;
						default:

							break;
					}
	               System.out.printf("%-25s",index);
	           		position++;
               }
			   position = 0;
               System.out.println();
           }
		   System.out.println(error);
		   System.out.println(isChartAndDigit("AZ2320222229"));
		   System.out.println("-----------------------");
		   reader = new BufferedReader(new FileReader("C:\\Users\\Сурэн\\Downloads\\csv2.csv"));
		   while((line = reader.readLine()) != null){
			   String[] row = line.split(",");

			   for(String index : row){
				   System.out.printf("%20s",index);
			   }
			   System.out.println();
		   }
       }
	   catch(Exception e){
	       e.printStackTrace();
	   }
	   finally{
	       try {
               reader.close();
           }
	       catch (IOException e){
	           e.printStackTrace();
           }
	   }
	   try {
		   PrintWriter pw = new PrintWriter(new File("C:\\Users\\Сурэн\\Documents\\csv\\alerts_datestamp.csv"));
		   StringBuilder sb = new StringBuilder();

		   sb.append("Alert ID");
		   sb.append(",");
		   sb.append("Alert type");
		   sb.append(",");
		   sb.append("Description");
		   sb.append(",");
		   sb.append("Affected transactions count");
		   sb.append("\n");

		   sb.append("ICA260120211");
		   sb.append(",");
		   sb.append("ICA");
		   sb.append(",");
		   sb.append("Currency field is incorrect for the combination of <Execution Entity Name> and <Instrument Name>");
		   sb.append(",");
		   sb.append("5");
		   sb.append("\n");

		   sb.append("PPA260120212");
		   sb.append(",");
		   sb.append("PPA");
		   sb.append(",");
		   sb.append("Potential pumping price activity has been noticed for the following combination  of<Execution Entity Name>, <Instrument Name> and <Currency> where an average price is greater than previous more than 50% and is <Current percent>");
		   sb.append(",");
		   sb.append("10");
		   sb.append("\n");

		   pw.write(sb.toString());
		   pw.close();
	   }catch (Exception e){

	   }
    }
}
