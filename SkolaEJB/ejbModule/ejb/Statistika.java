package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Statistika
 */
@Singleton
@LocalBean
public class Statistika implements StatistikaLocal {
	
	int brojPoziva=0;
    /**
     * Default constructor. 
     */
    public Statistika() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void brojPoziva() {
		brojPoziva++;
	}

}
