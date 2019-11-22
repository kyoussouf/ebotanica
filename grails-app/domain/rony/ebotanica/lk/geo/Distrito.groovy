package rony.ebotanica.lk.geo

class Distrito {

	Provincia provincia
	String nome
    static constraints = {
    	provincia()
    	nome(unique:true)
    }

}
