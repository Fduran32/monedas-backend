package com.duoc.monedas.Lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ClimaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        // Ciudades chilenas que necesitas consultar
        String[] ciudades = {"Santiago", "Chillan", "Punta_Arenas", "Valparaiso", "La_Serena", "Coquimbo", "Temuco", "Puerto_Varas"};
        StringBuilder jsonResultado = new StringBuilder("{");

        for (int i = 0; i < ciudades.length; i++) {
            String ciudad = ciudades[i];
            try {
                // CAMBIO AQUÍ: Se agrega &m al final para forzar grados Celsius (°C)
                URL url = new URL("https://wttr.in/" + ciudad + "?format=3&m");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(4000);

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String linea = in.readLine();
                in.close();

                // Limpiamos el nombre para que en el JSON se vea bonito
                jsonResultado.append("\"").append(ciudad.replace("_", " ")).append("\": \"").append(linea.trim()).append("\"");
            } catch (Exception e) {
                jsonResultado.append("\"").append(ciudad.replace("_", " ")).append("\": \"No disponible temporalmente\"");
            }
            if (i < ciudades.length - 1) jsonResultado.append(", ");
        }
        jsonResultado.append("}");

        // Preparamos la respuesta HTTP estructurada para AWS
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(200);
        response.setHeaders(headers);
        response.setBody(jsonResultado.toString());

        return response;
    }
}