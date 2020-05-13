package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;
    Job testJob5;

    @Before
    public void createJobObjects(){
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob4 = new Job("Regulatory Publisher", new Employer("MNK"), new Location("Hazelwood"), new PositionType("Reg Ops"), new CoreCompetency("deadline-driven"));
        testJob5 = new Job("Regulatory Publisher", new Employer("MNK"), new Location("Hazelwood"), new PositionType("Reg Ops"), new CoreCompetency("deadline-driven"));
    }

    @Test
    public void testSettingJobID(){
        assertFalse(testJob1 == testJob2);

    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(testJob3.getName() == "Product tester");
        assertTrue(testJob3.getEmployer().getValue() == "ACME");
        assertTrue(testJob3.getLocation().getValue() == "Desert");
        assertTrue(testJob3.getPositionType().getValue() == "Quality control");
        assertTrue(testJob3.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(testJob4.equals(testJob5));
        assertFalse(testJob5.equals(testJob4));
    }

    //toString tests
    @Test
    public void toStringStartsAndEndsWithBlankLine(){
        assertTrue(testJob3.toString().endsWith("\n"));
        assertTrue(testJob3.toString().startsWith("\n"));
    }
    @Test
    public void toStringContainsEachFieldLabelPlusDataOnOneLinePerField(){
        assertTrue(testJob3.toString().contains("ID: "+testJob3.getId()+"\n"));
        assertTrue(testJob3.toString().contains("Name: "+"Product tester"+"\n"));
        assertTrue(testJob3.toString().contains("Employer: "+"ACME"+"\n"));
        assertTrue(testJob3.toString().contains("Location: "+"Desert"+"\n"));
        assertTrue(testJob3.toString().contains("Position Type: "+"Quality control"+"\n"));
        assertTrue(testJob3.toString().contains("Core Competency: "+"Persistence"+"\n"));
    }

}
