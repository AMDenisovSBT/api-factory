package ru.sbtqa.tag.apifactory.stepdefs.en;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import ru.sbtqa.tag.apifactory.exception.ApiException;
import ru.sbtqa.tag.apifactory.stepdefs.GenericStepDefs;


public class StepDefs extends GenericStepDefs {

    /**
     * {@inheritDoc}
     */
    @Override
    @And("^user sends request (?:for|to|about) \\(([^)]*)\\)$")
    public void userSendRequestNoParams(String action) throws ApiException {
        super.userSendRequestNoParams(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @And("^user sends request (?:for|to|about) \\(([^)]*)\\) with parameters:?$")
    public void userSendRequestTableParam(String action, DataTable dataTable) throws ApiException {
        super.userSendRequestTableParam(action, dataTable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @And("^system returns \"([^\"]*)\"$")
    public void userValidate(String rule) throws ApiException {
        super.userValidate(rule);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @And("^system returns \"([^\"]*)\" with parameters:?$")
    public void userValidateTable(String rule, DataTable dataTable) throws ApiException {
        super.userValidateTable(rule, dataTable);
    }
}
