package rony.ebotanica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LocalizacaoServiceSpec extends Specification {

    LocalizacaoService localizacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Localizacao(...).save(flush: true, failOnError: true)
        //new Localizacao(...).save(flush: true, failOnError: true)
        //Localizacao localizacao = new Localizacao(...).save(flush: true, failOnError: true)
        //new Localizacao(...).save(flush: true, failOnError: true)
        //new Localizacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //localizacao.id
    }

    void "test get"() {
        setupData()

        expect:
        localizacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Localizacao> localizacaoList = localizacaoService.list(max: 2, offset: 2)

        then:
        localizacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        localizacaoService.count() == 5
    }

    void "test delete"() {
        Long localizacaoId = setupData()

        expect:
        localizacaoService.count() == 5

        when:
        localizacaoService.delete(localizacaoId)
        sessionFactory.currentSession.flush()

        then:
        localizacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Localizacao localizacao = new Localizacao()
        localizacaoService.save(localizacao)

        then:
        localizacao.id != null
    }
}
