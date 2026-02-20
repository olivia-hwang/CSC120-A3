// You should **not** update any call signatures in this file
// only modify the body of each function
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Conversation implements ConversationRequirements {

  // Attributes 
  private List<String> transcript = new ArrayList<String>();

  /**
   * Constructor 
   */
  Conversation() {
    
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    //Establish number of rounds
    Scanner userInput = new Scanner (System.in);
    System.out.println("Welcome to the chatbot. How many rounds would you like to speak?");
    int number = userInput.nextInt();
    userInput.nextLine(); // consume the leftover newline

    System.out.println("What's on your mind?");

      //Call response method for each round of conversation
    for (int i = 1; i <= number; i++) {
      String userResponse = userInput.nextLine();
      transcript.add(userResponse);
      if(i != number) { 
        transcript.add(respond(userResponse));
        System.out.println(respond(userResponse));

      }
      else {
        System.out.println(" Cool! Thanks for chatting with me :)");
        transcript.add(" Cool! Thanks for chatting with me :)");
        System.out.println("Here is the transcript of our conversation:");
        printTranscript();
      }      
    }
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println(transcript);
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {

    String chatbotResponse = ""; // Declare chatbotResponse at the start
      
    // make an array of strings where each word is a different string
      String[] returnArray = inputString.split(" ");
      String[] outputArray = returnArray; //This doesn't do anything

      //replace the mirror words
      int length = returnArray.length;
      //check for mirror words
      boolean mirrorWordsExist = false;
      for (int i=0; i <length; i++) {
          if ("I".equals(returnArray[i])) {
            outputArray[i] = "you";
            outputArray[length-1] = outputArray[length-1] + "?";
            mirrorWordsExist = true;
          } else if ("me".equals(returnArray[i])){
            outputArray[i] = "you";
            outputArray[length-1] = outputArray[length-1] + "?";
            mirrorWordsExist = true;
          } else if ("am".equals(returnArray[i])){
            outputArray[i] = "are";
            outputArray[length-1] = outputArray[length-1] + "?";
            mirrorWordsExist = true;
          } else if ("you".equals(returnArray[i])){
            outputArray[i] = "I";
            outputArray[length-1] = outputArray[length-1] + "?";
            mirrorWordsExist = true;
          } else if ("my".equals(returnArray[i])||"My".equals(returnArray[i])){
            outputArray[i] = "your";
            outputArray[length-1] = outputArray[length-1] + "?";
            mirrorWordsExist = true;
          } else if ("your".equals(returnArray[i])||"Your".equals(returnArray[i])){
            outputArray[i] = "my";
            outputArray[length-1] = outputArray[length-1] + "?";
            mirrorWordsExist = true;
          } 
      
        } 

          //check if mirror words are in the inputString
          if (mirrorWordsExist ) {
            //put back into string format
            chatbotResponse = String.join(" ", outputArray);
          } else{
            String[] cannedResponses = {"mmhmm", "I see", "Wow! That's so interesting", "Can you tell me more?", "Oh...", "Thanks for that!", "Ok", "Niiice", "Ok...", "Why?"};
            int randomNum = (int) (Math.random() *10);
            chatbotResponse = cannedResponses[randomNum];
          }
    return chatbotResponse;
    }


  

  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
} // end of Conversation class
