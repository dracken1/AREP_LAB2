package edu.escuelaing.arem;

import static spark.Spark.*;
import spark.utils.IOUtils;


public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");

        String indexHTML = "<!DOCTYPE html>\n" +
                "<html><head>\n" +
                "      <title>Calculos Estadisticos</title>\n" +
                "   </head><body>\n" +
                "      <p><b>Calculo de Datos Estadisticos</b></p>\n" +
                "      <h2>Mean and Standar Deviation Web App!</h2>\n" +
                "      <p>Aplicación Web para calcular la media y la desviacion estandar de un conjunto de datos dados por el usuario.\n\n</p>\n" +
                "      <p>\n\nClick the next link to start entering your data:</p>\n" +
                "      <a href = \"/calcdata\" target = \"_self\">Enter Your Data</a>\n" +
                "   </body></html>";

        get("/index", (req, res) -> indexHTML);
        /*get("/calcdata", (req, res) -> calcdataPage(req, res));
        get("/results", (req, res) -> resultsPage(req,res));*/




    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }




    /*private static String calcdataPage(Request req, Response res){
        String calcdataHTML = "<!DOCTYPE html>\n" +
                "<html><head>\n" +
                "      <title>Calculos Estadisticos</title>\n" +
                "   </head><body>\n" +
                "      <p><b>Calculo de Datos Estadisticos</b></p>\n" +
                "      <h2>Ingrese sus Datos a la Aplicacion:</h2>\n" +
                "      <p>\n\nIngrese dos conjuntos de números que quiera calcular:</p>\n" +
                "      <p>***Recuerde ingresar los numeros separados por espacios en blanco y con \".\" puntos decimales en caso de requerirlo.</p>\n" +
                "       <form action=\"/results\">\n" +
                "           Set #1 of Numbers:<br>\n" +
                "           <input type=\"text\" placeholder=\"Separated by spaces\" name=\"inputData1\" ><br>\n" +
                "           Set #2 of Numbers:<br>\n" +
                "           <input type=\"text\" placeholder=\"Separated by spaces\" name=\"inputData2\" ><br><br>\n" +
                "           <input type=\"submit\" value=\"Calculate!\">\n" +
                "       </form>" +
//"      <a href = \"http://localhost:9999/results\" target = \"_self\">Ver Resultados</a>\n" +
                "   </body></html>";
        return calcdataHTML;
    }

    *//*

     *//*
    private static String resultsPage(Request req, Response res){
        String set1 = req.queryParams("inputData1");
        String set2 = req.queryParams("inputData2");

        StatisCalcs calculator= new StatisCalcs();

        set_1 = calculator.readInput(set1);
        set_1_mean = calculator.media(set_1);
        set_1_StdDev = calculator.desEstandar(set_1);

        set_2 = calculator.readInput(set2);
        set_2_mean = calculator.media(set_2);
        set_2_StdDev = calculator.desEstandar(set_2);

        System.out.println("SET 1:");
        System.out.println("Mean: "+ set_1_mean);
        System.out.println("Standar Deviation: "+ set_1_StdDev);

        System.out.println("SET 2:");
        System.out.println("Mean: "+ set_2_mean);
        System.out.println("Standar Deviation: "+ set_2_StdDev);

        String resultsHTML = "<!DOCTYPE html>\n" +
                "<html><head>\n" +
                "      <title>Calculos Estadisticos</title>\n" +
                "   <style>" +
                "       table, th, td {" +
                "           border: 1px solid black;" +
                "           border-colapse: collapse;" +
                "       }" +
                "       th, td {" +
                "           padding: 5px;" +
                "       }" +
                "       th {" +
                "           text-align: left;" +
                "       }" +
                "   </style>" +
                "   </head><body>\n" +
                "      <p><b>Calculo de Datos Estadisticos</b></p>\n" +
                "       <h2>Results</h2>" +
                "       <p>Mean and Standar Deviation values</p>\n\n" +


                "       <table style=\"width:30%\">\n" +
                "           <tr>\n" +
                "               <th>Results</th>\n" +
                "               <th><b>Set #1</b></th> \n" +
                "               <th><b>Set #2</b></th>\n" +
                "           </tr>\n" +
                "           <tr>\n" +
                "               <td><b>Mean</b></td>\n" +
                "               <td>" + set_1_mean + "</td> \n" +
                "               <td>" + set_2_mean + "</td>\n" +
                "           </tr>\n" +
                "           <tr>\n" +
                "               <td><b>Standard Deviation</b></td>\n" +
                "               <td>" + set_1_StdDev + "</td> \n" +
                "               <td>" + set_2_StdDev + "</td>\n" +
                "           </tr>\n" +
                "       </table>" +
                "   </body>\n" +
                "	\n" +
                "</html>";

        return resultsHTML;
    }*/
}

