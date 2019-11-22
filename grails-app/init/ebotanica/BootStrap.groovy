package ebotanica

import rony.ebotanica.lk.geo.*
import rony.ebotanica.lk.*
import rony.ebotanica.*


class BootStrap {

    def init = { servletContext ->

    	criarVias()
    	criarPartePlanta()
    	criarFaixasEtarias()
    	criarLocalizacoesGeograficas()
    	criarPlantas()
    	criarDoencas()
    }

    def criarVias(){
    	Via.findOrSaveByDescricao("Oral")
    	Via.findOrSaveByDescricao("Retal")
    	Via.findOrSaveByDescricao("Ocular")
    	Via.findOrSaveByDescricao("Inalatoria")
    }

    def criarPartePlanta(){
    	PartePlanta.findOrSaveByDescricao("Folhas")
    	PartePlanta.findOrSaveByDescricao("Flores")
    	PartePlanta.findOrSaveByDescricao("Raizes")
    	PartePlanta.findOrSaveByDescricao("Tronco")
    }

    def criarFaixasEtarias(){
    	FaixaEtaria.findOrSaveByDescricao("Adulto")
    	FaixaEtaria.findOrSaveByDescricao("Criancas")
    }

    def criarLocalizacoesGeograficas(){

		Provincia maputo = 	Provincia.findOrSaveByNome("Maputo")
		Provincia gaza = 	Provincia.findOrSaveByNome("Gaza")
		Provincia inhambane = 	Provincia.findOrSaveByNome("Inhambane")
		Provincia tete = 	Provincia.findOrSaveByNome("Tete")

		Distrito.findOrSaveByNomeAndProvincia("Marracuene",maputo)
		Distrito.findOrSaveByNomeAndProvincia("Boane",maputo)
		Distrito.findOrSaveByNomeAndProvincia("Inharime",inhambane)
		Distrito.findOrSaveByNomeAndProvincia("Inhassoro",inhambane)
		Distrito.findOrSaveByNomeAndProvincia("Bilene",gaza)
		Distrito.findOrSaveByNomeAndProvincia("Chibuto",gaza)
		Distrito.findOrSaveByNomeAndProvincia("Zumbo",tete)
		Distrito.findOrSaveByNomeAndProvincia("Marara",tete)
    }

    def criarPlantas(){
    	Planta.findOrSaveByNome("Beijo da Mulata")
    	Planta.findOrSaveByNome("Eucalipto")
    	Planta.findOrSaveByNome("Cacana")
    }

    def criarDoencas(){
    	Doenca.findOrSaveByNome("Dor De Estomago")
    	Doenca.findOrSaveByNome("Reumatismo")
    	Doenca.findOrSaveByNome("Diabetes")
    	Doenca.findOrSaveByNome("Malaria")
    	Doenca.findOrSaveByNome("Gripe")
    }

    def destroy = {
    }
}
