package rony.ebotanica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DoencaController {

    DoencaService doencaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond doencaService.list(params), model:[doencaCount: doencaService.count()]
    }

    def show(Long id) {
        respond doencaService.get(id)
    }

    def save(Doenca doenca) {
        if (doenca == null) {
            render status: NOT_FOUND
            return
        }

        try {
            doencaService.save(doenca)
        } catch (ValidationException e) {
            respond doenca.errors, view:'create'
            return
        }

        respond doenca, [status: CREATED, view:"show"]
    }

    def update(Doenca doenca) {
        if (doenca == null) {
            render status: NOT_FOUND
            return
        }

        try {
            doencaService.save(doenca)
        } catch (ValidationException e) {
            respond doenca.errors, view:'edit'
            return
        }

        respond doenca, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        doencaService.delete(id)

        render status: NO_CONTENT
    }
}
