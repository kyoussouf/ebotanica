package rony.ebotanica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PlantaController {

    PlantaService plantaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond plantaService.list(params), model:[plantaCount: plantaService.count()]
    }

    def show(Long id) {
        respond plantaService.get(id)
    }

    def save(Planta planta) {
        if (planta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            plantaService.save(planta)
        } catch (ValidationException e) {
            respond planta.errors, view:'create'
            return
        }

        respond planta, [status: CREATED, view:"show"]
    }

    def update(Planta planta) {
        if (planta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            plantaService.save(planta)
        } catch (ValidationException e) {
            respond planta.errors, view:'edit'
            return
        }

        respond planta, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        plantaService.delete(id)

        render status: NO_CONTENT
    }
}
