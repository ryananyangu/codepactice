/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jovixe.samples;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author ranyangu
 */
public class Samples {
    
    
    
    public static HashMap<String, String> updatedPostMethod(String url, String payload,
			HashMap<String, String> headers) {
        //        LOGGER.log(Level.INFO,Utils.prelogString(Utils.getCodelineNumber(), "Sending Http Post Request to >> " + url));
		
		HashMap<String, String> response = new HashMap<String, String>();
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost httppost = new HttpPost(url);
		CloseableHttpResponse responseBody = null;
		int status = 0;

		try {
			StringEntity entity = new StringEntity(payload, StandardCharsets.UTF_8);

                        headers.keySet().forEach((header) -> {
                            httppost.addHeader(header, headers.get(header));
                    });

			httppost.setEntity(entity);

			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			responseBody = httpclient.execute(httppost);

			// Compare the 2 calls for body and response below
			String body = responseHandler.handleResponse(responseBody);
			// String body = EntityUtils.toString(responseBody.getEntity());
			status = responseBody.getStatusLine().getStatusCode();
			response.put("Status", "" + status);
			response.put("Body", body);

		} catch (UnsupportedEncodingException | ClientProtocolException  e) {
          //              LOGGER.log(Level.SEVERE, e.getMessage(),e);
                        System.out.println(Arrays.toString(e.getStackTrace()));
			response.put("Status", "" + status);
			response.put("Body", e.getMessage());
		} catch (IOException e) {
                    System.out.println(Arrays.toString(e.getStackTrace()));
	//		LOGGER.log(Level.SEVERE,Utils.prelogString("", Utils.getCodelineNumber(), (long) 0.0, "Error Fetching",e.getMessage()));
			response.put("Status", "" + status);
			response.put("Body", e.getMessage());
		} finally {
			// TODO: fix finally
		}
	//	LOGGER.log(Level.INFO,Utils.prelogString(Utils.getCodelineNumber(), "Recieved response processing  >> " + response.get("Status")));
		return response;

	}

    public static HashMap<String, String> updatedPostMethod(String url, String payload,
            List<HashMap<String, String>> headers) {
        //LOGGER.log(Level.INFO,Utils.prelogString(Utils.getCodelineNumber(), "Sending Http Post Request to >> " + url));

        HashMap<String, String> response = new HashMap<>();
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse responseBody = null;
        int status = 0;

        try {
            StringEntity entity = new StringEntity(payload, StandardCharsets.UTF_8);

            headers.stream().map((header) -> header.values().toArray()).forEachOrdered((head_arr) -> {
                httppost.addHeader((String) head_arr[0], (String) head_arr[1]);
            });

            httppost.setEntity(entity);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            responseBody = httpclient.execute(httppost);

            // Compare the 2 calls for body and response below
            String body = responseHandler.handleResponse(responseBody);
            // String body = EntityUtils.toString(responseBody.getEntity());
            status = responseBody.getStatusLine().getStatusCode();
            response.put("Status", "" + status);
            response.put("Body", body);

        } catch (UnsupportedEncodingException | ClientProtocolException e) {
            //LOGGER.log(Level.SEVERE, e.getMessage(),e);
            response.put("Status", "" + status);
            response.put("Body", e.getMessage());
        } catch (IOException e) {
            //LOGGER.log(Level.SEVERE,Utils.prelogString("", Utils.getCodelineNumber(), (long) 0.0, "Error Fetching",e.getMessage()));
            response.put("Status", "" + status);
            response.put("Body", e.getMessage());
        } finally {
            // TODO: fix finally
        }
        //LOGGER.log(Level.INFO,Utils.prelogString(Utils.getCodelineNumber(), "Recieved response processing  >> " + response.get("Status")));
        return response;

    }

}
