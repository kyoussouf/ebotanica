package rony.ebotanica.lk.geo

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProvinciaController {

    ProvinciaService provinciaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond provinciaService.list(params), model:[provinciaCount: provinciaService.count()]
    }

    def show(Long id) {
        respond provinciaService.get(id)
    }

    def save(Provincia provincia) {
        if (provincia == null) {
            render status: NOT_FOUND
            return
        }

        try {
            provinciaService.save(provincia)
        } catch (ValidationException e) {
            respond provincia.errors, view:'create'
            return
        }

        respond provincia, [status: CREATED, view:"show"]
    }

    def update(Provincia provincia) {
        if (provincia == null) {
            render status: NOT_FOUND
            return
        }

        try {
            provinciaService.save(provincia)
        } catch (ValidationException e) {
            respond provincia.errors, view:'edit'
            return
        }

        respond provincia, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        provinciaService.delete(id)

        render status: NO_CONTENT
    }
}
