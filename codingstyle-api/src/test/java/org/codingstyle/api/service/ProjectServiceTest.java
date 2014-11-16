package org.codingstyle.api.service;

import org.codingstyle.api.test.TestAbstract;
import org.codingstyle.api.exception.IllegalInputException;
import org.codingstyle.api.exception.ResourceNotFoundException;
import org.codingstyle.core.model.Project;
import org.joda.time.DateTime;
import org.junit.Test;

import javax.inject.Inject;

import static org.codingstyle.api.test.TestTools.assertSameEntities;
import static org.codingstyle.api.test.TestTools.randomString;
import static org.codingstyle.api.test.TestTools.setCurrentDateNow;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProjectServiceTest extends TestAbstract {
    @Inject private ProjectService projectService;

    @Test
    public void create_with_empty_name_fails() {
        // GIVEN

        // THEN
        this.expectedException.expect(IllegalInputException.class);

        // WHEN
        this.projectService.create("");
    }

    @Test
    public void create_with_a_name_longer_than_128_chars_fails() {
        // GIVEN

        // THEN
        this.expectedException.expect(IllegalInputException.class);

        // WHEN
        this.projectService.create(randomString(129));
    }

    @Test
    public void create_saves_the_project() {
        // GIVEN
        String name = "My awesome project";
        DateTime now = setCurrentDateNow();

        // WHEN
        Project project = this.projectService.create(name);

        // THEN
        assertNotNull(project.getId());
        assertEquals(now, project.getCreatedDate());
        assertEquals(now, project.getUpdatedDate());
        assertNotNull(project.getExternId());
        assertEquals(name, project.getName());
    }

    @Test
    public void getByExternId_with_null_id_fails() {
        // GIVEN

        // THEN
        this.expectedException.expect(IllegalInputException.class);

        // WHEN
        this.projectService.getByExternId(null);
    }

    @Test
    public void getByExternId_with_unknown_id_fails() {
        // GIVEN

        // THEN
        this.expectedException.expect(ResourceNotFoundException.class);

        // WHEN
        this.projectService.getByExternId("some_id");
    }

    @Test
    public void getByExternId_returns_the_project() {
        // GIVEN
        Project project = this.generator.project();

        // WHEN
        Project result = this.projectService.getByExternId(project.getExternId());

        // THEN
        assertSameEntities(project, result);
    }
}
