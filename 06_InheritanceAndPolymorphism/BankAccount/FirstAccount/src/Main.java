import Bank.*;
import Employee.Company;
import Employee.Employee;
import Employee.TopManager;
import Employee.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        /*
        System.out.println();
        System.out.println("First BankAccount");
        System.out.println();
        BankClass bankClass = new BankClass(5000);
        bankClass.bankMoneyAdd(247);

        System.out.println();
        System.out.println("Card account");
        System.out.println();
        CardBankAccount cardBankAccount = new CardBankAccount(8000);
        cardBankAccount.moneyWithdraw(1);

        System.out.println();
        System.out.println("DepositAccount");
        System.out.println();
        DepositAccount depositAccount = new DepositAccount(8125);
        depositAccount.moneyWithdraw(125);

        System.out.println();
        System.out.println("Sending money");
        System.out.println();
        BankClass senderAccount = new BankClass(1000);
        DepositAccount receiverAccount = new DepositAccount(10);
        receiverAccount.sendMoney(senderAccount, 101);
*/

/*
        System.out.println();
        System.out.println("Individual");
        System.out.println();
        Individual individual = new Individual(1500);
        individual.moneyWithdraw(500);
        System.out.println(individual.getMoneyAmount());
        individual.moneyAdd(1000);
        System.out.println(individual.getMoneyAmount());

        System.out.println();
        System.out.println("Entity");
        System.out.println();
        Entity entity = new Entity();
        System.out.println(entity.getMoneyAmount());
        entity.moneyAdd(1000);
        System.out.println(entity.getMoneyAmount());
        entity.moneyWithdraw(100);
        System.out.println(entity.getMoneyAmount());

        System.out.println();
        System.out.println("Self Employed");
        System.out.println();
        SelfEmployed selfEmployed = new SelfEmployed(100);
        System.out.println(selfEmployed.getMoneyAmount());
        selfEmployed.moneyAdd(1000);
        System.out.println(selfEmployed.getMoneyAmount());
*/
//        Company company = new Company("Pelmen Inc.");
//        Operator operator = new Operator("Anton ", "Kurilov");
//        Manager manager = new Manager("Alizhan ", "Saparaliev");
//        TopManager topManager = new TopManager("Vyacheslav ", "Kuzmin");
//        System.out.println(company.toString());
//        System.out.println(operator.toString());
//        System.out.println(manager.toString());
//        System.out.println(topManager.toString());
//        company.hire(operator);
//        company.hire(manager);
//        company.hire(topManager);
//        System.out.println(company.toString());
//        System.out.println(company.getListAsString(company.getEmployeesList()));
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Operator("Саня", "Курилов"));
//        employees.add(new Manager("Алижан", "Сапаралиев"));
//        employees.add(new TopManager("Пельмень", "Ледяной"));
//        employees.add(new Operator("Курилов", "Саня"));
//        employees.add(new Manager("Сапаралиев", "Алижан"));
//        employees.add(new TopManager("Ледяной", "Пельмень"));
//        employees.add(new Operator("Саня", "Просто саня"));
//        employees.add(new Manager("Алижан", "Просто алижан"));
//        employees.add(new TopManager("Пельмень", "Просто ледяной"));
//        Company company1 = new Company("Kaktus Inc.");
//        company1.hireAll(employees);
//        System.out.println(company1.toString());
//        System.out.println(company1.getListAsString(company1.getEmployeesList()));
//        System.out.println(company1.getListAsString(company1.getTopSalaryStaff(9)));
        Company company = new Company("Чистые пельмени");
        for (int i = 0; i < 180; i++) {
            char[] nameLet = new char[5];
            char[] surnameLet = new char[5];
            for (int j = 0; j < 5; j++) {
                nameLet[j] = (char)(int)(65+Math.random()* 25);
                surnameLet[j] = (char)(int)(65+Math.random()* 25);
            }
            String name = "";
            String surname = "";
            for (int j = 0; j < 5; j++) {
                name += nameLet[j];
                surname += surnameLet[j];
            }
            Operator operator = new Operator(name, surname, company);
        }
        for (int i = 0; i < 80; i++) {
            char[] nameLet = new char[5];
            char[] surnameLet = new char[5];
            for (int j = 0; j < 5; j++) {
                nameLet[j] = (char)(int)(65+Math.random()* 25);
                surnameLet[j] = (char)(int)(65+Math.random()* 25);
            }
            String name = "";
            String surname = "";
            for (int j = 0; j < 5; j++) {
                name += nameLet[j];
                surname += surnameLet[j];
            }
            Manager manager = new Manager(name, surname, company);
        }
        for (int i = 0; i < 10; i++) {
            char[] nameLet = new char[5];
            char[] surnameLet = new char[5];
            for (int j = 0; j < 5; j++) {
                nameLet[j] = (char)(int)(65+Math.random()* 25);
                surnameLet[j] = (char)(int)(65+Math.random()* 25);
            }
            String name = "";
            String surname = "";
            for (int j = 0; j < 5; j++) {
                name += nameLet[j];
                surname += surnameLet[j];
            }
            TopManager topManager = new TopManager(name, surname, company);
        }

//        System.out.println(company.getListAsString(company.getTopSalaryStaff(15)));
//        System.out.println(company.getListAsString(company.getLowestSalaryStaff(15)));
        System.out.println(company.getEmployeesList().size());
        System.out.println(company.getEmployeesList().size() / 2);
        for (int i = 0; i < company.getEmployeesList().size() ; i++) {
            company.fire(company.getEmployeesList().get(i));
        }
        System.out.println(company.getEmployeesList().size());
//        System.out.println(company.getListAsString(company.getTopSalaryStaff(15)));
//        System.out.println(company.getListAsString(company.getLowestSalaryStaff(15)));
    }
}