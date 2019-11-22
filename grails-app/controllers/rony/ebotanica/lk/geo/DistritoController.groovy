package rony.ebotanica.lk.geo

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DistritoController {

    DistritoService distritoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond distritoService.list(params), model:[distritoCount: distritoService.count()]
    }

    def show(Long id) {
        respond distritoService.get(id)
    }

    def save(Distrito distrito) {
        if (distrito == null) {
            render status: NOT_FOUND
            return
        }

        try {
            distritoService.save(distrito)
        } catch (ValidationException e) {
            respond distrito.errors, view:'create'
            return
        }

        respond distrito, [status: CREATED, view:"show"]
    }

    def update(Distrito distrito) {
        if (distrito == null) {
            render status: NOT_FOUND
            return
        }

        try {
            distritoService.save(distrito)
        } catch (ValidationException e) {
            respond distrito.errors, view:'edit'
            return
        }

        respond distrito, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        distritoService.delete(id)

        render status: NO_CONTENT
    }
}
