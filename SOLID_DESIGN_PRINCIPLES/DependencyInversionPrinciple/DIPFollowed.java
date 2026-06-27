package SOLID_DESIGN_PRINCIPLES.DependencyInversionPrinciple;

interface DBPersistance {
    public void save(String data);
}

// Low level module depends on interface(abstraction)
class MySQLDatabase implements DBPersistance {
    public void save(String data) {
        System.out.println("Executing SQL Query: INSERT INTO users VALUES('" + data + "');");
    }
}

class MongoDBDatabase implements DBPersistance {
    public void save(String data) {
        System.out.println("Executing MongoDB Function: db.users.insert({name: '" + data + "'})");
    }
}

// High level module depends on interface(abstraction)
class UserService {
    private DBPersistance db;

    public UserService(DBPersistance db) {
        this.db = db;
    }

    public void SaveTODB(String data) {
        db.save(data);
    }
}

public class DIPFollowed {
    public static void main(String[] args) {
        MySQLDatabase mySQLDatabase = new MySQLDatabase();
        MongoDBDatabase mongoDBDatabase = new MongoDBDatabase();

        UserService userService1 = new UserService(mySQLDatabase);
        userService1.SaveTODB("MYSQLDATA");

        UserService userService2 = new UserService(mongoDBDatabase);
        userService2.SaveTODB("MONGODATA");
    }
}
