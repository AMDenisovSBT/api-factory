package ru.sbtqa.tag.apifactory;

import ru.sbtqa.tag.qautils.properties.Props;

/**
 *
 *
 */
public class ApiFactory {

    private static ApiFactoryCore apiFactoryHandler;
    private static String apiRequestUrl = Props.get("api.baseurl");

    /**
     * Get api factory
     *
     * @return api factory
     */
    public static ApiFactoryCore getApiFactory() {
        if (null == apiFactoryHandler) {
            apiFactoryHandler = new ApiFactoryCore(Props.get("api.entries.package"));
        }
        return apiFactoryHandler;
    }

    /**
     * Get api request url
     *
     * @return request url
     */
    public static String getApiRequestUrl() {
        return apiRequestUrl;
    }

    /**
     * Set api request url
     *
     * @param apiRequestUrl request url
     */
    public static void setApiRequestUrl(String apiRequestUrl) {
        ApiFactory.apiRequestUrl = apiRequestUrl;
    }
}
