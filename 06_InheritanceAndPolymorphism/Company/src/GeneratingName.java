public class GeneratingName {
    private String name;
    private String surname;
    private String[] nameList = {"Василий", "Юрий", "Дмитрий", "Дильшот", "Алексей", "Виталий", "Георгий", "Газиз", "Бек-Султан", "Анатолий"};
    private String[] surnameList = {"Иванов", "Петров", "Васильев", "Демаков", "Егоров", "Булгаков", "Ульянов", "Григорьев", "Климов", "Болотов",
            "Юлдашев", "Абишев", "Мадимаров", "Кадыров", "Исмаилов", "Алиагаев", "Аллавердиев", "Брусилов", "Слоним", "Капица"};
    GeneratingName(){
        surname = surnameList[(int) (Math.random() * 20)];
        name = nameList[(int) (Math.random() * 10)];
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
}
