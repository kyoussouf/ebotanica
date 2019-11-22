package rony.ebotanica.lk.geo

import grails.gorm.services.Service

@Service(Distrito)
interface DistritoService {

    Distrito get(Serializable id)

    List<Distrito> list(Map args)

    Long count()

    void delete(Serializable id)

    Distrito save(Distrito distrito)

}