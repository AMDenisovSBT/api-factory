package ru.sbtqa.tag.apifactory.stepdefs.ru;

import cucumber.api.DataTable;
import cucumber.api.java.bg.И;
import ru.sbtqa.tag.apifactory.exception.ApiException;
import ru.sbtqa.tag.apifactory.stepdefs.GenericStepDefs;


public class StepDefs extends GenericStepDefs {

    /**
     * {@inheritDoc}
     */
    @Override
    @И("^(?:пользователь |он )?отправляет запрос \\(([^)]*)\\)$")
    public void userSendRequestNoParams(String action) throws ApiException {
        super.userSendRequestNoParams(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @И("^(?:пользователь |он )?отправляет запрос \\(([^)]*)\\) с параметрами:?$")
    public void userSendRequestTableParam(String action, DataTable dataTable) throws ApiException {
        super.userSendRequestTableParam(action, dataTable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @И("^система возвращает ответ \"([^\"]*)\"$")
    public void userValidate(String rule) throws ApiException {
        super.userValidate(rule);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @И("^система возвращает ответ \"([^\"]*)\" с параметрами:?$")
    public void userValidateTable(String rule, DataTable dataTable) throws ApiException {
        super.userValidateTable(rule, dataTable);
    }
}
