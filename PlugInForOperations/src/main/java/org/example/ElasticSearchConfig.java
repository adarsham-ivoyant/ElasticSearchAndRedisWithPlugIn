package org.example;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ElasticSearchConfig {

    private String HTTP="http";
    private String hostName;
    private Integer portNumber;
    private String scheme;

    public ElasticSearchConfig(String hostName, Integer portNumber, String scheme) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.scheme = scheme;
    }

    static String index="temp_db";

    public void insertData(String documentId,Map<String, Object> document){
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(this.hostName, this.portNumber, this.scheme))))
        {
            //String documentId = "document_id";
            CRUDOperations crudOperations = new Operations(client);
            crudOperations.indexDocument(index, documentId, document);
            System.out.println("data added successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getParticularData(String documentId){
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(this.hostName, this.portNumber, this.scheme))))
        {
            CRUDOperations crudOperations = new Operations(client);
            Map<String, Object> getDocuments = crudOperations.getDocument(index,documentId);
            System.out.println("Retrieved Document: " + getDocuments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getAllData(){
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(this.hostName, this.portNumber, this.scheme))))
        {
            CRUDOperations crudOperations = new Operations(client);
            Map<String, Object> getDocuments = crudOperations.getAllDocument(index);
            System.out.println("Retrieved Document: " + getDocuments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteParticularData(String docId){
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(this.hostName, this.portNumber, this.scheme))))
        {
            CRUDOperations crudOperations = new Operations(client);
            crudOperations.deleteDocument(index, docId);
            System.out.println(docId+" deleted successfully ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


