import java.util.HashMap;


public class CustomerStorage
{
    private HashMap<String, Customer> storage;
    private final String regExEmail = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.[a-z]{2,6}$";
    private final String regExPhone = "\\+?\\d{1,3}(\\(?|\\s?)\\d{3}(\\)?|\\s?)\\d{3}(-?|\\s?)\\d{2}(-?|\\s?)\\d{2}";

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalArgumentException
    {
        String[] components = data.split("\\s+");
            if (components.length != 4){
                throw new  ArrayIndexOutOfBoundsException("Incorrect command arguments count, " +
                        "print \"help\" to see command format!!!\n" +
                        "Неверное кол-во аргументов команды, " +
                        "введите \"help\" чтобы увидеть формат комманд");
            }
            String name = components[0] + " " + components[1];
            if (!components[3].matches(regExPhone)){
                throw new IllegalArgumentException("Incorrect phone number format!!!\n" +
                        "Неверный формат номера телефона!!!");
            }
            if (!components[2].matches(regExEmail)){
                throw new IllegalArgumentException("Incorrect e-Mail format!!!\n" +
                        "Неверный формат e-Mail!!!");
            }
            storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws IllegalArgumentException
    {
        if (storage.containsKey(name)) {
            storage.remove(name);
        }else {
            throw new IllegalArgumentException("There is no customer with name " + name +
                    ". Add it or enter name and surname" +
                    "Сотрудника с таким именем " + name + ". Добавьте его или " +
                    "введите имя и фамилию");
        }
    }

    public int getCount()
    {
        return storage.size();
    }
}