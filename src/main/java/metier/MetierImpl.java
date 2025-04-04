package metier;

import dao.DaoImpl;
import dao.IDao;

public class MetierImpl implements Imetier{
    // couplage faible
    private IDao dao ; // valeur par def est null => nous voulons pas specifier la classe !

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res=t * 23 ;
        return res;
    }
    //pour injecter dans la var dao un objet d'une classe qui implemente linterface IDao
    public void setDao(IDao dao){
        this.dao = dao;
    }
}
