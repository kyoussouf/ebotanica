package rony.ebotanica.lk

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PartePlantaController {

    PartePlantaService partePlantaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond partePlantaService.list(params), model:[partePlantaCount: partePlantaService.count()]
    }

    def show(Long id) {
        respond partePlantaService.get(id)
    }

    def save(PartePlanta partePlanta) {
        if (partePlanta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            partePlantaService.save(partePlanta)
        } catch (ValidationException e) {
            respond partePlanta.errors, view:'create'
            return
        }

        respond partePlanta, [status: CREATED, view:"show"]
    }

    def update(PartePlanta partePlanta) {
        if (partePlanta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            partePlantaService.save(partePlanta)
        } catch (ValidationException e) {
            respond partePlanta.errors, view:'edit'
            return
        }

        respond partePlanta, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        partePlantaService.delete(id)

        render status: NO_CONTENT
    }
}
