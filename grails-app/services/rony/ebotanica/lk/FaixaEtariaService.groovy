package rony.ebotanica.lk

import grails.gorm.services.Service

@Service(FaixaEtaria)
interface FaixaEtariaService {

    FaixaEtaria get(Serializable id)

    List<FaixaEtaria> list(Map args)

    Long count()

    void delete(Serializable id)

    FaixaEtaria save(FaixaEtaria faixaEtaria)

}