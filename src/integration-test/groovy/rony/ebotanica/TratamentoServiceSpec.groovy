package rony.ebotanica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TratamentoServiceSpec extends Specification {

    TratamentoService tratamentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tratamento(...).save(flush: true, failOnError: true)
        //new Tratamento(...).save(flush: true, failOnError: true)
        //Tratamento tratamento = new Tratamento(...).save(flush: true, failOnError: true)
        //new Tratamento(...).save(flush: true, failOnError: true)
        //new Tratamento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tratamento.id
    }

    void "test get"() {
        setupData()

        expect:
        tratamentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tratamento> tratamentoList = tratamentoService.list(max: 2, offset: 2)

        then:
        tratamentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tratamentoService.count() == 5
    }

    void "test delete"() {
        Long tratamentoId = setupData()

        expect:
        tratamentoService.count() == 5

        when:
        tratamentoService.delete(tratamentoId)
        sessionFactory.currentSession.flush()

        then:
        tratamentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tratamento tratamento = new Tratamento()
        tratamentoService.save(tratamento)

        then:
        tratamento.id != null
    }
}
