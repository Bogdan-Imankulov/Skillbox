import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {


    private static final String incorrectArgsCountException = """
            Внимание!!!
            Вы ввели неправильное количество аргументов для команды!!!
            Перепроверьте написание команды и повторите команду снова
            Чтобы вывести список команд напишите HELP""";
    //     commandArgs[2]
    private static final String instructions = """
            Список команд:
            \t HELP - выводит список команд
            \taddShop "Название магазина" - добавить магазин
            \taddProduct "Название продукта" "Цена товара" - добавить товар
            \texhibitProduct "Название магазина" "Название товара" - выставить товар
            \taggregate - выводит средние показатели по каждому магазину:
            \t\tОбщее количество товаров
            \t\tСредняя цена товаров
            \t\tСамый дорогой и дешевый товар
            \t\tКоличество товаров дешевле 100 рублей
            \tclearShop - очищает хранилище магазинов
            \tclearProduct - очищает хранилище товаров
            Команды вводить строго в указанном регистре, без кавычек, названия продуктов и магазинов в одно слово, цену писать цифрами""";
    private static final MongoClient client = new MongoClient();
    private static final MongoDatabase db = client.getDatabase("db");
    private static final MongoCollection<Document> shopStorage = db.getCollection("ShopList");
    private static final MongoCollection<Document> productStorage = db.getCollection("ProductList");

    public static void main(String[] args) {
        System.out.println(instructions);
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                String line = scan.nextLine();
                String[] commandArgs = line.split(" ");
                String command = commandArgs[0];
                switch (command) {
                    case "HELP" -> System.out.println(instructions);
                    case "addShop" -> {
                        String shopName = commandArgs[1];
                        addShop(shopName);
                    }
                    case "addProduct" -> {
                        String productName = commandArgs[1];
                        double productPrice = Double.parseDouble(commandArgs[2]);
                        addProduct(productName, productPrice);
                    }
                    case "exhibitProduct" -> {
                        String shopName = commandArgs[1];
                        String productName = commandArgs[2];
                        exhibitProduct(shopName, productName);
                    }
                    case "getShop" -> {
                        String shopName = commandArgs[1];
                        getShop(shopName);
                    }
                    case "clearShop" -> {
                        shopStorage.deleteMany(new BasicDBObject());
                        System.out.println("Хранилище магазинов было успешно очищено");
                    }
                    case "clearProduct" -> {
                        productStorage.deleteMany(new BasicDBObject());
                        System.out.println("Хранилище товаров было успешно очищено");
                    }
                    case "aggregate" -> {
                        aggregate();
                    }
                    default -> System.out.println("Введенная вами команда не найдена. \n" + instructions);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println(incorrectArgsCountException);
            }
        }
    }

    private static void addShop(String shopName) {
        Document shop = new Document("name", shopName);
        shop.append("products", new ArrayList<String>());
        if (getShop(shopName) == null) {
            shopStorage.insertOne(shop);
            System.out.printf("Магазин с названием %s был добавлен.\n", shopName);
        } else
            System.out.println("Такой магазин уже существует.");
    } 

    private static Document getShop(String shopName) {
        return shopStorage.find(new Document("name", shopName)).first();
    }

    private static void addProduct(String productName, double productPrice) {
        Document shop = new Document("name", productName);
        shop.append("price", productPrice);
        if (getProduct(productName) == null) {
            productStorage.insertOne(shop);
            System.out.printf("Товар с названием %s был добавлен.\n", productName);
        } else
            System.out.println("Такой товар уже существует.");
    }

    private static Document getProduct(String productName) {
        return productStorage.find(new Document("name", productName)).first();
    }

    private static void exhibitProduct(String shopName, String productName) {
        Document shop = getShop(shopName);
        shop.get("products", new ArrayList<String>()).add(productName);
        System.out.printf("Товар %s был выставлен в магазине %s.\n", productName, shopName);
    }

    private static void aggregate() {
        AggregateIterable<Document> count = productStorage.aggregate(Arrays.asList(
                Aggregates.lookup("ShopList", "name", "products", "shop_list"),
                Aggregates.unwind("$shop_list"),
                Aggregates.group("$shop_list.name",
                        Accumulators.sum("count", 1),
                        Accumulators.min("min", "$price"),
                        Accumulators.max("max", "$price"),
                        Accumulators.avg("avg", "$price"))));
        printInfo(count);
    }
    private static void printInfo(AggregateIterable<Document> iterable){
        for (Document document : iterable) {
            String shopName = (String) document.get("_id");
            System.out.println("Магазин: " + shopName);
            System.out.println("Кол-во товаров: " + document.get("count"));
            System.out.println("Самый дешевый: " + document.get("min"));
            System.out.println("Самый дорогой: " + document.get("max"));
            System.out.println("Средняя цена" + document.get("avg"));
//            System.out.println("Кол-во товаров дешевле чем 100: " + document.get("lessCount"));
        }
    }
}
