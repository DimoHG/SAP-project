package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import event.Event;
import event.FileOperator;
import wagu.Board;
import wagu.Table;

public class SAPtesting {
	public static void main(String[] args){
		System.out.println("Welcome to day planner");
		Scanner scan= new Scanner(System.in);
		String iterator=scan.nextLine();
		String[] arguments=iterator.split("\\s+");
		System.out.println(arguments[0]);
		
	}


}