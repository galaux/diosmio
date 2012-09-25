package net.alaux.diosmio.services.dao.db.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.alaux.diosmio.com.entity.Artifact;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext-db.xml",
	"ArtifactDaoTest.xml" })
public class ArtifactDaoTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JpaTransactionManager transactionManager;

    @Autowired
    ArtifactDao artifactDao;

    private TransactionStatus status;

    @Before
    public void setup() {

	status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
    }

    @After
    public void tearDown() {
	transactionManager.rollback(status);
    }

    @Test
    public void testCreate() {
	Artifact artifact = new Artifact();
	artifact.setName("fdsklmg");
	artifactDao.create(artifact);

	Artifact result = em.find(Artifact.class, artifact.getId());
	Assert.assertNotNull(result);
	Assert.assertEquals(artifact.getId(), result.getId());
	Assert.assertEquals(artifact.getName(), result.getName());
    }

    @Test
    public void testGet() {
	Artifact artifact = new Artifact();
	artifact.setName("fdhlm");
	em.persist(artifact);

	Assert.assertNotNull(artifactDao.get(artifact.getId()));
    }

    @Test
    public void testGetAll() {

	Artifact artifact = new Artifact();
	artifact.setName("cdgsfml");
	em.persist(artifact);
	Artifact artifact2 = new Artifact();
	artifact.setName("vfk");
	em.persist(artifact2);

	List<Artifact> resultList = artifactDao.getAll();
	Assert.assertEquals(2, resultList.size());
    }

    @Test
    public void testUpdate() {

	Artifact artifact = new Artifact();
	artifact.setName("vfdhjyuikj");
	em.persist(artifact);

	artifact.setName("NEW");
	artifactDao.update(artifact);

	Artifact result = em.find(Artifact.class, artifact.getId());
	Assert.assertEquals("NEW", result.getName());
    }

    @Test
    public void testDeleteArtifact() {
	Artifact artifact = new Artifact();
	artifact.setName("klme");
	em.persist(artifact);

	Assert.assertNotNull(em.find(Artifact.class, artifact.getId()));
	artifactDao.delete(artifact);
	Assert.assertNull(em.find(Artifact.class, artifact.getId()));
    }

    @Test
    public void testDeleteById() {
	Artifact artifact1 = new Artifact();
	artifact1.setName("gfdhjlmd");
	em.persist(artifact1);
	Artifact artifact2 = new Artifact();
	artifact2.setName("klmte");
	em.persist(artifact2);
	Artifact artifact3 = new Artifact();
	artifact3.setName("plrkls");
	em.persist(artifact3);

	Assert.assertEquals(3, artifactDao.getAll().size());

	Assert.assertNotNull(em.find(Artifact.class, artifact2.getId()));
	artifactDao.delete(artifact2.getId());

	Assert.assertEquals(2, artifactDao.getAll().size());
    }
}
