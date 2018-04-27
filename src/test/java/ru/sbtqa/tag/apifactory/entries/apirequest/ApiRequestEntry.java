package ru.sbtqa.tag.apifactory.entries.apirequest;

import org.junit.Assert;
import ru.sbtqa.tag.apifactory.ApiEntry;
import ru.sbtqa.tag.apifactory.ApiFactory;
import ru.sbtqa.tag.apifactory.annotation.ApiAction;
import ru.sbtqa.tag.apifactory.annotation.ApiRequestHeader;
import ru.sbtqa.tag.apifactory.annotation.ApiRequestParam;
import ru.sbtqa.tag.apifactory.annotation.ApiValidationRule;
import ru.sbtqa.tag.apifactory.rest.HTTP;
import ru.sbtqa.tag.apifactory.utils.Default;
import ru.sbtqa.tag.parsers.JsonParser;
import ru.sbtqa.tag.parsers.core.exceptions.ParserException;

@ApiAction(method = HTTP.GET, path = "client/get-with-params?" + Default.PARAMETER_NAME1 + "=%param", title = "api request test")
public class ApiRequestEntry extends ApiEntry {

    @ApiRequestParam(title = "some title")
    private String param = Default.PARAMETER_VALUE1;

    @ApiRequestHeader(header = Default.HEADER_NAME)
    private String header = Default.HEADER_VALUE;

    @ApiValidationRule(title = "result")
    public void validate() throws ParserException {
        JsonParser parser = new JsonParser();
        String response = ApiFactory.getApiFactory().getResponseRepository().getBody(this.getClass());

        String expectedResult = header + param;
        String actualResult = parser.read(response, "$.result");

        Assert.assertEquals(expectedResult, actualResult);
    }


}
