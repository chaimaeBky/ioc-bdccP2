package dao;

public class DaoImpl implements IDao{// creer par le developpeur
    @Override
    public double getData() {
        System.out.println("version base de données");
        double temp = 23;
        return temp;
    }

}
