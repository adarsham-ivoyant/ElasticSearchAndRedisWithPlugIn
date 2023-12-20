package org.example;

import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to CRUD project using Elastic search" );
        Operation operation = new Operation();
        try {
            operation.connectionRequest();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
