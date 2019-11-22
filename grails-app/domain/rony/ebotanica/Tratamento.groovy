package rony.ebotanica

import rony.ebotanica.lk.*

class Tratamento {

//	static hasMany = [doencas: Doenca,faixasEtarias:FaixaEtaria]

	Planta planta
	PartePlanta parte
	Via via
	String modoUtilizazao


    static constraints = {
    	planta()
    	parte()
    	via()
    	modoUtilizazao()
    }
}
