package org.codingstyle.api.test;

import org.codingstyle.api.config.AppConfig;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestConfig.class})
public abstract class TestAbstract {
    @Inject private ApplicationContext applicationContext;
    @Inject protected TestGenerator generator;

    @Rule public ExpectedException expectedException = ExpectedException.none();

    @After
    public void tearDown() {
        TestTools.releaseTime();
        this.emptyDatabase();
    }

    private void emptyDatabase() {
        Map<String, JpaRepository> repositories = this.applicationContext.getBeansOfType(JpaRepository.class);
        repositories.values().forEach(JpaRepository::deleteAll);
    }
}
