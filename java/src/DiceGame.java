import java.util.Scanner;
import java.util.Random;
/**
 * This class runs a ruditmentary black jack game using dice printed in the shell.
 * Only the palyer's roll and score is displayed to the shell.
 * The first methid takes in two integer parameters to determine the how much the player rolled in a given turn.
 * The second method takes in two integer parameters and returns the how much the computer rolled.
 * The main has two nested loops that run an individual match and then continues prompting the user to play matches until
 * the user inputs otherwise.
 **/
public class DiceGame {
    public static int playerDice(int ranNum, int rollNum){
        switch(ranNum){
            case 1:
                System.out.println(" ---------\n|         |\n|    *    |\n|         |\n ---------");
                rollNum += 1;
                return rollNum;
            case 2:
                System.out.println(" ---------\n|  *      |\n|         |\n|      *  |\n ---------");
                rollNum += 2;
                return rollNum;
            case 3:
                System.out.println(" ---------\n|  *      |\n|    *    |\n|      *  |\n ---------");
                rollNum += 3;
                return rollNum;
            case 4:
                System.out.println(" ---------\n|  *   *  |\n|         |\n|  *   *  |\n ---------");
                rollNum += 4;
                return rollNum;
            case 5:
                System.out.println(" ---------\n|  *   *  |\n|    *    |\n|  *   *  |\n ---------");
                rollNum += 5;
                return rollNum;
            default:
                System.out.println(" ---------\n|  *   *  |\n|  *   *  |\n|  *   *  |\n ---------");
                rollNum += 6;
                return rollNum;
        }
    }
    public static int dealerDice(int ranNum, int dealNum){
        switch(ranNum){
            case 1:
                dealNum += 1;
                return dealNum;
            case 2:
                dealNum += 2;
                return dealNum;
            case 3:
                dealNum += 3;
                return dealNum;
            case 4:
                dealNum += 4;
                return dealNum;
            case 5:
                dealNum += 5;
                return dealNum;
            default:
                dealNum += 6;
                return dealNum;
        }
    }
    public static void main(String[] args){
        Scanner myscanner = new Scanner(System.in);
        
        int random = 0;
        int dealNum = 0;
        int dealRandom = 0;
        int rollNum = 0;
        String command1 = " ";
        String command2 = "hold";
        String playAgain = " ";
        String stopGame = "stop";
        int gameNum = 0;
        
        while(!(playAgain.toLowerCase().equals(stopGame))){
            gameNum++;
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("[BLACK JACK GAME " + gameNum + "]\n");        
            while(!(command1.toLowerCase().equals(command2))){
                //Generate the two dice and calculate player's score      
                for(int i = 0; i < 2; i++){
                    random = 1 + (int)(Math.random() * 6);
                    rollNum = playerDice(random, rollNum);
            
                }
                //Calculate the dealer's score
                for(int x = 0; x < 2; x++){
                    dealRandom =  1 + (int)(Math.random() * 6);
                    dealNum = dealerDice(dealRandom, dealNum);
                }            
                if(rollNum >= 21){
                    System.out.println("-Your roll total is " + rollNum + ".");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                }            
                System.out.println("-Your roll total is " + rollNum + ".");
                System.out.print("-Type \"hit\" to roll again and \"hold\" to stop: ");
                command1 = myscanner.nextLine();
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(" ");        
            }
            System.out.println("[GAME OVER]\n");
            if(rollNum <= 21 && rollNum > dealNum){
                System.out.println("-You're score is " + rollNum + " and the dealer's score is " + dealNum + ". You win!!");
            }else if(rollNum < dealNum && dealNum <= 21){
                System.out.println("-You're score is " + rollNum + " and the dealer's score is " + dealNum + ". You lose.");            
            }else if(rollNum > 21 && dealNum <= 21){
                System.out.println("-Your score is " + rollNum + ". That means you've busted so the dealer wins with a score of " + dealNum + ".");
            }else if(rollNum <= 21 && dealNum > 21){
                System.out.println("-The dealer busted with a score of " + dealNum + " so that means you win because you scored " + rollNum + ".");
            }else if(rollNum > 21 && dealNum > 21 && rollNum < dealNum){
                System.out.println("-You both busted but since your score was less than the dealer's score you win with a score of " + rollNum + " and the dealer loses with a score of " + dealNum + ".");
            }else if(rollNum > 21 && dealNum > 21 && rollNum > dealNum){
                System.out.println("-You both busted but the dealer wins because your score was higher than the dealer's score. You lose with a score of " + rollNum + " and the dealer wins with " + dealNum + ".");
            }else if(dealNum == rollNum){
                System.out.println("-You tied with the dealer because you both scored " + rollNum + ".");
            }else{
                System.out.println("-There was a problem with Eli's conditional statement.");
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("\n-Enter \"play\" to keep playing or \"stop\" to exit the game: ");
            playAgain = myscanner.nextLine();
            System.out.println(" ");
            rollNum = 0;
            dealNum = 0;
            command1 = " ";
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("[EXIT]\n");
        System.out.println("Thanks for playing!");            
    }    
}