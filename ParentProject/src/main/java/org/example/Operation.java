package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Operation {

    static Scanner scanner = new Scanner(System.in);

    // Creating connection
    public void connectionRequest() throws IOException {
        System.out.print("Please Enter Host Name : ");
        String hostName = scanner.nextLine();
        System.out.print("Please Enter Port Number : ");
        Integer portNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please Enter Schema : ");
        String schema = scanner.nextLine();



        if(hostName.equalsIgnoreCase("localhost") && portNumber==9200){
            System.out.println("enter the choice");
            System.out.println("1.insert\n" +
                    "2.getData\n" +
                    "3.getAllData" +
                    "4.Delete\n");
            int ch=scanner.nextInt();

            ElasticSearchConfig elasticSearchConfig=new ElasticSearchConfig(hostName,portNumber,schema);

            switch (ch){
                case 1:
                    System.out.println("enter the doc Id");
                    String id=scanner.next();
                    System.out.println("enter the name");
                    String name=scanner.next();
                    System.out.println("enter the age");
                    Integer age=scanner.nextInt();
                    System.out.println("enter the city");
                    String city=scanner.next();
                    Map<String, Object> document = new HashMap<>();
                    document.put("name", name);
                    document.put("age", age);
                    document.put("city", city);
                    elasticSearchConfig.insertData(id,document);
                    break;

                case 2:
                    System.out.println("enter the docId for data");
                    String docId=scanner.next();
                    elasticSearchConfig.getParticularData(docId);
                    break;

                case 3:
                    System.out.println("All data from Database");
                    elasticSearchConfig.getAllData();
                    break;

                case 4:
                    System.out.println("enter the id for delete the data");
                    String id2=scanner.next();
                    elasticSearchConfig.deleteParticularData(id2);
                default:
                    System.out.println("enter the choice properly");
            }
        }else{
            System.out.println("give correct hostName and password");
        }

    }
}
