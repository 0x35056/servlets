package ru.aplana;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.aplana.logic.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

// {"id" : 2}

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

        int id = jobj.get("id").getAsInt();

        System.out.println(id);

        model.del(id);

        /*if (id > 0) {

            if (id > model.getFromList().size()) {

                pw.print("Такого пользователя не существует");

            } else {

                model.del(id);

            }

        } else {

            pw.print("ID должен быть больше нуля!");

        }*/
    }
}