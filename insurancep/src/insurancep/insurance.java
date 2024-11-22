package insurancep;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.*;
import java.util.Random;


class Insure{
	 Scanner sc=new Scanner(System.in);
	 void notARobot() { //FUNCTION to check if the user is not a robot :)
		 String verify;
		 System.out.println("Verify you are not a robot");
		 String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@#";
		 StringBuilder sb=new StringBuilder();
		 Random random=new Random();
		 int len=6;
		 for(int i = 0; i < len; i++) {

		      // generate random index number
		      int index = random.nextInt(alphabet.length());

		      // get character specified by index
		      // from the string
		      char randomChar = alphabet.charAt(index);

		      // append the character to string builder
		      sb.append(randomChar);
		    }
		 String randomString = sb.toString();
		    System.out.println("Captcha " + randomString);
		    System.out.println("enter captcha");
		    
		    
	
		    verify =sc.next();
		    if(verify.equals(randomString)) {
		    	System.out.println("welcome");
		    }
		    else {
		    	System.out.println("traitor,you are a robot");
		    	System.exit(0);
		    }
		    
	
		 
	 }
	 public static int age(LocalDate dob) {
	 LocalDate cur=LocalDate.now();
	 if((dob!=null)&&(cur!=null)) {
	 return Period.between(dob,cur).getYears();

	 }
	 else {
	 return 0;
	 }
	 }
	 int price(int age) {
	 if(age>=18 && age<30) {
	 System.out.println("the price to pay is 10000 per year");
	 return 10000;

	 }
	 else if(age>=30 && age<45) {
	 System.out.println("the price to pay is 15000 per year");
	 return 15000;

	 }
	 else if(age>=45 && age<60) {
	 System.out.println("the price to pay is 20000 per year");
	 return 20000;
	 }
	 else if(age>=60 && age<90) {
	 System.out.println("the price to pay is 30000 per year");
	 return 30000;
	 }
	 else {
	 System.out.println("not eligible");
	 return 0;
	 }

	 }

	 void inp(String name,long ph,String email,String date,int price){




	 String phno=String.valueOf(ph);

	if(email.contains(".")&&email.contains("@")&&phno.length()==10&&date.contains("-")) {

	 String pno="";
	 for(int i=0;i<3;i++){
	 pno=pno+email.charAt(i);
	 }


	 for(int i=0;i<5;i++){
	 pno=pno+phno.charAt(i);
	 }



	 for(int i=0;i<2;i++){

	 pno=pno+name.charAt(i);
	 }

	 
	 System.out.println("Policy number: "+pno);
	 LocalDate dob=LocalDate.parse(date);
	 
	 int age=age(dob);
	 //System.out.println(age(dob));





	 try{
	 File obj=new File(phno);
	 if (obj.createNewFile()){
	 System.out.println("thank you");
	 }
	 else{
	 System.out.println("user already exists");
	 }
	 }
	 catch(IOException e){
	 System.out.println("error");
	 e.printStackTrace();
	 }
	 
	 

	 try{
	 FileWriter writer=new FileWriter(phno);
	 writer.write("Policy Number "+pno+"\n");
	 writer.write("name: "+name+"\n");
	 writer.write("email: "+email+"\n");
	 writer.write("phone number: "+phno+"\n");
	 writer.write("date of birth: "+date+"\n");
	 writer.write("age: "+age+"\n");
	 writer.write("Policy Premium: "+price);
//	 writer.write("policy bought on: ");
	 writer.close();
	 }
	 catch(IOException e){
	 System.out.println("error");
	 e.printStackTrace();
	 }
	 
	 
	
	 
	 //appending to the main file.
	 try {
	 File file = new File("Admin.txt");
	 FileWriter fr = new FileWriter(file, true);
	 BufferedWriter br = new BufferedWriter(fr);
	 br.write("\n");
	 br.write("Policy Number "+pno+"\n");
	 br.write("name: "+name+"\n");
	 br.write("email: "+email+"\n");
	 br.write("phone number: "+phno+"\n");
	 br.write("date of birth: "+date+"\n");
	 br.write("age: "+age+"\n");
	 br.write("Policy Premium: "+price);
	 br.write("\n");
	 br.close();
	 fr.close();
	 }
	 catch(IOException e) {
		 System.out.println("Errors!");
		 e.printStackTrace();
	 }
	 
	 

	 }
	 else {
	 System.out.println("please enter correct phone no and email");
	
	 }

	 }
	 void yes(long ph1) {
	 //System.out.println("enter your phone number");
	 //long ph1=sc.nextLong();
	 String ph1a=String.valueOf(ph1);

	 //System.out.println("true");
	 try{
	 File obj=new File(ph1a);
	 Scanner Reader=new Scanner(obj);
	 while(Reader.hasNextLine()){
	 String data=Reader.nextLine();
	 System.out.println(data);

	 }
	 Reader.close();
	 }
	 catch(FileNotFoundException e){
	 System.out.println("does not exist");
	 e.printStackTrace();

	 }
	 }
	 
	
	}

