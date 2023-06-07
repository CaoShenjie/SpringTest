package designmode.factorymethod;


public class AbstractFactoryMethod {
    public static void main(String[] args) throws Exception{
        DatabaseUtil databaseUtil = (DatabaseUtil) Class.forName("designmode.factorymethod.DatabaseUtil").newInstance();
        Command command  = (Command) databaseUtil.getCommand();
        Connection connection = (Connection) databaseUtil.getConnection();
    }
}
//数据库连接
interface IConnection{
   void Connection();
}

//数据库命令
interface ICommand{
    void Command();
}

//数据库操作
interface IDataBase{
    ICommand getCommand();
    IConnection getConnection();
}

class Command implements ICommand{

    @Override
    public void Command() {
        System.out.println("数据库命令！");
    }
}
class Connection implements IConnection{

    @Override
    public void Connection() {
        System.out.println("数据库已连接！");
    }
}
class DatabaseUtil implements IDataBase{

    @Override
    public ICommand getCommand() {
        return new Command();
    }

    @Override
    public IConnection getConnection() {
        return new Connection();
    }
}