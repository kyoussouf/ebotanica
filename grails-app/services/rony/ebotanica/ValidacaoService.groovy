package rony.ebotanica

import grails.gorm.services.Service

@Service(Validacao)
interface ValidacaoService {

    Validacao get(Serializable id)

    List<Validacao> list(Map args)

    Long count()

    void delete(Serializable id)

    Validacao save(Validacao validacao)

}