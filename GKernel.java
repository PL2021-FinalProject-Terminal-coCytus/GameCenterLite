package gameCenter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import finalCode.FinalCode;
import guessTheNumber.GuessTheNumber;

public class GKernel {
	private GUser using;
	private static ArrayList<Projects> queue = new ArrayList<>(); 
	
	public void kernelMain() {
		GSwitch switcher = new GSwitch();
		QueueInitialize();
		Scanner inputcom = new Scanner(System.in);
		
		printOption();
		System.out.print("Please enter your command: ");
		while(inputcom.hasNextLine()) {
			String content = inputcom.nextLine();
			boolean key = false;
			int index = -10;
			for(int i = 0; i < queue.size(); i++) {
				Projects ins = queue.get(i);
				if(content.equals(ins.GetWord())) {
					key = true;
					index = i-1;
					break;
				}
			}
			if(key) {
				Parallel(switcher);
				
				GuessTheNumber g = new GuessTheNumber(using);
				FinalCode f = new FinalCode(using);
				
				
				switcher.Operate(index);
			}else {
				System.out.println("I don't understand your command.");	
			}
			System.out.print("Please enter your command: ");
		}
	}
	
	public void QueueInitialize() {
		File instruction = new File("Instruction.txt");
		try{
			Scanner reader = new Scanner(instruction);
			try {		
				while(reader.hasNextLine()) {
					String content = reader.nextLine();
					Projects newInstruction = new Projects(content);
					queue.add(newInstruction);
				}
			}finally {
				reader.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	public void setUser(GUser u) {
		using = u;
	}
	
	public void Parallel(GSwitch s) {
		s.setUser(using);
	}
	
	public void printOption() {
		System.out.println("Game we have:");
		for(Projects i:queue) {
			System.out.println(i.GetWord());
		}
		System.out.println("");
	}
	
	public Projects getProject(int i) {
		return queue.get(i);
	}

}
