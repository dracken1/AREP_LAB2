package edu.escuelaing.arem;

import static spark.Spark.*;

import spark.Request;
import spark.Response;
import spark.utils.IOUtils;


public class SparkWebApp {

    private static MyMeanStandardLinkedList list1 = new MyMeanStandardLinkedList();
    private static double meanResult = 0.0;
    private static double standardDResult = 0.0;

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");



        get("/index", (req, res) -> indexpage(req,res));
        get("/results", (req, res) -> resultsPage(req,res));




    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }

    public static String indexpage(Request req, Response res){
        String indexHTML = "<!DOCTYPE html>\n" +
                "<html><head>\n" +
                "      <title>mean and standardD</title>\n" +
                "   </head><body>\n<h2>Mean and Standar Deviation</h2>\n" +
                "      <p>Web application capable of calculating the mean and standard deviation of a set of numbers\n\n</p>\n" +
                "       <form action=\"/results\">\n" +
                "           First set of Numbers:<br>\n" +
                "           <input type=\"text\" placeholder=\"Separated by spaces\" name=\"inputData1\" ><br>\n" +
                "           <input type=\"submit\" value=\"Calculate!\">\n" +
                "       </form>"+
                "       <a href = \"http://localhost:5000/results\" target = \"_self\">See Results</a>\n" +
                "   </body></html>";
        return indexHTML;
    }

    public static void readInputLineSplittedBySpacesAndAddToList(String set, MyMeanStandardLinkedList list) {
        for (String str : set.split(" ")) {
            double doubletoadd = Double.parseDouble(str);
            System.out.println("double: " + doubletoadd);
            list.add(doubletoadd);
        }


        /*

        */
    }

    public static String resultsPage(Request req, Response res){
        String set1 = req.queryParams("inputData1");
        readInputLineSplittedBySpacesAndAddToList(set1,list1);
        meanResult = list1.calcMean();
        standardDResult = list1.calcStandard();

        System.out.println("Mean: "+ meanResult);
        System.out.println("StandardD: "+ standardDResult);

        String resultsHTML = "<!DOCTYPE html>\n" +
                "<html><head>\n" +
                "      <title>mean and standardD</title>\n" +
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
                "           </tr>\n" +
                "           <tr>\n" +
                "               <td><b>Mean</b></td>\n" +
                "               <td>" + meanResult + "</td> \n" +
                "           </tr>\n" +
                "           <tr>\n" +
                "               <td><b>Standard Deviation</b></td>\n" +
                "               <td>" + standardDResult + "</td> \n" +
                "           </tr>\n" +
                "       </table>" +
                "   </body></html>";

        return resultsHTML;
    }
}

