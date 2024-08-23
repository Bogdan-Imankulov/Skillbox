public class Main {

    public static void main(String[] args) {
        // write your code here
        Individual individual = new Individual(23400.00);
        Client selfEmployed = new SelfEmployed(335000.32);
        Client organization = new Organization(9000231.00);
      System.out.print("Для частных лиц: ");
        individual.information();
      System.out.print("Для индивидуальных предпринимателей: ");
        selfEmployed.information();
      System.out.print("Для юридических лиц: ");
        organization.information();
        individual.depositAmount(12300);
        selfEmployed.depositAmount(54600.23);
        organization.depositAmount(123456.98);
      System.out.println("Amount of Individual: "+individual.getAmount()+"; Amount of " +
              "Self Employed: "+ selfEmployed.getAmount() + "; Amount of Organization: " + organization.getAmount());
        individual.withdrawAmount(30000);
        selfEmployed.withdrawAmount(30000);
        organization.withdrawAmount(1000000);

    }
}
