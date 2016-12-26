package ru.sbtqa.tag.apifactory.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.apifactory.exception.ApiRestException;
import ru.sbtqa.tag.apifactory.repositories.Bullet;
import ru.sbtqa.tag.qautils.properties.Props;

/**
 *
 *
 */
public class RestFormImpl implements Rest {

    private static final Logger log = LoggerFactory.getLogger(RestFormImpl.class);

    @Override
    public Bullet get(String url, Map<String, String> headers) throws ApiRestException {
        return fire("GET", url, headers, null, null);
    }

    @Override
    public Bullet post(String url, Map<String, String> headers, Object body) throws ApiRestException {
        return fire("POST", url, headers, body, null);
    }

    @Override
    public Bullet put(String url, Map<String, String> headers, Object body) throws ApiRestException {
        return fire("PUT", url, headers, body, null);
    }

    @Override
    public Bullet patch(String url, Map<String, String> headers, Object body) throws ApiRestException {
        return fire("PATCH", url, headers, body, null);
    }

    @Override
    public Bullet delete(String url, Map<String, String> headers) throws ApiRestException {
        return fire("DELETE", url, headers, null, null);
    }

    private Bullet fire(String method, String url, Map<String, String> headers, Object body, Proxy proxy) throws ApiRestException {
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod(method);
            connection.setDoOutput(true);

            //add request header
            if (null != headers && !headers.isEmpty()) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    connection.setRequestProperty(header.getKey(), header.getValue());
                }
            }

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencodingd");
            StringBuilder postData = new StringBuilder();
            String encoding = Props.get("api.encoding");
            for (Map.Entry<String, String> param : ((Map<String, String>) body).entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), encoding));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), encoding));
            }
            byte[] postDataBytes = postData.toString().getBytes(encoding);
            connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            connection.getOutputStream().write(postDataBytes);

            log.info("Sending '" + method + "' request to URL : {}", URLDecoder.decode(url, encoding));
            log.info("Body is : {}", body);

            StringBuilder response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), encoding))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                log.info("Get response: {}", response.toString());
                
                Bullet bullet = new Bullet(null, response.toString());
                return bullet;
            } catch (IOException e) {
                log.error("Response return an error", e);
            }
        } catch (IOException ex) { 
            throw new ApiRestException("There are a problem with fire rest request", ex);
        }
        return null;
    }
}