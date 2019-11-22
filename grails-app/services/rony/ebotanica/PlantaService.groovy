package rony.ebotanica

import grails.gorm.services.Service

@Service(Planta)
interface PlantaService {

    Planta get(Serializable id)

    List<Planta> list(Map args)

    Long count()

    void delete(Serializable id)

    Planta save(Planta planta)

}