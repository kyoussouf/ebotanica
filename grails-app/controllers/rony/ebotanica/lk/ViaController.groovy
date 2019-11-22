package rony.ebotanica.lk

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ViaController {

    ViaService viaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond viaService.list(params), model:[viaCount: viaService.count()]
    }

    def show(Long id) {
        respond viaService.get(id)
    }

    def save(Via via) {
        if (via == null) {
            render status: NOT_FOUND
            return
        }

        try {
            viaService.save(via)
        } catch (ValidationException e) {
            respond via.errors, view:'create'
            return
        }

        respond via, [status: CREATED, view:"show"]
    }

    def update(Via via) {
        if (via == null) {
            render status: NOT_FOUND
            return
        }

        try {
            viaService.save(via)
        } catch (ValidationException e) {
            respond via.errors, view:'edit'
            return
        }

        respond via, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        viaService.delete(id)

        render status: NO_CONTENT
    }
}
