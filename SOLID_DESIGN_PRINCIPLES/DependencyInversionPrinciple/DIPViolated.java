package SOLID_DESIGN_PRINCIPLES.DependencyInversionPrinciple;

// High level modules directly not interact with low level modules there will be a interface(abstraction)between them.
// plays keys role or both low and high level communicated via interface

// low level modules
class MySQLDatabase {
    public void saveToMYSQL(String data) {
        System.out.println("Executing SQL Query: INSERT INTO users VALUES('" + data + "');");
    }
}

class MongoDBDatabase {
    public void saveToMongoDB(String data) {
        System.out.println("Executing MongoDB Function: db.users.insert({name: '" + data + "'})");
    }
}

// High level modules
// Changing the low-level implementation (e.g., swapping MongoDB for Cassandra)
// forces modifications in the high-level class-violating OCP.
class UserService {

    MySQLDatabase mySQLDatabase = new MySQLDatabase();
    MongoDBDatabase mongoDBDatabase = new MongoDBDatabase();

    public void saveToMySQL(String data) {
        mySQLDatabase.saveToMYSQL(data);
    }

    public void saveToMongoDb(String data) {
        mongoDBDatabase.saveToMongoDB(data);
    }
}

public class DIPViolated {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.saveToMySQL("MYSQLDATA");
        userService.saveToMongoDb("MONGODATA");
    }
}
