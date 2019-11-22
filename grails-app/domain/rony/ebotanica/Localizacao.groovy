package rony.ebotanica

import rony.ebotanica.lk.geo.*

class Localizacao {

	Planta planta
	Provincia provincia
	Distrito distrito

    static constraints = {
    	planta()
    	provincia()
    	distrito(nullable:true)
    }
}
