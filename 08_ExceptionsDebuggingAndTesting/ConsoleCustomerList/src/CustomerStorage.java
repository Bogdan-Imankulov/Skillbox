import java.util.HashMap;
<<<<<<< HEAD
import java.util.regex.Matcher;
import java.util.regex.Pattern;
=======
>>>>>>> 0d6e8e0d0dc9c5ef138b3d4a29fdbe5257d59d11

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }
<<<<<<< HEAD
    //шаблон проверки емайла
    Pattern email = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.[a-z]{2,6}$");
    //шаблон проверки сотового телефона для России и Казахстана
    Pattern phone = Pattern.compile("^\\+7\\d{10}");
    //Шаблон проверки имени, на кирилице, добавил по собственной инициативе
    Pattern name = Pattern.compile("[а-яА-Я]");
    //шаблон проверки фамилии, возможна двойная фамилия с дефисом
    Pattern surname = Pattern.compile("[а-яА-Я\\-]");

=======
>>>>>>> 0d6e8e0d0dc9c5ef138b3d4a29fdbe5257d59d11

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
<<<<<<< HEAD
        //количество введенных данных неправильно
        if (components.length!=4){
            throw new IllegalArgumentException("Неправильный формат ввода, правильный формат:\n" +
                    "Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        Matcher matcherEmail = email.matcher(components[2]);
        Matcher matcherPhone = phone.matcher(components[3]);
        Matcher matcherName = name.matcher(components[0]);
        Matcher matcherSurname = surname.matcher(components[1]);

        //check name
        if (!matcherName.find() || !matcherSurname.find()){
            throw new IllegalArgumentException("Неправильно введено имя или фамилия, введите на кирилице");
        }
        //check email
        if (!matcherEmail.find()){
            throw  new IllegalArgumentException("Вы вввели неправильный емайл. Правильные формат:\n" +
                    "vasily.petrov@gmail.com");
        }
        //check phone
        if (!matcherPhone.find()){
            throw new IllegalArgumentException("Вы ввели неправильный формат телефона. Правильный формат:\n" +
                    "+79215637722");
        }

=======
>>>>>>> 0d6e8e0d0dc9c5ef138b3d4a29fdbe5257d59d11
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}