package rony.ebotanica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ValidacaoController {

    ValidacaoService validacaoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond validacaoService.list(params), model:[validacaoCount: validacaoService.count()]
    }

    def show(Long id) {
        respond validacaoService.get(id)
    }

    def save(Validacao validacao) {
        if (validacao == null) {
            render status: NOT_FOUND
            return
        }

        try {
            validacaoService.save(validacao)
        } catch (ValidationException e) {
            respond validacao.errors, view:'create'
            return
        }

        respond validacao, [status: CREATED, view:"show"]
    }

    def update(Validacao validacao) {
        if (validacao == null) {
            render status: NOT_FOUND
            return
        }

        try {
            validacaoService.save(validacao)
        } catch (ValidationException e) {
            respond validacao.errors, view:'edit'
            return
        }

        respond validacao, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        validacaoService.delete(id)

        render status: NO_CONTENT
    }
}
