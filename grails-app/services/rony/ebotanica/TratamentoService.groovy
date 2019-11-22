package rony.ebotanica

import grails.gorm.services.Service

@Service(Tratamento)
interface TratamentoService {

    Tratamento get(Serializable id)

    List<Tratamento> list(Map args)

    Long count()

    void delete(Serializable id)

    Tratamento save(Tratamento tratamento)

}