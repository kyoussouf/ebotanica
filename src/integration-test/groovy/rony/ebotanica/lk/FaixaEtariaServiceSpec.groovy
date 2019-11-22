package rony.ebotanica.lk

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FaixaEtariaServiceSpec extends Specification {

    FaixaEtariaService faixaEtariaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new FaixaEtaria(...).save(flush: true, failOnError: true)
        //new FaixaEtaria(...).save(flush: true, failOnError: true)
        //FaixaEtaria faixaEtaria = new FaixaEtaria(...).save(flush: true, failOnError: true)
        //new FaixaEtaria(...).save(flush: true, failOnError: true)
        //new FaixaEtaria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //faixaEtaria.id
    }

    void "test get"() {
        setupData()

        expect:
        faixaEtariaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<FaixaEtaria> faixaEtariaList = faixaEtariaService.list(max: 2, offset: 2)

        then:
        faixaEtariaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        faixaEtariaService.count() == 5
    }

    void "test delete"() {
        Long faixaEtariaId = setupData()

        expect:
        faixaEtariaService.count() == 5

        when:
        faixaEtariaService.delete(faixaEtariaId)
        sessionFactory.currentSession.flush()

        then:
        faixaEtariaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        FaixaEtaria faixaEtaria = new FaixaEtaria()
        faixaEtariaService.save(faixaEtaria)

        then:
        faixaEtaria.id != null
    }
}
