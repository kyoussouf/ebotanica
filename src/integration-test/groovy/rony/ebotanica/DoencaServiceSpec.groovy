package rony.ebotanica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DoencaServiceSpec extends Specification {

    DoencaService doencaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Doenca(...).save(flush: true, failOnError: true)
        //new Doenca(...).save(flush: true, failOnError: true)
        //Doenca doenca = new Doenca(...).save(flush: true, failOnError: true)
        //new Doenca(...).save(flush: true, failOnError: true)
        //new Doenca(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //doenca.id
    }

    void "test get"() {
        setupData()

        expect:
        doencaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Doenca> doencaList = doencaService.list(max: 2, offset: 2)

        then:
        doencaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        doencaService.count() == 5
    }

    void "test delete"() {
        Long doencaId = setupData()

        expect:
        doencaService.count() == 5

        when:
        doencaService.delete(doencaId)
        sessionFactory.currentSession.flush()

        then:
        doencaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Doenca doenca = new Doenca()
        doencaService.save(doenca)

        then:
        doenca.id != null
    }
}
