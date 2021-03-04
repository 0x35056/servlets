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
import java.util.Map;

@WebServlet(urlPatterns = "/del")
public class ServletDelete extends HttpServlet {

    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer jb = new StringBuffer();

        String line;

        request.setCharacterEncoding("UTF-8");

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

        request.setCharacterEncoding("UTF-8");

        int id = jobj.get("id").getAsInt();

        response.setContentType("application/json;charset=utf-8");

        PrintWriter pw = response.getWriter();

        if (id > 0) {

            if (id > model.getFromList().size()) {

                pw.print("Такого пользователя не существует");

            } else {

                for (Map.Entry<Integer, User> entry : model.getFromList().entrySet()) {
                    if (entry.getKey() == id)
                        model.getFromList().remove(id);
                        pw.print(gson.toJson(model.getFromList()));
                }
            }

        } else {

            pw.print("ID должен быть больше нуля!");

        }
    }
}
