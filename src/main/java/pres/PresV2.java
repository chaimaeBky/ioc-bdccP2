package pres;

import dao.IDao;
import metier.Imetier;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.SortedMap;

public class PresV2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("config.txt"));
            String daoClassName = sc.nextLine();
            Class cDao= Class.forName(daoClassName); // instanciation dynamique !
            IDao dao= (IDao) cDao.getConstructor().newInstance();// comme on a faire new constucteur
            // getConstructor() our specifier quel constructeur
            // casting puisque (cDao.getConstructor().newInstance();) de type object
            System.out.println(dao.getData());


            String metierClassName = sc.nextLine();
            Class cMetier= Class.forName(metierClassName);
            Imetier metier  = (Imetier) cMetier.getConstructor(IDao.class).newInstance(dao);
            /* instanciation via le setter :
                        Imetier metier  = (Imetier) cMetier.getConstructor().newInstance();
                        Method setDao= Cmetier.getDeclaredMethod("setDao", IDao.class (le type de parametre));
                        setDao.invoke(metier , dao); // invoke = execute
             */
            System.out.println("Res="+metier.calcul());




        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
