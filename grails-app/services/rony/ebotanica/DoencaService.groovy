package rony.ebotanica

import grails.gorm.services.Service

@Service(Doenca)
interface DoencaService {

    Doenca get(Serializable id)

    List<Doenca> list(Map args)

    Long count()

    void delete(Serializable id)

    Doenca save(Doenca doenca)

}