package rony.ebotanica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TratamentoController {

    TratamentoService tratamentoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tratamentoService.list(params), model:[tratamentoCount: tratamentoService.count()]
    }

    def show(Long id) {
        respond tratamentoService.get(id)
    }

    def save(Tratamento tratamento) {
        if (tratamento == null) {
            render status: NOT_FOUND
            return
        }

        try {
            tratamentoService.save(tratamento)
        } catch (ValidationException e) {
            respond tratamento.errors, view:'create'
            return
        }

        respond tratamento, [status: CREATED, view:"show"]
    }

    def update(Tratamento tratamento) {
        if (tratamento == null) {
            render status: NOT_FOUND
            return
        }

        try {
            tratamentoService.save(tratamento)
        } catch (ValidationException e) {
            respond tratamento.errors, view:'edit'
            return
        }

        respond tratamento, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        tratamentoService.delete(id)

        render status: NO_CONTENT
    }
}
