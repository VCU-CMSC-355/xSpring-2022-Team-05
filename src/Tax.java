package com.company;
        /* *********************************************************************************** *
        *   Tax Calculator Module
        *
        * Component: Task Manager
        * *********************************************************************************** *
        * Function:  This process calculates the tax due depending on the total wages of the user
        and the tax year. By taking the total wages of the user and the Respective year,
        it returns the user's tax due.
        *
        *----------------------------------------------------------------------------------------------------------------------------------------
        *    Input: Total Wages, Tax Year
        *
        *    Output: Tax Due
        *
        *----------------------------------------------------------------------------------------------------------------------------------------
        *    Author: Abtin Ghaffari
        *    Review: Edwin, Rohan, Pratham, Joel
        *    Version 04/20/2022   CMCS 355
        * ************************************************************************************ */

import java.io.*;
import java.util.Scanner;

public class Tax {

    public static void main(String[] args) throws InterruptedException, IOException {
        /*********************************************************
         * Declare Variables:
         *    proc -- stores process information about external service call
         *    in -- stores output stream from external service execution
         *    err -- stores error stream from external service execution
         *    brInput -- reads contents of in
         *    brError -- reads contents of err
         *********************************************************/


        String year = args[0];
        String status = args[1];
        String income = args[2];

        //check for error and if year contains error, throw error command.
        if (year.length() != 4) {
            Process proc2 = Runtime.getRuntime().exec("java -jar service.jar error" + year);
            proc2.waitFor();

            InputStream in2 = proc2.getInputStream();
            InputStream err2 = proc2.getErrorStream();
            BufferedReader br2Input = new BufferedReader(new InputStreamReader(in2));
            BufferedReader br2Error = new BufferedReader(new InputStreamReader(err2));

            //System.out.println(yearStatus);
            String line;
            while ((line = br2Input.readLine()) != null) {
                System.out.println(line);
            }

            while ((line = br2Error.readLine()) != null) {
                System.out.println(line);

            }
        } else {

            //Append argument 2 onto argument 1
            String yearStatus = year + status + ".txt";
            args[0] = yearStatus;
            args[1] = income;

            Process proc = Runtime.getRuntime().exec("java -jar service.jar tb", args);
            proc.waitFor();
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();
            BufferedReader brInput = new BufferedReader(new InputStreamReader(in));
            BufferedReader brError = new BufferedReader(new InputStreamReader(err));

            //System.out.println(yearStatus);
            String line;
            while ((line = brInput.readLine()) != null) {
                System.out.println(line);
            }

            while ((line = brError.readLine()) != null) {
                System.out.println(line);

            }
        }

    }
}
