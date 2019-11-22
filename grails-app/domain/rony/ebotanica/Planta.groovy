package rony.ebotanica

class Planta {


//	static hasMany = [localizacoes: Localizacao,validacoes:Validacao]

	String nome 
	String descricao
	String propriedades

    static constraints = {
    	nome(unique:true)
    	descricao(nullable:true)
    	propriedades(nullable:true)
    }

}
