package fr.esipe.restservices.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class AccessClient {
	private final Logger logger = LoggerFactory.getLogger(AccessClient.class);

	private RestTemplate restTemplate;

	public AccessClient(){
		restTemplate = new RestTemplate();
	}

	/**
	 * This method send and retrieve the response for all HTTP method GET
	 *
	 * @param getClass Class of the Object return by the request
	 * @return Object
	 */
	public <T> T getEntity(String url,Class<T> getClass){

		T object = restTemplate.getForObject(url, getClass);

		if( object != null){
			logger.debug("Response for Get Request: " + object.toString());
		}else{
			logger.debug("Response for Get Request: NULL");
		}
		return object;
	}

	/**
	 * This methode send a delete request
	 *
	 * @param url Url to be called to call delete service
	 * @throws URISyntaxException
	 */
	public void deleteEntity(String url) throws URISyntaxException {
		logger.debug("DELETE PATH : "+ url);
		URI uri = new URI(url);
		logger.debug("uri : " + uri);
		restTemplate.delete(uri);
	}

	public void addEntity(String url, HttpRequest request, Class<?> getClass){
		restTemplate.postForObject(url,request,getClass);
	}
}
