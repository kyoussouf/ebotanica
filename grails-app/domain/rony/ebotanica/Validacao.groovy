package rony.ebotanica

class Validacao {


	Planta planta
	Tratamento tratamento
	String comentario 
	Boolean deAcordo

    static constraints = {
    	planta()
    	tratamento()
    	comentario()
    	deAcordo()
    }
}
