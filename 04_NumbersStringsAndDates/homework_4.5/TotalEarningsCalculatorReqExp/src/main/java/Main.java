public class Main {

  public static void main(String[] args) {

  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
      int salary = 0;
      String [] words = text.split("\\s+");
      for (int i =0; i < words.length; i++)
      {
          if (Character.isDigit(words[i].charAt(0)))
          {
              salary = salary + Integer.parseInt(words[i]);
          }
      }
    return salary;
  }

}