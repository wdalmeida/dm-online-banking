package fr.esipe.restservices.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class AccessAdvisor {

	private final Logger logger = LoggerFactory.getLogger(AccessAdvisor.class);

	private RestTemplate restTemplate;
	private static String url = "http://localhost:25003/data-access";

	public AccessAdvisor(){
		restTemplate = new RestTemplate();
	}

	/**
	 * This method send and retrieve the response for all HTTP method GET
	 *
	 * @param query
	 * @param getClass Class of the Object return by the request
	 * @return Object
	 */
	public <T> T getEntity(String query,Class<T> getClass){
		T object = restTemplate.getForObject(url+query, getClass);

		if( object != null){
			logger.debug("Response for Get Request: " + object.toString());
		}else{
			logger.debug("Response for Get Request: NULL");
		}
		return object;
	}

	/**
	 * This method send and retrieve the response for all HTTP method POST
	 * @param query
	 * @param something
	 * @param getClass
	 * @param <T>
	 * @return
	 */
	public <T> T addEntity(String query, Object something, Class<T> getClass){
		T object = restTemplate.postForObject(url+query,something,getClass);
		if( object != null){
			logger.debug("Response for Get Request: " + object.toString());
		}else{
			logger.debug("Response for Get Request: NULL");
		}
		return object;
	}

	/**
	 *
	 * This method send and retrieve the response for all HTTP method PUT
	 * @param query
	 * @param something
	 */
	public void  putEntity(String query, Object something){
		restTemplate.put(url+query,something);
	}
}
