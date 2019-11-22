package rony.ebotanica.lk

import grails.gorm.services.Service

@Service(Via)
interface ViaService {

    Via get(Serializable id)

    List<Via> list(Map args)

    Long count()

    void delete(Serializable id)

    Via save(Via via)

}