package pl.edu.pk.cybermom;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class Server extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private class Coords {
        public double lon, lat;
    }

    private Map<String, Coords> map = new HashMap<>();
    double lon;
    double lat;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap().toString());

        if (request.getParameter("longitude") != null) {
            lon = Double.parseDouble(request.getParameter("longitude"));
            lat = Double.parseDouble(request.getParameter("latitude"));
        } else {
            response.setContentType("application/json");
            JSONObject object = new JSONObject();
            try {
                object.put("latitude", lat);
                object.put("longitude", lon);
                response.getWriter().write(object.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

}
