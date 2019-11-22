package rony.ebotanica.lk

import grails.gorm.services.Service

@Service(PartePlanta)
interface PartePlantaService {

    PartePlanta get(Serializable id)

    List<PartePlanta> list(Map args)

    Long count()

    void delete(Serializable id)

    PartePlanta save(PartePlanta partePlanta)

}