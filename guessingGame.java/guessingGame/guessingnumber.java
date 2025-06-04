import java.util.Random;
import java.util.Scanner;

public class guessingnumber {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playagain = true;

        System.out.println("Welcome in the number Guessing game ");

        while(playagain){
            int numberToGuess = random.nextInt(100) + 1;
            int guess ;
            int attempt = 0;
            boolean hasGuessCorrectly = false;

            System.out.println("\n I'm thinking of a random number between 1 and 100, guess it ");
            System.out.println("type exit anytime for exiting the game ");

            while (!hasGuessCorrectly){
                System.out.println("Enter your Guess");
                String input = sc.nextLine().trim();

                 if(input.equals("exit")) {
                System.out.println("exiting the game");
                System.exit(attempt);
                 }

                   try{
                guess = Integer.parseInt(input);
                attempt++;

                if(guess <1 || guess >100){
                    System.out.println("guess between 1 and 100") ;

                } else if(guess < numberToGuess){
                    System.out.println("Too low " + attempt + "attempt");

                } else if(guess > numberToGuess){
                    System.out.println("too high " + attempt+ "attempt");
                } else {
                    System.out.println("correct you guessed right " + attempt + "attempt");
                    hasGuessCorrectly = true;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid Input ");
            }
            System.out.println("want to play again? yes/no/exit ");
            String playagainInput = sc.nextLine().trim().toLowerCase();


            // playagain = playagainInput.equals("yes") || playagainInput.equals("y");
           
            if(playagainInput.equals("exit")) {
                System.out.println("Exiting the game ");
                System.exit(0);
            } else if(!playagainInput.equals("yes") && !playagainInput.equals("y")){
                playagain = false;
            }
            
         
        }
        System.out.println("thanks for playing ");
        sc.close();
    }
}
}