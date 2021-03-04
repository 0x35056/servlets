package ru.aplana;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.aplana.logic.Model;
import ru.aplana.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/put")
public class ServletPut extends HttpServlet {

    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer jb = new StringBuffer();
        String line;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        System.out.println(jb);

        request.setCharacterEncoding("UTF-8");

        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

        int id = Integer.parseInt(request.getParameter("id"));
        String name = jobj.get("name").getAsString();
        String surname = jobj.get("surname").getAsString();
        double salary = jobj.get("salary").getAsDouble();

        response.setContentType("application/json;charset=utf-8");

        PrintWriter pw = response.getWriter();

        if (id > 0) {

            if (id > model.getFromList().size()) {

                pw.print("Такого пользователя не существует");
            } else {

                User user = new User(name, surname, salary);
                model.add(user, id);
                pw.print(gson.toJson(model.getFromList().get(id)));
            }
        } else {

            pw.print("ID должен быть больше нуля!");
        }
    }
}
