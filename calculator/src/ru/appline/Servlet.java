package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/post")
public class Servlet extends HttpServlet {

    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer jb = new StringBuffer();
        String line;

        String result = "result";

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        System.out.println(jb);

        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

        request.setCharacterEncoding("UTF-8");

        int a = jobj.get("a").getAsInt();
        int b = jobj.get("b").getAsInt();
        String math = jobj.get("math").getAsString();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();

        switch(math) {
            case ("+"):
                model.sum(result, a, b);
                pw.print(gson.toJson(model.getFromList()));
                break;
            case ("-"):
                model.sub(result, a, b);
                pw.print(gson.toJson(model.getFromList()));
                break;
            case ("*"):
                model.mul(result, a, b);
                pw.print(gson.toJson(model.getFromList()));
                break;
            case ("/"):
                model.div(result, a, b);
                pw.print(gson.toJson(model.getFromList()));
                break;
        }
    }
}