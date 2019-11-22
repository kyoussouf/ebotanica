package rony.ebotanica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LocalizacaoController {

    LocalizacaoService localizacaoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond localizacaoService.list(params), model:[localizacaoCount: localizacaoService.count()]
    }

    def show(Long id) {
        respond localizacaoService.get(id)
    }

    def save(Localizacao localizacao) {
        if (localizacao == null) {
            render status: NOT_FOUND
            return
        }

        try {
            localizacaoService.save(localizacao)
        } catch (ValidationException e) {
            respond localizacao.errors, view:'create'
            return
        }

        respond localizacao, [status: CREATED, view:"show"]
    }

    def update(Localizacao localizacao) {
        if (localizacao == null) {
            render status: NOT_FOUND
            return
        }

        try {
            localizacaoService.save(localizacao)
        } catch (ValidationException e) {
            respond localizacao.errors, view:'edit'
            return
        }

        respond localizacao, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        localizacaoService.delete(id)

        render status: NO_CONTENT
    }
}
