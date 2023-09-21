// Name:
// Date:

public class Sentence
{
   private String mySentence;
   private int myNumWords;

   //Precondition:  str is not empty.
   //               Words in str separated by exactly one blank.
   public Sentence( String str )
   {
      mySentence = str;
      String[] wordNum = str.split("\\s+");
      myNumWords = wordNum.length;
   }

   public int getNumWords()
   {
      return myNumWords;
   }

   public String getSentence()
   {
      return mySentence;
   }

   //Returns true if mySentence is a palindrome, false otherwise.
   //calls the 3-arg isPalindrome(String, int, int)
   public boolean isPalindrome()
   {
      removeBlanks(mySentence);
      lowerCase(mySentence);
      removePunctuation(mySentence);
      return isPalindrome(mySentence, 0, mySentence.length()-1);
   }
   //Precondition: s has no blanks, no punctuation, and is in lower case.
   //Recursive method.
   //Returns true if s is a palindrome, false otherwise.
   public static boolean isPalindrome( String s, int start, int end )
   {
      if(!s.substring(start, start+1).equals(s.substring(end, end+1))){
         return false;
      }
      else if(start>=end){
         return true;
      }
      return isPalindrome(s, start+1, end-1);

   }
   //Returns copy of String s with all blanks removed.
   //Postcondition:  Returned string contains just one word.
   public static String removeBlanks( String s )
   {
      s.replaceAll("\\s", "");
      return s;
   }

   //Returns copy of String s with all letters in lowercase.
   //Postcondition:  Number of words in returned string equals
   //						number of words in s.
   public static String lowerCase( String s )
   {
      s = s.toLowerCase();
      return s;
   }

   //Returns copy of String s with all punctuation removed.
   //Postcondition:  Number of words in returned string equals
   //						number of words in s.
   public static String removePunctuation( String s )
   {
      String punct = ".,'?!:;\"(){}[]<>";
      for(int i = 0; i<s.length(); i++){
         if(punct.contains(s.substring(i, i+1))){
            s = s.substring(0,i)+s.substring(i+1);
         }
      }
      return s;
   }
}