class Admin extends Insure{
	String user = "VITuniv";
	String pass = "admin1234";
	int check() {
		String new_user;
		String new_pass;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the admin username : ");
		new_user = sc.next();
		System.out.println("Enter the admin password : ");
		new_pass = sc.next();
		if (new_user.equals(user)&&new_pass.equals(pass)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	 void adminreaad() {
		 try{
			 File obj=new File("Admin.txt");
			 Scanner Reader=new Scanner(obj);
			 while(Reader.hasNextLine()){
			 String data=Reader.nextLine();
			 System.out.println(data);

			 }
			 Reader.close();
			 }
			 catch(FileNotFoundException e){
			 System.out.println("cannot fetch data");
			 e.printStackTrace();

			 }
	 }
}




	public class insurance {
	public static void main(String[] args) {
	Insure i=new Insure();
	Admin ad=new Admin();
	 Scanner sc=new Scanner(System.in);
     i.notARobot();
	 System.out.println("\t\t\t\t\t\tONLINE INSURANCE MANAAGEMENT SYSTEM\n");
	
	 System.out.println("Enter 'admin' for admin login\nDo you have a policy\t(No/Yes)?");
	 char b=sc.next().trim().charAt(0);
	 

	 if(b=='y' || b=='Y'){
	 System.out.println("enter your phone number");

	 long ph1=sc.nextLong();
	 i.yes(ph1);


	 }
	 else if(b=='n' || b=='N'){
	 //System.out.println("false");




	 System.out.println("enter phone number");
	 long ph=sc.nextLong();
	 sc.nextLine();



	 System.out.println("enter email id");
	 String email=sc.next();
	 sc.nextLine();


	 System.out.println("dob (yyyy-mm-dd)");

	 String date=sc.nextLine();
	 LocalDate dob=LocalDate.parse(date);
	 int age=i.age(dob);



	 System.out.println("enter name");
	 String name=sc.nextLine();
	 int price=i.price(age);
	 if (price>0) {
	 System.out.println("do you agree to pay?");
	 char yn=sc.next().charAt(0);

	 if(yn=='y' || yn=='Y') {


	 i.inp(name,ph,email,date,price);
	 }

	 else if(yn=='n' || yn=='N') {
	 System.out.println(" THANK YOU PLEASE VISIT AGAIN");
	 }
	 else {
	 System.out.println("invalid");
	 }
	 }
	 else if(price==0) {
	 i.price(age);
	 }

	 }
	 else if(b=='a' || b=='A') {
		 int checker=ad.check();
		 if(checker==1) {
			 ad.adminreaad();
			 }
		 else {
			 System.out.println("not an admin!!");
		 }
		 
		 
	 }
	 else{
	 System.out.println("invalid");
	 }
	}
}