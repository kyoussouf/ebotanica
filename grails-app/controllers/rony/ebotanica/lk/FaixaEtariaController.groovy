package rony.ebotanica.lk

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FaixaEtariaController {

    FaixaEtariaService faixaEtariaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond faixaEtariaService.list(params), model:[faixaEtariaCount: faixaEtariaService.count()]
    }

    def show(Long id) {
        respond faixaEtariaService.get(id)
    }

    def save(FaixaEtaria faixaEtaria) {
        if (faixaEtaria == null) {
            render status: NOT_FOUND
            return
        }

        try {
            faixaEtariaService.save(faixaEtaria)
        } catch (ValidationException e) {
            respond faixaEtaria.errors, view:'create'
            return
        }

        respond faixaEtaria, [status: CREATED, view:"show"]
    }

    def update(FaixaEtaria faixaEtaria) {
        if (faixaEtaria == null) {
            render status: NOT_FOUND
            return
        }

        try {
            faixaEtariaService.save(faixaEtaria)
        } catch (ValidationException e) {
            respond faixaEtaria.errors, view:'edit'
            return
        }

        respond faixaEtaria, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        faixaEtariaService.delete(id)

        render status: NO_CONTENT
    }
}
