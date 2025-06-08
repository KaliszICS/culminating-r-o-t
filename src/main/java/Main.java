/**
 * Main part of the Pokemon game the user interacts with
 * @author Radin Ajorlou
 * @version 1.0.0
 */
import java.util.*;

public class Main {

	public static void main(String args[]) {
		Trainer trainer = new Trainer();
		Scanner scanner = new Scanner(System.in);
		String choice;

		//Asks user if they want to start a new game or load a saved one 
		do{
			System.out.println("1. New game   2. Load game");
			choice = scanner.nextLine();
			if (choice.equals("1")){
				System.out.println("Choose your trainer's name: ");
				String name = scanner.nextLine();
				System.out.println("Choose your starting Pokemon\n" +
									"1. Charizard   2. b   3. c");
				
				Charizard charizard = new Charizard(100, 0);
				trainer = new Trainer(name, charizard); //creates a new trainer with the users chosen name
			}

		}
		while (!choice.equals("1") && !choice.equals("2"));

		while (true){
			System.out.println("1. Fight   2. Go to shop   3. Save game   4. Load File");
			choice = scanner.nextLine();
			switch(choice){
				case "1":
				System.out.println("Choose Level: 1 - " + (trainer.getGameLevel() + 1) + "\nb. Go back");
				choice = scanner.nextLine();
				int levelChoice;

				try{
					levelChoice = Integer.parseInt(choice);
				}
				catch(Exception e){
					levelChoice = 0;
				}
				while (levelChoice < 1 && levelChoice > trainer.getGameLevel() + 1 && !choice.equals("b")){
					System.out.println("You can not play this level.");
					choice = scanner.nextLine();
				}

				if(choice.equals("b")){
					break; //if user enters b go back to start
				}

				System.out.println("1. Play with active Pokemon   2. Switch Pokemon   b. Go back");
				choice = scanner.nextLine();
				while (!choice.equals("1") && !choice.equals("2") && !choice.equals("b")){
					System.out.println("Not a real choice");
					choice = scanner.nextLine();
				}

				if (choice.equals("b")){
					break;
				}

				else if(choice.equals("1")){ 
					boolean wonOrLost = trainer.getActivePokemon().playLevel(levelChoice); //battles level choice with active Pokemon
					if (wonOrLost == true && levelChoice > trainer.getGameLevel()){
						trainer.setGameLevel(levelChoice);
						System.out.println(trainer.getName() + " has reached level " + trainer.getGameLevel() + " and can play level " + (trainer.getGameLevel() + 1));
					}
				}

				else{

				}


			}
		}




	}

}
