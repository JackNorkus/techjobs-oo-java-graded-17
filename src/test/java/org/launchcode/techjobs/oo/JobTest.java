package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job = new Job();
        Job anotherJob = new Job();
        assertNotEquals(job.getId(), anotherJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotNull(job.getName());
        assertNotNull(job.getEmployer());
        assertNotNull(job.getLocation());
        assertNotNull(job.getPositionType());
        assertNotNull(job.getCoreCompetency());
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().toString(), "ACME");
        assertEquals(job.getLocation().toString(), "Desert");
        assertEquals(job.getPositionType().toString(), "Quality control");
        assertEquals(job.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job.equals(anotherJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(true, job.toString().endsWith(System.lineSeparator()));
        assertEquals(true, job.toString().startsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job();
        assertTrue(job.toString().contains("ID: " + job.getId()));
        assertTrue(job.toString().contains("Name: " + job.getName()));
        assertTrue(job.toString().contains("Employer: " + job.getEmployer()));
        assertTrue(job.toString().contains("Location: " + job.getLocation()));
        assertTrue(job.toString().contains("Position Type: " + job.getPositionType()));
        assertTrue(job.toString().contains("Core Competency: " + job.getCoreCompetency()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
        String testString = System.lineSeparator() + "ID: " + job.getId() + "\n" +
                "Name: " + job.getName() + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + job.getLocation() + "\n" +
                "Position Type: " + "Data not available" + "\n" +
                "Core Competency: " + job.getCoreCompetency() + System.lineSeparator();
        assertEquals(job.toString(), testString);
    }
}
