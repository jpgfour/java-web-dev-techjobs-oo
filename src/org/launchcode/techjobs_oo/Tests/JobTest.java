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
    Job testJob6;
    Job testJob7;

    @Before
    public void createJobObjects(){
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob4 = new Job("Regulatory Publisher", new Employer("MNK"), new Location("Hazelwood"), new PositionType("Reg Ops"), new CoreCompetency("deadline-driven"));
        testJob5 = new Job("Regulatory Publisher", new Employer("MNK"), new Location("Hazelwood"), new PositionType("Reg Ops"), new CoreCompetency("deadline-driven"));
        testJob6 = new Job(null, new Employer("Unknown Worlds"), new Location(null), new PositionType(""), new CoreCompetency(""));
        testJob7 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobID(){
        assertFalse(testJob1.getId() == testJob2.getId());
        assertTrue(testJob2.getId() == (testJob1.getId() + 1));

    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(testJob3.getId() != 0);
        //no need to test for type int as its primitive and would cause a runtime error if it WASN'T int
        assertTrue(testJob3.getName() == "Product tester");
        assertTrue(testJob3.getName() instanceof String);
        assertTrue(testJob3.getEmployer().getValue() == "ACME");
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation().getValue() == "Desert");
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType().getValue() == "Quality control");
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency().getValue() == "Persistence");
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
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
    @Test
    public void toStringPrintsDataNotAvailableIfFieldIsEmpty(){
        //System.out.println(testJob6.toString());
        //no need to test for empty ID field as it can't be left empty or overwritten to empty (no setter parameter)
        //5 settable fields tested
        assertTrue(testJob6.toString().contains("Name: Data not available\n"));
        //Employer test won't trigger "Data not available" so as to not trigger "OOPS" result coded as part of the bonus.
        assertTrue(testJob6.toString().contains("Employer: Unknown Worlds\n"));
        assertTrue(testJob6.toString().contains("Location: Data not available\n"));
        assertTrue(testJob6.toString().contains("Position Type: Data not available\n"));
        assertTrue(testJob6.toString().contains("Core Competency: Data not available\n"));
    }
    //*****bonus test*****
    @Test
    public void toStringPrintsOOPSIfOnlyIDFieldHasData(){
        //System.out.println(testJob7.toString());
        assertTrue(testJob7.toString() == "OOPS! This job does not seem to exist.");
    }

}
